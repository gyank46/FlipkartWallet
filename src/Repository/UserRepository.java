package Repository;

import Models.User;

import java.util.HashMap;

public class UserRepository {
    HashMap<String, User> users = new HashMap<String, User>();

    public void addUser(User user){
        users.put(user.getName(), user);
    }

    public User getUser(String name){
        return users.get(name);
    }

    public void updateUser(User user){
        users.put(user.getName(), user);
    }

    void deleteUser(User user){
        users.remove(user.getName());
    }

}
