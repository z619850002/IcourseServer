package com.example.icourse;

import com.example.icourse.entity.bean.User;
import com.example.icourse.entity.jparep.UserRep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IcourseApplicationTests {

	@Autowired
	UserRep userRep;

	@Test
	public void contextLoads() {
	}

}
