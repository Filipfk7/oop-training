package utils;

import database.polimorfizm.Subject;
import database.polimorfizm.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public enum MockData {

    INSTANCE;

    public List<User> mockUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("maciek@wp.pl", "pass", "Maciek", "Maciek", Set.of(Subject.GEOGRAPHY)));
        users.add(new User("pawel@gmail.com","haslo", "Pawel", "Pawel", Set.of(Subject.IT, Subject.PE, Subject.MATH)));
        users.add(new User("piotr@wp.pl", "321", "Piotr", "Piotr", Set.of(Subject.IT)));
        users.add(new User("filip@gmail.com", "555", "Filip", "Filip", Set.of(Subject.HISTORY, Subject.MATH,  Subject.IT, Subject.PE)));
        return users;
    }
}
