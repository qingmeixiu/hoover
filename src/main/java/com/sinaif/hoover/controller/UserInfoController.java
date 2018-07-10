package com.sinaif.hoover.controller;

import com.alibaba.fastjson.JSONObject;
import com.sinaif.hoover.model.UserInfoBean;
import com.sinaif.hoover.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService userinfo;
	
	@RequestMapping("/index")
    public String greeting() {
		System.out.println("-------------------");
        return "index";
    }
	@RequestMapping({"/login","/"})
	public String index() {
		ModelAndView view = new ModelAndView();
				view.setViewName("index");
		return "index";
	}
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public String getUserInfo() {
		UserInfoBean u = userinfo.query(1);
		return "Hello -----World!"+u.getUname();
	}

	@RequestMapping("/getList")
	@ResponseBody
	public String queryList() {
		List<UserInfoBean> list = userinfo.selectList();
		return "Hello -----World!"+ JSONObject.toJSONString( list );
	}



}
