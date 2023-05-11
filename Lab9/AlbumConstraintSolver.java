package org.example;

import jakarta.persistence.EntityManager;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.variables.BoolVar;
import org.example.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumConstraintSolver {
    private static final int yearDifference = 10;

    public List<Album> findKAlbumsWithConstraints(List<Album> albums, int k) {
        Model model = new Model("Find K Albums with Constraints");

        int n = albums.size();

        BoolVar[] selected = model.boolVarArray(n);

        // Constraint: At least k albums should be selected
        model.sum(selected, ">=", k).post();

        // Constraints for albums that cannot be part of the solution together
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!canBePartOfSolution(albums.get(i), albums.get(j))) {
                    model.arithm(selected[i], "+", selected[j], "<=", 1).post();
                }
            }
        }

        Solution solution = model.getSolver().findSolution();

        if (solution != null) {
            List<Album> selectedAlbums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i].getValue() == 1) {
                    selectedAlbums.add(albums.get(i));
                }
            }
            return selectedAlbums;
        }

        return null;
    }

    private boolean canBePartOfSolution(Album album1, Album album2) {
        if (album1.getTitle().charAt(0) == album2.getTitle().charAt(0) && Math.abs(album1.getReleaseYear() - album2.getReleaseYear()) < yearDifference)
            return true;
        return false;
    }

    public static void main(String[] args) {
        EntityManager entityManager = PersistenceManager.getEntityManagerFactory().createEntityManager();
        List<Album> allAlbums = entityManager.createQuery("SELECT a FROM Album a").getResultList();
        AlbumConstraintSolver albumConstraintSolver = new AlbumConstraintSolver();
        List<Album> solution = albumConstraintSolver.findKAlbumsWithConstraints(allAlbums, 15);
        System.out.println(solution);

    }
}
