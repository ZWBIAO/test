package com.wxine;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.wxine.domain.User;
import com.wxine.repository.UserDao;
import com.wxine.repository.UserRepository;

@Controller
public class IndexController {
	
	@Resource
	private UserRepository userRepository;
	
	@Resource//用serrsion用这个注解
	private UserDao userDao;
	
	@RequestMapping("/")
	public String Index() {
//		User user = new User();
//		user.setId(UUID.randomUUID().toString().replace("-", ""));
//		user.setAccount("zhangsan");
//		user.setPasswd("123456");
//		user.setName("张四");
//		user.setAge(20);
//		userDao.save(user);
//		//List<User> list = userRepository.findByAccount("zhangsan");
		return "index";
	}
	
	@RequestMapping(value="/register")
	public String register(User user){
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		userDao.save(user);
		return "Register_success";

	}
	@RequestMapping(value="/login")
	public String login_success(String account,String passwd){
		String sql = "FROM Register as u WHERE u.account=? AND u.password=?";
		List<User> retul =userDao.Login(sql).setString(0, account).setString(1, account).list();
		if(!(retul.isEmpty())){
			return "login";
		}
		return "redirect:/";
	}
		
	}
