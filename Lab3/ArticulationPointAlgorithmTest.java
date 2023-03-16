import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ArticulationPointAlgorithmTest {


    @Test
    public void simpleTest() {
        ArticulationPointAlgorithm algorithm = new ArticulationPointAlgorithm();
        Network network = new Network();
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Company> companies = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Person person = new Person(Integer.toString(i), LocalDate.parse("2020-06-10"));
            persons.add(person);
            Company company = new Company(Integer.toString(i), 90_000);
            companies.add(company);
        }
        persons.get(0).addRelationship(persons.get(1), "bestFriend");
        persons.get(0).addRelationship(persons.get(2), "bestFriend");
        persons.get(1).addRelationship(persons.get(3), "bestFriend");
        persons.get(2).addRelationship(persons.get(3), "bestFriend");

        companies.get(0).addRelationship(companies.get(1), "Business");
        companies.get(0).addRelationship(companies.get(2), "Business");
        companies.get(1).addRelationship(companies.get(3), "Business");
        companies.get(2).addRelationship(companies.get(3), "Business");

        persons.get(3).addRelationship(companies.get(2), "Employer");
        for (int i = 0; i < 4; i++) {
            network.addNode(persons.get(i));
            network.addNode(companies.get(i));

        }
        algorithm.addNetwork(network);
        Set<Node> expectedResult = new HashSet<>();
        expectedResult.add(persons.get(3));
        expectedResult.add(companies.get(2));
        Set<Node> AlgorithmResult = algorithm.findArticulationPoints();
        assertEquals(expectedResult, AlgorithmResult);
    }
}