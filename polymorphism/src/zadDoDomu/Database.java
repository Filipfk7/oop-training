package zadDoDomu;

import java.util.List;
import java.util.Optional;

public interface Database {
    void insert(User user);
    void update(String email, User user);
    Optional<User> findByEmail(String email);
    void delete(String email);
    List<User> findAll();
}
