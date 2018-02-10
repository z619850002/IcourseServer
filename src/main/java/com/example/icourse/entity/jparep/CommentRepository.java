package com.example.icourse.entity.jparep;


import com.example.icourse.entity.bean.Remark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Remark,Integer> {
    //通过课程查询评论
    public List<Remark> findByCourseInfo_CourseNameAndCourseInfo_TeacherInfo_TeacherName(String courseName, String teacherName);

    //通过学号查询
    public List<Remark> findByUserInfo_StudentNumber(String studentNumber);
}

