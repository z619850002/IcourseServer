package com.example.icourse.entity.jparep;

import com.example.icourse.entity.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface UserRep extends JpaRepository<User , Integer>{
    public User getByUserId(Integer userId);
    public List<User>  getByUserName(String userName);
    public User getByStudentNumber(String studentNumber);
}
