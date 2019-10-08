package com.miyu.springboot.service.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback(true)
public class userServiceTest {

    @Test
    public void query() {


    }
}