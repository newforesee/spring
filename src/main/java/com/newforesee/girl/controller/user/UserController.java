package com.newforesee.girl.controller.user;

import com.newforesee.girl.controller.GirlController;
import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.daomain.Users;
import com.newforesee.girl.repository.UserRepository;
import com.newforesee.girl.service.user.UserService;
import com.newforesee.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by newforesee on 2018/8/8.
 */
@RestController
@CrossOrigin
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * 查看用户列表
     * @return
     */
    @PostMapping(value = "/userlist")
    public Result userList() {

        return ResultUtil.success(userRepository.findAll());
    }

    /**
     * 添加一个用户
     *
     * @param users
     * @param bindingResult
     * @return
     */
    @PostMapping("/adduser")
    public Result<Users> userAdd(@Valid @RequestBody Users users, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

          return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        }
        users.setUsername(users.getUsername());
        users.setPassword(users.getPassword());

        return ResultUtil.success(userRepository.save(users));

    }


    @PostMapping("/deleteuser/{id}")
    public Result deleteUserById(@RequestParam("id") Integer id){
        return ResultUtil.success("删除成功");
    }



}
