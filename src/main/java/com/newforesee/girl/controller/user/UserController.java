package com.newforesee.girl.controller.user;

import com.newforesee.girl.controller.GirlController;
import com.newforesee.girl.daomain.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by newforesee on 2018/8/8.
 */
@RestController
@CrossOrigin
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private Users users;

}
