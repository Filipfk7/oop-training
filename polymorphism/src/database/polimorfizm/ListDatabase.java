package database.polimorfizm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListDatabase implements Database {

    private final List<User> users = new ArrayList<>();



    //Insert wykonuje sie, gdy jest email i haslo oraz gdy email jest unikalny
    @Override
    public void insert(User user) {
//        if (c1 && c2 && c3)
        if (!UserCredentialsValidator.INSTANCE.isValid(user)) return;
        if(findByEmail(user.getEmail()).isEmpty() ) {
            users.add(user);
        }
    }

    @Override
    public void update(String email, User newUserData) {
        if(!UserCredentialsValidator.INSTANCE.isValid(newUserData)) return;
        findByEmail(email).ifPresent(user -> {
            user.setFirstName(newUserData.getFirstName());
            user.setPassword(newUserData.getPassword());
            user.setEmail(newUserData.getEmail());
            user.setLastName(newUserData.getLastName());
            user.setSubjects(newUserData.getSubjects());
        });
    }

    /**
     Co jesli user albo jego mail jest nullem? Zabezpiecz sie przed tym
     shift + Home, zaznacza do poczatku linijki, shift + end, zaznacza nam do konca,
     ctrl lewo, prawo, co słowo
     */

    @Override
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst();
    }

    //wykonaj remove tylko jesli user o tym mailu istnieje
    @Override
    public void delete(String email) {
       findByEmail(email).ifPresent(users::remove);
        /**
         *
         */

    }

    @Override
    public List<User> findAll() {
        return List.copyOf(users);
    }
}
