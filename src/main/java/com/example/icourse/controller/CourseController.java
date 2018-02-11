package com.example.icourse.controller;

import com.example.icourse.entity.bean.Course;
import com.example.icourse.entity.bean.Teacher;
import com.example.icourse.entity.jparep.CourseRepository;
import com.example.icourse.entity.jparep.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

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
                            @RequestParam("examDifficulty") String examDifficulty,
                            @RequestParam("courseLoad") String courseLoad,
                            @RequestParam("practicability") String practicability,
                            @RequestParam("enjoyment") String enjoyment,
                            @RequestParam("teacherInfo")String teacherName){
        try {
            Course c=null;
            try {
                c = courseRepository.findByTeacherInfo_TeacherNameAndCourseName(teacherName, courseName);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            if (c!=null)
            {
                return null;
            }
            Course course = new Course();
            course.setCourseName(courseName);
            course.setExamDifficulty(Integer.parseInt(examDifficulty));
            course.setCourseLoad(Integer.parseInt(courseLoad));
            course.setPracticability(Integer.parseInt(practicability));
            course.setEnjoyment(Integer.parseInt(enjoyment));
            List<Teacher> teacher = teacherRepository.findByTeacherName(teacherName);
            if (teacher == null) {
                return null;
            }
            course.setTeacherInfo(teacher.get(0));
            courseRepository.save(course);
            return course;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }







}