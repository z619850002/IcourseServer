package com.example.icourse.controller;

import com.example.icourse.entity.bean.Teacher;
import com.example.icourse.entity.jparep.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;


   /* //依靠ID获取一个老师的信息          /teachers/name
    @GetMapping(value = "/teachers/{id}")
    public Teacher teacherFindOne(@PathVariable("id") Integer id){
        return teacherRepository.findOne(id);

    }*/


    //依靠姓名获取一个老师的信息          /teachers/name
    @GetMapping(value = "/teachers/name/{name}")
    public List<Teacher> teacherListByName(@PathVariable("name") String name){
        return teacherRepository.findByTeacherName(name);

    }

    //新建一个老师                        /teachers
    @PostMapping(value="/teachers")
    public Teacher teacherAdd(@RequestParam("teacherName") String teacherName,
                              @RequestParam("score") Integer score){
        Teacher teacher=new Teacher();
        teacher.setScore(score);
        teacher.setTeacherName(teacherName);

        return teacherRepository.save(teacher);
    }
}
