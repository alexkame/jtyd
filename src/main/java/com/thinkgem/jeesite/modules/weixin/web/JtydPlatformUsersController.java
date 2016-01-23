/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatformUsers;
import com.thinkgem.jeesite.modules.weixin.service.JtydPlatformUsersService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-15
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydPlatformUsers")
public class JtydPlatformUsersController extends BaseController {

	@Autowired
	private JtydPlatformUsersService jtydPlatformUsersService;
	
	@ModelAttribute
	public JtydPlatformUsers get(@RequestParam(required=false) String id) {
		JtydPlatformUsers entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydPlatformUsersService.get(id);
		}
		if (entity == null){
			entity = new JtydPlatformUsers();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydPlatformUsers:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydPlatformUsers jtydPlatformUsers, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydPlatformUsers> page = jtydPlatformUsersService.findPage(new Page<JtydPlatformUsers>(request, response), jtydPlatformUsers); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydPlatformUsersList";
	}

	@RequiresPermissions("weixin:jtydPlatformUsers:view")
	@RequestMapping(value = "form")
	public String form(JtydPlatformUsers jtydPlatformUsers, Model model) {
		model.addAttribute("jtydPlatformUsers", jtydPlatformUsers);
		return "modules/weixin/jtydPlatformUsersForm";
	}

	@RequiresPermissions("weixin:jtydPlatformUsers:edit")
	@RequestMapping(value = "save")
	public String save(JtydPlatformUsers jtydPlatformUsers, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydPlatformUsers)){
			return form(jtydPlatformUsers, model);
		}
		jtydPlatformUsersService.save(jtydPlatformUsers);
		addMessage(redirectAttributes, "保存平台用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydPlatformUsers/?repage";
	}
	
	@RequiresPermissions("weixin:jtydPlatformUsers:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydPlatformUsers jtydPlatformUsers, RedirectAttributes redirectAttributes) {
		jtydPlatformUsersService.delete(jtydPlatformUsers);
		addMessage(redirectAttributes, "删除平台用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydPlatformUsers/?repage";
	}

}