package service;

import dao.UserDao;
import entity.User;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-07-29
 */
public class UserService {
    UserDao userDao = new UserDao();
    //登录
    public User login(User loginUser){

        User user = userDao.login(loginUser);
        return user;
    }

    //注册
    public User register(){
        User user = new User();
        userDao.register(user);
        return user;
    }


}
