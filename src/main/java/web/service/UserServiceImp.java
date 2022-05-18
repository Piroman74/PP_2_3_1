package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.models.User;

import java.util.List;
@Component
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User show(long id) {
        return userDao.show(id);
    }

    @Override
    public List<User> index() {
        return userDao.index();
    }

}
