package com.newforesee.girl.repository;

import com.newforesee.girl.daomain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by newforesee on 2018/8/9.
 */
public interface NoteRepository extends JpaRepository<Notes, Integer> {

    //列出该用户所有笔记
    List<Notes> findByUserid(Integer userid);

    @Query("update Notes n set n.status = :status where n.id = :id ")
    @Modifying
    Integer dropNote(@Param("id") Integer id,@Param("status") Integer status);

}
