package ru.frolov.learningcrud.dao;

import org.springframework.stereotype.Component;
import ru.frolov.learningcrud.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Vasia1"));
        people.add(new Person(++PEOPLE_COUNT, "Petia2"));
        people.add(new Person(++PEOPLE_COUNT, "Kolia3"));
        people.add(new Person(++PEOPLE_COUNT, "Katia4"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }
}
