package com.mmc.common.service;


import com.mmc.common.Application;
import com.mmc.common.dao.BaseDao;
import com.mmc.common.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private BaseDao baseDao;

    @Override
    @Test
    public void save() {
        User u = new User();
        u.setUser_name("mmc");
        u.setPassword("111");
        baseDao.add(u);
    }

    @Test
    public void update() {
        User u = new User();
        u = (User) baseDao.get(u, new Long(1));
        u.setUser_name("mmcc");
        baseDao.update(u);
    }

    @Test
    public void delete() {
        User u = new User();
        baseDao.delete(u, new Long(1));
    }
}
