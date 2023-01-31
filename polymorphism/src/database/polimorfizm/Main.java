package database.polimorfizm;

import utils.MockData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        testDatabase(new ListDatabase());
        testDatabase(new MapDatabase());
    }

    private static void testDatabase(Database database) {
        MockData.INSTANCE.mockUsers().forEach(database::insert);

        //        long start1 = System.nanoTime();
//        Set<String> subjects = database.findAll().stream()
//                .filter(element -> element.getSubjects().contains(Subject.IT))
//                .map(User::getEmail)
//                .collect(Collectors.toSet());
//        System.out.println(subjects);
//        long end1 = System.nanoTime();
//        long time1 = end1 - start1;
//        System.out.println(time1);
//
//        long start2 = System.nanoTime();
//        database.findAll().stream()
//                .filter(element -> element.getSubjects().contains(Subject.IT))
//                .map(User::getEmail)
//                .forEach(System.out::println);
//        long end2 = System.nanoTime();
//        long time2 = end2 - start2;
//        System.out.println(time2);
//
//        System.out.println(time2-time1);

//        database.findAll().stream()
//                .filter(user -> hasMostSubjects(database.findAll(), user))
//                .findFirst()
//                .map(User::getEmail)
//                .ifPresentOrElse(System.out::println, () -> System.out.println("Brak studentów"));

        System.out.println("Wszystkie przedmioty naszych uczniów");

        System.out.println(database.findAll().stream()
                .map(User::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet()));

//        System.out.println(database.findAll());
//        database.update("filip@gmail.com", new User("philip@wp.pl","password","Filip", "Filipek"));
//        database.findByEmail("philip@wp.pl");
//        System.out.println(database.findAll());
//        database.delete("philip@wp.pl");
//        System.out.println(database.findAll());
    }

    private static boolean hasMostSubjects(Collection<User> users, User user) {
        return users.stream()
                .map(User::getSubjects)
                .map(Collection::size)
                .max(Comparator.naturalOrder())
                .map(max -> user.getSubjects().size() == max)
                .orElse(false);
    }
}
