package com.newforesee.girl.repository;

import com.newforesee.girl.daomain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by newforesee on 2018/8/8.
 */
public interface UserRepository extends JpaRepository<Users,Integer> {
}
