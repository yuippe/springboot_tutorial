package org.spring.springboot.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.springboot.domain.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> r = new ArrayList<User>(users.values());
		return r;
	}
	
	//way1 to postbody
	//使用ModelAttribute修饰符，在Junit测试中可以用mvc中的addparam来添加参数
//	@RequestMapping(value="/", method=RequestMethod.POST)
//    public String postUser(@ModelAttribute User user) {
//        // 处理"/users/"的POST请求，用来创建User
//        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
//        users.put(user.getId(), user);
//        return "success";
//    }
	
	//way2 to postbody
	//使用@RequestBody修饰符时，在Junit测试中不可以用mvc中的addparam来添加参数
	@RequestMapping(value="/", method=RequestMethod.POST)
    public String postUser(@RequestBody  Map<String,Object> paramMap) {
		
		Long id = Long.parseLong((String)paramMap.get("id"));
		String name = (String)paramMap.get("name");
		Integer age = Integer.parseInt((String)paramMap.get("age"));
		User user = new User(id,name,age);
	    // 处理"/users/"的POST请求，用来创建User
	    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		users.put(user.getId(), user);
		return "success";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
