import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class BiconnectedAlgorithmTest {
    @Test
    public void simpleTest(){
        BiconnectedAlgorithm algorithm = new BiconnectedAlgorithm();
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
        Set<Set<Node>> expectedResult = new HashSet<>();
        Set <Node> firstComponent = new HashSet<>();
        Set <Node> secondComponent = new HashSet<>();
        for(int i=0;i<4;i++){
            firstComponent.add(persons.get(i));
            secondComponent.add(companies.get(i));
        }
        expectedResult.add(firstComponent);
        expectedResult.add(secondComponent);
        Set<Set<Node>> algorithmResult = new HashSet<>();
        algorithmResult = algorithm.findComponents();
        assertEquals(expectedResult,algorithmResult);
    }

}