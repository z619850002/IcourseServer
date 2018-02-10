package com.example.icourse.controller;


import com.example.icourse.entity.bean.Course;
import com.example.icourse.entity.bean.Remark;
import com.example.icourse.entity.bean.User;
import com.example.icourse.entity.jparep.CommentRepository;
import com.example.icourse.entity.jparep.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CourseRepository courseRepository;

    // 获取关于某个课程的全部评论         /comments/courses/name&teacher
    @GetMapping(value = "/comments/courses/nameandteacher/{name}&{teacher}")
    public List<Remark> commendList(@PathVariable("name") String name,
                                    @PathVariable("teacher") String teacher){
        return commentRepository.findByCourseInfo_CourseNameAndCourseInfo_TeacherInfo_TeacherName(name,teacher);
    }

    //}

    //获取某个人的全部评论               /comments/user/id
    @GetMapping(value = "/comments/user/id/{id}")
    public List<Remark> commentListByUserId(@PathVariable("id") String studentNumber){
        return commentRepository.findByUserInfo_StudentNumber(studentNumber);
    }

    //新评论                             /comments
    @PostMapping(value = "/comments")
    public Remark remarkAdd(@RequestParam("Content") String content,
                            @RequestParam("examDifficulty") Integer examDifficulty,
                            @RequestParam("courseLoad")  Integer courseLoad,
                            @RequestParam("practicability") Integer practicability,
                            @RequestParam("enjoyment") Integer enjoyment,
                            @RequestParam("teacherScore") Integer teacherScore,
                            @RequestParam("userInfo") User userInfo,
                            @RequestParam("courseInfo") Course courseInfo){
        Remark remark=new Remark();
        remark.setContent(content);
        remark.setExamDifficulty(examDifficulty);
        remark.setCourseLoad(courseLoad);
        remark.setPracticability(practicability);
        remark.setEnjoyment(enjoyment);
        remark.setTeacherScore(teacherScore);
        remark.setUserInfo(userInfo);
        remark.setCourseLoad(courseLoad);
        return commentRepository.save(remark);


    }



}
