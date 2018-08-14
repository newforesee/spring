package com.newforesee.girl.controller;

import com.newforesee.girl.daomain.Girl;
import com.newforesee.girl.daomain.Result;
import com.newforesee.girl.exception.GirlException;
import com.newforesee.girl.repository.GirlRepository;
import com.newforesee.girl.service.GirlService;
import com.newforesee.girl.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by newforesee on 2018/8/7.
 */
@RestController
@CrossOrigin
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;


    /**
     * 查询所有女生列表
     *
     * @return
     */
    @GetMapping(value = "/girls")
    public Result girlList() {
        logger.info("girlList");
        return ResultUtil.success(girlRepository.findAll());
    }

    /**
     * 添加一个女生
     *
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping("/girl")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            //return null;
           return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());

        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl));

    }

    /**
     * 根据id查询一个女生
     *
     * @param id
     * @return
     */
    @PostMapping(value = "/girl/{id}")
    public Result girlFindOne(@PathVariable("id") Integer id) {
        return ResultUtil.success(girlRepository.findOne(id));
    }

    /**
     * 通过年龄查询女生
     *
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public Result<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return ResultUtil.success(girlRepository.findByAge(age));
    }


    /**
     * 更改指定女生的信息
     *
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping(value = "/girl/{id}")
    public Result<Girl> girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age
    ) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setId(id);
        girl.setCupSize(cupSize);


        return ResultUtil.success(girlRepository.save(girl));
    }

    @PostMapping("/xadd/{id}")
    public Result<Girl> update(@PathVariable("id") Integer id,
                               @RequestParam("cupSize") String cupSize,
                               @RequestParam("age") Integer age
    ){
//        Girl girl = girlRepository.getOne(id);
//        girl.setAge(age);
//        girl.setCupSize(cupSize);
        girlService.updateGirl(id,age);
        return ResultUtil.success("success");
//
//
    }

    /**
     * 删除指定id的女生
     *
     * @param id
     */
    @DeleteMapping(value = "/girl/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }


    @PostMapping(value = "/girls/tow")
    public void gileTwo() {
        girlService.insertTwo();

    }

    @GetMapping(value = "/girl/getAge/{id}")
    public Result<Girl> getAge(@PathVariable("id") Integer id) throws GirlException {
         return ResultUtil.success(girlService.getAge(id));

    }


}
