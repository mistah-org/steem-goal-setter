package org.mistah.steemgoalsetter.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mistah.steemgoalsetter.Application;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Transactional
public class SigninControllerTest {
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		SigninController signinController = new SigninController();
		this.mockMvc = MockMvcBuilders.standaloneSetup(signinController).build();
	}

	@Test
	public void testSignin() throws Exception {
		mockMvc.perform(get("/signin"))
			.andExpect(status().isOk())
			.andExpect(forwardedUrl("signin/login"));
	}
}
