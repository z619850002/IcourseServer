package com.example.icourse.controller;


import com.example.icourse.entity.bean.Course;
import com.example.icourse.entity.bean.Remark;
import com.example.icourse.entity.bean.User;
import com.example.icourse.entity.jparep.CommentRepository;
import com.example.icourse.entity.jparep.CourseRepository;
import com.example.icourse.entity.jparep.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRep userRepository;

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
                            @RequestParam("examDifficulty") String examDifficulty,
                            @RequestParam("courseLoad")  String courseLoad,
                            @RequestParam("practicability") String practicability,
                            @RequestParam("enjoyment") String enjoyment,
                            @RequestParam("teacherScore") String teacherScore,
                            @RequestParam("userInfo") String userId,
                            @RequestParam("teacherInfo") String teacherInfo,
                            @RequestParam("courseName")  String courseName){
        try {
            Remark remark = new Remark();
            remark.setContent(content);
            remark.setExamDifficulty(Integer.parseInt(examDifficulty));
            remark.setCourseLoad(Integer.parseInt(courseLoad));
            remark.setPracticability(Integer.parseInt(practicability));
            remark.setEnjoyment(Integer.parseInt(enjoyment));
            remark.setTeacherScore(Integer.parseInt(teacherScore));
            User user = userRepository.getByUserId(Integer.parseInt(userId));
            if (user == null) {
                return null;
            }
            remark.setUserInfo(user);
            Course course = courseRepository.findByTeacherInfo_TeacherNameAndCourseName(teacherInfo, courseName);
            if (course == null) {
                return null;
            }
            updateRemark(course);
            remark.setCourseInfo(course);
            commentRepository.save(remark);
            return remark;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

    public void updateRemark(Course course) throws Exception
    {
        List<Remark> remarks=commentRepository.findByCourseInfo_CourseNameAndCourseInfo_TeacherInfo_TeacherName(course.getCourseName() , course.getTeacherInfo().getTeacherName());
        Integer totalExamdifficulty=50;
        Integer totalCourseLoad=50;
        Integer totalPracticability=50;
        Integer totalEnjoyment=50;
        Integer totalTeacherScore=50;
        for (Remark ele : remarks)
        {
            totalExamdifficulty+=ele.getExamDifficulty();
            totalCourseLoad+=ele.getCourseLoad();
            totalPracticability+=ele.getPracticability();
            totalEnjoyment+=ele.getEnjoyment();
            totalTeacherScore+=ele.getTeacherScore();
        }
        course.setExamDifficulty(totalExamdifficulty/(remarks.size()+10));
        course.setCourseLoad(totalCourseLoad/(remarks.size()+10));
        course.setEnjoyment(totalEnjoyment/(remarks.size()+10));
        course.setPracticability(totalPracticability/(remarks.size()+10));
        course.getTeacherInfo().setScore(totalTeacherScore/(remarks.size()+10));
        courseRepository.save(course);
    }



}
