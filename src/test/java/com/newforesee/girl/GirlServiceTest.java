package com.newforesee.girl;

import com.newforesee.girl.daomain.Girl;
import com.newforesee.girl.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by newforesee on 2018/8/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOne(){
        Girl girl = girlService.findOne(25);
        Assert.assertEquals(new Integer(21),girl.getAge());

    }
}
