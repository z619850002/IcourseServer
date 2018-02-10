package com.example.icourse.entity.jparep;


import com.example.icourse.entity.bean.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //通过姓名查询
    public List<Teacher> findByTeacherName(String name);
}

