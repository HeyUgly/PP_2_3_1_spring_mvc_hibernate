package michaelchursin.spring.service;

import michaelchursin.spring.model.User;
import michaelchursin.spring.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(int id, User user) {
        if ((userDAO.findById(id) != null) && ((user.getId() == id))) {
            userDAO.update(id, user);
        }
    }

    @Transactional
    public void delete(int id) {
        if (userDAO.findById(id) != null) {
            userDAO.delete(id);
        }
    }
}
