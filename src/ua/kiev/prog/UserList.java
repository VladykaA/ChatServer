package ua.kiev.prog;

import java.util.ArrayList;

public class UserList {

    private static final UserList userList = new UserList();
    private final ArrayList<User> users = new ArrayList<>();

    private UserList(){
        users.add(new User("admin", "admin"));
        users.add(new User("user1", "12345"));
    }

    public static UserList getInstance(){
        return userList;
    }

    public synchronized boolean logIn(User user){
        if(!users.contains(user)) {
            users.add(user);
            user.setStatus("online");
            System.out.println(user.getLogin() + "is added ");
            return true;
        }

        for(User u: users){
            if(user.getLogin().equals(u.getLogin()) && user.getPass().equals(u.getPass())) {
                u.setStatus("online");
                System.out.println("user logged in as " + user.getLogin());
                return true;
            }
        }
        System.out.println("Wrong password, " + user.getLogin() + " OR user is already logged in " + user.getStatus());
        return false;
    }

    public void changeStatus(String login, String status) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                user.setStatus(status);
        }
    }

    public void changeRoom(String login, String room) {
        for (User user : users) {
            if (user.getLogin().equals(login))
                user.setRoom(room);
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(User user: users)
            sb.append(user.getLogin() + " " + user.getStatus() + "next");
        return sb.toString();
    }


}
