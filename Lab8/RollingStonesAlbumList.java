package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RollingStonesAlbumList {
    private List<Album> albumList = new ArrayList<>();

    public void ParseCSVFile() throws FileNotFoundException, IOException {

        FileReader filereader = new FileReader("./albumlist.csv");
        CSVReader csvReader = new CSVReader(filereader);
        String[] line;
        csvReader.readNext();
        int counter = 1;
        while ((line = csvReader.readNext()) != null) {
            List<String> genres = new ArrayList<>();
            genres.add(line[4]);
            //StringBuilder stringBuilder = new StringBuilder();
            albumList.add(new Album(counter, Integer.valueOf(line[1]), line[2], line[3], genres));
            counter++;

        }
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public static void main(String[] args) throws IOException {
        RollingStonesAlbumList rollingStonesAlbumList = new RollingStonesAlbumList();
        rollingStonesAlbumList.ParseCSVFile();
        System.out.println(rollingStonesAlbumList.albumList);
    }


}
