package com.mmc.common.controller;

import com.mmc.common.Application;
import com.mmc.common.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ResponseBody;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ResponseBody
public class IndexController {

    @Autowired
    private UserService userService;

    @Test
    public void test() throws Exception {

    }
}
