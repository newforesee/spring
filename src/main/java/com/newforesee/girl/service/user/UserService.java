package com.newforesee.girl.service.user;

import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.repository.UserRepository;
import com.newforesee.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by newforesee on 2018/8/8.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Result userList() {

        return ResultUtil.success(userRepository.findAll());
    }
}
