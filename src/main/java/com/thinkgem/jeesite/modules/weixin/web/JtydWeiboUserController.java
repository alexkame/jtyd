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
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeiboUser;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeiboUserService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydWeiboUser")
public class JtydWeiboUserController extends BaseController {

	@Autowired
	private JtydWeiboUserService jtydWeiboUserService;
	
	@ModelAttribute
	public JtydWeiboUser get(@RequestParam(required=false) String id) {
		JtydWeiboUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydWeiboUserService.get(id);
		}
		if (entity == null){
			entity = new JtydWeiboUser();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydWeiboUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydWeiboUser jtydWeiboUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydWeiboUser> page = jtydWeiboUserService.findPage(new Page<JtydWeiboUser>(request, response), jtydWeiboUser); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydWeiboUserList";
	}

	@RequiresPermissions("weixin:jtydWeiboUser:view")
	@RequestMapping(value = "form")
	public String form(JtydWeiboUser jtydWeiboUser, Model model) {
		model.addAttribute("jtydWeiboUser", jtydWeiboUser);
		return "modules/weixin/jtydWeiboUserForm";
	}

	@RequiresPermissions("weixin:jtydWeiboUser:edit")
	@RequestMapping(value = "save")
	public String save(JtydWeiboUser jtydWeiboUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydWeiboUser)){
			return form(jtydWeiboUser, model);
		}
		jtydWeiboUserService.save(jtydWeiboUser);
		addMessage(redirectAttributes, "保存微薄用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeiboUser/?repage";
	}
	
	@RequiresPermissions("weixin:jtydWeiboUser:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydWeiboUser jtydWeiboUser, RedirectAttributes redirectAttributes) {
		jtydWeiboUserService.delete(jtydWeiboUser);
		addMessage(redirectAttributes, "删除微薄用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeiboUser/?repage";
	}

}