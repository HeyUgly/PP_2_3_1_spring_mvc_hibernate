package michaelchursin.spring.DAO;

import michaelchursin.spring.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();
    public User findById(int id);
    public void save(User user);
    public void update(int id, User user);
    public void delete(int id);
}
