package com.newforesee.girl.repository;

import com.newforesee.girl.daomain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by newforesee on 2018/8/7.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    //通过年龄查询

    List<Girl> findByAge(Integer age);

    @Query("update Girl g set g.age = :age where g.id = :id ")
    @Modifying
    void updateGril(@Param("id") Integer id,@Param("age") Integer age);
}
