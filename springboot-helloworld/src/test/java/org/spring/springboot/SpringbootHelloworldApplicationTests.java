package org.spring.springboot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.domain.User;
import org.spring.springboot.service.BlogProperties;
import org.spring.springboot.web.HelloWorldController;
import org.spring.springboot.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.alibaba.fastjson.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootHelloworldApplicationTests {
	
	@Autowired
	private BlogProperties blogProperties;
	
	private MockMvc mvc;
	
	private static final Log log = LogFactory.getLog(SpringbootHelloworldApplicationTests.class);
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(
				new HelloWorldController(),
				new UserController()).build();
	}

	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void testFuncsayHello() throws Exception{
		
		//way 1 to test function
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string(equalTo("Hello World")));
		
		//way 2 to test function
		RequestBuilder request = null;
		
		request = get("/hello");
		mvc.perform(request)
			.andExpect(status().isOk())
			.andExpect(content().string("Hello World"));
	}
	
	@Test
	public void test1() throws Exception{
		
		assertEquals("yuippe", blogProperties.getName());
		assertEquals("Spring Boot Tutorial", blogProperties.getTitle());
		assertEquals("yuippe is writing Spring Boot Tutorial hardly", blogProperties.getDesc());
		
		log.info("随机数测试输出:");
		log.info("随机字符串 : " + blogProperties.getValue());
		log.info("随机int : " + blogProperties.getNumber());
		log.info("随机long : " + blogProperties.getBignumber());
		log.info("随机10以下 : " + blogProperties.getTest1());
		log.info("随机10-20 : " + blogProperties.getTest2());
		
	}
	
	@Test
	public void testUserController() throws Exception{
		//测试UserController
		RequestBuilder request = null;
		
		// 1、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));
		
		
		// 2、post提交一个user
//		request = post("/users/")
//				.param("id", "1")
//				.param("name", "测试大师")
//				.param("age", "20");
//		Map<String,String> userParam = {"id":"1","name":"测试大师","age":"20"};
//		User user = new User(1L,"测试大师",new Integer(20));
//		String requestJson = JSON.toJSONString(user);
		Map<String, String> userParam = new HashMap<String, String>();
    	userParam.put("id", "1");   
    	userParam.put("name", "测试大师"); 
    	userParam.put("age", "20"); 

		String requestJson = JSON.toJSONString(userParam);
		request = post("/users/").contentType(MediaType.APPLICATION_JSON).content(requestJson);
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		// 3、get获取user列表，应该有刚才插入的数据
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"测试大师\",\"age\":20}]")));

		// 4、put修改id为1的user
		request = put("/users/1")
				.param("name", "测试终极大师")
				.param("age", "30");
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));

		// 5、get一个id为1的user
		request = get("/users/1");
		mvc.perform(request)
				.andExpect(content().string(equalTo("{\"id\":1,\"name\":\"测试终极大师\",\"age\":30}")));

		// 6、del删除id为1的user
		request = delete("/users/1");
		mvc.perform(request)
				.andExpect(content().string(equalTo("success")));
		
		
		// 7、get查一下user列表，应该为空
		request = get("/users/");
		mvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[]")));
		
	}

}
