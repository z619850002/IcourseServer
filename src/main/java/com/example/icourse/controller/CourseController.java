package com.example.icourse.controller;

import com.example.icourse.entity.bean.Course;
import com.example.icourse.entity.bean.Teacher;
import com.example.icourse.entity.jparep.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    //获取所有课程（多个）
    @GetMapping(value = "/courses")
    public List<Course> courseList(){
        return courseRepository.findAll();
    }
    //依靠课程名获取课程（多个）
    @GetMapping(value="courses/name/{courseName}")
    public List<Course> courseListByCourseName(@PathVariable("courseName") String courseName){
        return courseRepository.findByCourseName(courseName);
    }

    // 依靠老师获取课程（多个）           /courses/teacher
    @GetMapping(value = "courses/teacher/{teacherName}")
    public List<Course> courseListByTeacherName(@PathVariable("teacherName") String teacherName){
        return courseRepository.findByTeacherInfo_TeacherName(teacherName);
    }

    //依靠老师加课程名获取课程（一个）   /courses/name&teacher
    @GetMapping(value = "courses/name&teacher/{name}&{teacher}")
    public Course courseByTeacherNameAndCourseName(@PathVariable("name") String name,
                                                   @PathVariable("teacher") String teacher){
        return courseRepository.findByTeacherInfo_TeacherNameAndCourseName(teacher,name);
    }


    //新建一个课程                       /courses
    @PostMapping(value="/courses")
    public Course courseAdd(@RequestParam("courseName") String courseName,
                            @RequestParam("examDifficulty") Integer examDifficulty,
                            @RequestParam("courseLoad") Integer courseLoad,
                            @RequestParam("practicability") Integer practicability,
                            @RequestParam("enjoyment") Integer enjoyment,
                            @RequestParam("teacherInfo")Teacher teacherId){
        Course course=new Course();
        course.setCourseName(courseName);
        course.setExamDifficulty(examDifficulty);
        course.setCourseLoad(courseLoad);
        course.setPracticability(practicability);
        course.setEnjoyment(enjoyment);
        course.setTeacherInfo(teacherId);


        return courseRepository.save(course);

    }







}