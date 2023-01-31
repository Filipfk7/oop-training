package mapstream;

import database.polimorfizm.User;
import utils.MockData;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<String, User> users = MockData.INSTANCE.mockUsers().stream()
                .collect(Collectors.toMap(User::getEmail, user -> user));

        mapSubCollections(users);
        System.out.println();
        System.out.println("-----------");
        System.out.println();
        mapStreams(users);
    }

    private static void mapStreams(Map<String, User> users) {
        List<String> emails = users.keySet().stream()
                .filter(k -> k.charAt(0) != 'p')
                .sorted()
                .collect(Collectors.toList());
        System.out.println(emails);

        System.out.println();

        List<String> passwords = users.values().stream()
                .map(User::getPassword)
                .filter(password -> password.length() >= 4)
                .collect(Collectors.toList());
        System.out.println(passwords);

        System.out.println();

        List<User> vips = users.entrySet().stream()
                .filter(e -> e.getKey().charAt(0) != 'p')
                .filter(e -> e.getValue().getPassword().length() >= 4)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(vips);
    }

    private static void mapSubCollections(Map<String, User> users) {
        Set<String> keys = users.keySet();
        System.out.println(keys);

        Collection<User> values = users.values();
        System.out.println(values);

        System.out.println();

        users.entrySet().forEach(e -> {
            String key = e.getKey();
            User value = e.getValue();
            System.out.println(key + ": " + value);
        });

        System.out.println();

        users.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
