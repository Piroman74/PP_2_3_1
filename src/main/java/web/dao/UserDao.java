package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);
    public User show(long id);
    public void update(long id, User user);
    List<User> index();
}
