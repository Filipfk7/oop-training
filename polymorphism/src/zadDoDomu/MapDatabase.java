package zadDoDomu;

import java.util.*;

public class MapDatabase implements Database {

    //te same poprawki co dla kolekcji w ListDb
    private final Map<String,User> users = new HashMap<>();

    //Analogiczne poprawki -- TODO: User musi być stringiem, jak temu zapobiedz?
    @Override
    public void insert(User user) {
//        if (c1 && c2 && c3)
        if (!UserCredentialsValidator.INSTANCE.isValid(user)) return;
        if(users.containsKey(user.getEmail())) {
            users.put(user.getEmail(), user);
        }
    }

    //Analogicznie do odpowiednika z ListDb
    @Override
    public void update(String email, User newUserData) {
        if(!UserCredentialsValidator.INSTANCE.isValid(newUserData)) return;
        if(newUserData.getEmail().equals(email)) {
            users.put(email, newUserData);
            return;
        }
        users.remove(email);
        users.put(newUserData.getEmail(), newUserData);
    }

    //Analogiczne poprawki -- TODO: Nie mogę złapać klucza na streamie(element -> element.getKey()).
    // TODO: Karze mi zwracać string, gdy optional jest Userem.
    @Override
    public Optional<User> findByEmail(String email) {
//        users.remove("key1");
//        users.put("nowyKlucz", nowyUSer)
//        Optional<User> user = users.keySet().stream().filter(element -> element.equals(email)).findFirst();
//            if(user.isPresent()){
//                return user;
//            }
//            else {
//                System.out.println("No user with this email in database");
//            }
            return Optional.empty();
        }

    //Analogiczne poprawki
    @Override
    public void delete(String email) {
        findByEmail(email).ifPresent(users::remove);
    }

    //Analogicznie do odpowiednika z ListDb TODO: Czy jest sens robić copyOf, skoro tworze liste userList, która jest kopią mapy?
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        for (Map.Entry<String,User> entry : users.entrySet()) {
            userList.add(entry.getValue());
            System.out.println(entry.getValue());
        }
        return userList;
    }
}
