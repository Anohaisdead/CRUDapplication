package web.dao;

import web.model.User;
import org.springframework.stereotype.Repository;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        System.out.println("EntityManager in getAllUsers: " + (entityManager != null));
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public void updateUser(Long id, User updateUser) {
        User upUser = getUserById(id);
        upUser.setFirstName(updateUser.getFirstName());
        upUser.setLastName(updateUser.getLastName());
        upUser.setEmail(updateUser.getEmail());
        entityManager.merge(upUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}