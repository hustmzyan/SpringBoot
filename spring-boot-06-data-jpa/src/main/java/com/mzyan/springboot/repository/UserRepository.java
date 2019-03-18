package com.mzyan.springboot.repository;

import com.mzyan.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 继承 JpaRepository 来完成对数据库的操作
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
