package com.example.icourse.controller;

import com.example.icourse.entity.bean.User;
import com.example.icourse.entity.jparep.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRep userRep;


    @RequestMapping(value = "/id" , method = RequestMethod.GET)
    public User getUserById(Integer userId , HttpServletRequest request , HttpServletResponse response)
    {
        try {
            User user = userRep.getByUserId(userId);
            return user;
        }
        catch (Exception e)
        {
            response.addHeader("Exception" , e.toString());
            return null;
        }
    }


    @RequestMapping(value = "/name" , method = RequestMethod.GET)
    public List<User> getUsersByName(String userName , HttpServletRequest request , HttpServletResponse response)
    {
        try {
            List<User> userList = userRep.getByUserName(userName);
            return userList;
        }
        catch (Exception e)
        {
            response.addHeader("Exception" , e.toString());
            return null;
        }
    }

    @RequestMapping(value = "/studentnumber" , method = RequestMethod.GET)
    public User getUserByStudentNumber(String studentNumber , HttpServletRequest request , HttpServletResponse response)
    {

        try {
            User user = userRep.getByStudentNumber(studentNumber);
            return user;
        }
        catch (Exception e)
        {
            response.addHeader("Exception" , e.toString());
            return null;
        }
    }

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public boolean addNewUser(String studentNumber , String userName  , HttpServletRequest request , HttpServletResponse response)
    {

        try {
            User user=new User();
            user.setStudentNumber(studentNumber);
            user.setUserName(userName);
            userRep.save(user);
            return true;
        }
        catch (Exception e)
        {
            response.addHeader("Exception" , e.toString());
            return false;
        }

    }


    @RequestMapping(value = "/id" , method = RequestMethod.PUT)
    public boolean uodateUser(Integer userId , String userName ,String studentNumber , String email , Integer integral , String area , String nickName ,HttpServletResponse response)
    {

        try {
            User user=new User();
            user.setUserId(userId);
            user.setStudentNumber(studentNumber);
            user.setUserName(userName);
            user.setArea(area);
            user.setEmail(email);
            user.setNickName(nickName);
            user.setIntegral(integral);
            userRep.save(user);
            return true;
        }
        catch (Exception e)
        {
            response.addHeader("Exception" , e.toString());
            return false;
        }
    }

    @RequestMapping(value = "/test" , method = RequestMethod.GET)
    public boolean uodateUser(String userName)
    {

        try {
            User user=new User();
            //user.setUserId(userId);
            user.setUserName(userName);
            //user.setArea(area);
            //user.setEmail(email);
            //user.setNickName(nickName);
            //user.setIntegral(integral);
            userRep.save(user);
            return true;
        }
        catch (Exception e)
        {
            //response.addHeader("Exception" , e.toString());
            return false;
        }
    }



}
