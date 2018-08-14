package com.newforesee.girl.service;

import com.newforesee.girl.daomain.Girl;
import com.newforesee.girl.enums.ResultEnum;
import com.newforesee.girl.exception.GirlException;
import com.newforesee.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by newforesee on 2018/8/7.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    /**
     * 插入两条数据
     */
    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(19);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("B");
        girlB.setAge(18);
        girlRepository.save(girlB);
    }

    /**
     * 异常处理测试方法
     * @param id
     * @throws Exception
     */
    public Girl getAge(Integer id) throws GirlException {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回你还在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return girl;

    }

    /**
     * 通过Id查询一个女生信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }

    @Transactional
    public void updateGirl(Integer id,Integer age){
        girlRepository.updateGril(id,age);
    }
}
