package com.newforesee.girl.repository;

import com.newforesee.girl.daomain.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by newforesee on 2018/8/9.
 */
public interface NoteRepository extends JpaRepository<Notes,Integer> {

}
