package com.newforesee.girl.repository;

import com.newforesee.girl.daomain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by newforesee on 2018/8/7.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄查询
    List<Girl> findByAge(Integer age);
}
