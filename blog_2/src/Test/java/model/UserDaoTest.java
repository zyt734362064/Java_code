package model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Create with IntelliJ IDEA
 * Description:
 * User:Zyt
 * Date:2020-09-09
 */
public class UserDaoTest {

    @Test
    public void add() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("wow");
        user.setPassword("wow");
        userDao.add(user);
    }

    @Test
    public void selectByName() {
        UserDao userDao = new UserDao();
        User user = userDao.selectByName("wow");
        System.out.println(user);
    }

    @Test
    public void selectById() {
        UserDao userDao = new UserDao();
        User user = userDao.selectById(2);
        System.out.println(user);
    }
}