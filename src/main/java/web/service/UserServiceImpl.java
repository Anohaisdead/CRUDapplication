package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import lombok.Data;
import lombok.NoArgsConstructor;
import web.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
@NoArgsConstructor(force = true)
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(Long id, User updateUser) {
        userDao.updateUser(id, updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
