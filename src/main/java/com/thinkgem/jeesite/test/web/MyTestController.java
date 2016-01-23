package com.thinkgem.jeesite.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.web.BaseController;
@Controller
@RequestMapping(value = "${adminPath}/test/myTest")
public class MyTestController  extends BaseController {
	@RequestMapping(value = "list")
	public String list(){
		System.out.println("=============");
		return "jeesite/test/mytest";
	}
}
