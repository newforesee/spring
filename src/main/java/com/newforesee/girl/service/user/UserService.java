package com.newforesee.girl.service.user;

import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.daomain.Users;
import com.newforesee.girl.enums.ResultEnum;
import com.newforesee.girl.exception.GirlException;
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


    /**
     * 获取用户列表
     * @return
     */
    public Result userList() {

        return ResultUtil.success(userRepository.findAll());
    }


    /**
     * 添加用户
     * @param users
     * @return
     */
    public Users adduser(Users users) {

        if (userRepository.findByUsername(users.getUsername())==null) {
            return userRepository.save(users);
        }

        throw new GirlException(ResultEnum.USER_HAS_EXIST );

    }

    /**
     * 用户登录
     * @param users
     * @return
     */
    public Users login(Users users) throws GirlException{

        Users user = userRepository.findByUsername(users.getUsername());
        if (user == null) {
            throw new GirlException(ResultEnum.USER_NOT_EXIST);
        }
        if (user.getPassword().equals(users.getPassword())) {
            user.setPassword("*************");
            return user;
        }

            throw new GirlException(ResultEnum.PASSWD_WRONG);
    }
}
