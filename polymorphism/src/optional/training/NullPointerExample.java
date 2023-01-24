package optional.training;

import exercise.Database;
import exercise.ListDatabase;
import exercise.User;

import java.util.List;

public class NullPointerExample {
    public static void main(String[] args) {
        Database database = new ListDatabase();
        User kamil = new User();
        kamil.setEmail("user1");
        kamil.setPassword("pass1");
        kamil.setFirstName("Kamil");
        database.insert(kamil);
        database.findByEmail("user1")
                .ifPresent(user -> System.out.println(user.getFirstName()));
        database.findByEmail("user2").ifPresentOrElse(
                user -> System.out.println(user.getFirstName()),
                () -> System.out.println("Wrong email"));
        List<User> users = database.findAll();
        System.out.println(users);

        User mariusz = new User();
        mariusz.setEmail("user2");
        mariusz.setPassword("pass2");
        mariusz.setFirstName("Mariusz");
        database.insert(mariusz);
        List<User> updatedUsers = database.findAll();
        System.out.println(updatedUsers);

        users.forEach(user -> user = null);
        users = null;
        updatedUsers.forEach(user -> user = null);
        updatedUsers = null;
        database.findAll().forEach(user -> user = null);

        kamil = null;
        mariusz = null;


        User tomek = new User();
        tomek.setEmail("user3");
        tomek.setPassword("pass3");
        tomek.setFirstName("Tomek");
        database.insert(tomek);
        System.out.println(database.findAll());
        User newTomek = new User();
        newTomek.setEmail("tomek");
        newTomek.setPassword(tomek.getPassword());
        newTomek.setLastName("Nowak");
        database.update(tomek.getEmail(), newTomek);
        System.out.println(database.findByEmail(newTomek.getEmail()));
    }
}
