package com.example.icourse.entity.jparep;


import com.example.icourse.entity.bean.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {

    //通过课程名查询
    public List<Course> findByCourseName(String name);

    //通过教师名查询
    public List<Course> findByTeacherInfo_TeacherName(String name);

    //通过教师名和课程名查询
    public Course findByTeacherInfo_TeacherNameAndCourseName(String teacherName,String courseName);
}

