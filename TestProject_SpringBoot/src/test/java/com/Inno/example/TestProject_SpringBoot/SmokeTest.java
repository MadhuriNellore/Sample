package com.Inno.example.TestProject_SpringBoot;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Inno.example.TestProject_SpringBoot.controller.StudentController;

@SpringBootTest
public class SmokeTest {
	@Autowired
	private StudentController studentController;

	@Test
	void contextLoads() {
		assertThat(studentController).isNotNull();
	}

}
