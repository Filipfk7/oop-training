package database.polimorfizm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ListDatabase implements Database {

    private final List<User> users = new ArrayList<>();

    @Override
    public void insert(User user) {
        if (!UserCredentialsValidator.INSTANCE.isValid(user)) {
            return;
        }
        boolean userExists = findByEmail(user.getEmail()).isPresent();
        if(userExists) {
            return;
        }
        users.add(user);
    }

    @Override
    public void update(String email, User newUserData) {
        if(!UserCredentialsValidator.INSTANCE.isValid(newUserData)) {
            return;
        }
        findByEmail(email).ifPresent(user -> {
            user.setFirstName(newUserData.getFirstName());
            user.setPassword(newUserData.getPassword());
            user.setEmail(newUserData.getEmail());
            user.setLastName(newUserData.getLastName());
            user.setSubjects(newUserData.getSubjects());
        });
    }

    /**
     shift + Home, zaznacza do poczatku linijki, shift + end, zaznacza nam do konca,
     ctrl lewo, prawo, co słowo
     */
    @Override
    public Optional<User> findByEmail(String email) {
        if(email == null) {
            return Optional.empty();
        }
        return users.stream()
                .filter(Objects::nonNull)
                .filter(user -> email.equals(user.getEmail()))
                .findFirst();
    }

    @Override
    public void delete(String email) {
       findByEmail(email).ifPresent(users::remove);
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(users);
    }
}
