package com.example.icourse.entity.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "teacher_info")
public class Teacher {

    @Id
    @GeneratedValue
    private Integer teacherId;

    private String teacherName;

    private Integer score;

    @OneToMany(mappedBy = "teacherInfo")
    private Set<Course> courseSet;

    public Teacher(){

    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

   public Set<Course> getCourseList() {
        return courseSet;
    }

    public void setCourseList(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
}
