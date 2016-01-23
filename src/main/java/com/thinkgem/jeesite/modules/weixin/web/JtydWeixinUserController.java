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
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinUser;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinUserService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydWeixinUser")
public class JtydWeixinUserController extends BaseController {

	@Autowired
	private JtydWeixinUserService jtydWeixinUserService;
	
	@ModelAttribute
	public JtydWeixinUser get(@RequestParam(required=false) String id) {
		JtydWeixinUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydWeixinUserService.get(id);
		}
		if (entity == null){
			entity = new JtydWeixinUser();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydWeixinUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydWeixinUser jtydWeixinUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydWeixinUser> page = jtydWeixinUserService.findPage(new Page<JtydWeixinUser>(request, response), jtydWeixinUser); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydWeixinUserList";
	}

	@RequiresPermissions("weixin:jtydWeixinUser:view")
	@RequestMapping(value = "form")
	public String form(JtydWeixinUser jtydWeixinUser, Model model) {
		model.addAttribute("jtydWeixinUser", jtydWeixinUser);
		return "modules/weixin/jtydWeixinUserForm";
	}

	@RequiresPermissions("weixin:jtydWeixinUser:edit")
	@RequestMapping(value = "save")
	public String save(JtydWeixinUser jtydWeixinUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydWeixinUser)){
			return form(jtydWeixinUser, model);
		}
		jtydWeixinUserService.save(jtydWeixinUser);
		addMessage(redirectAttributes, "保存微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeixinUser/?repage";
	}
	
	@RequiresPermissions("weixin:jtydWeixinUser:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydWeixinUser jtydWeixinUser, RedirectAttributes redirectAttributes) {
		jtydWeixinUserService.delete(jtydWeixinUser);
		addMessage(redirectAttributes, "删除微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeixinUser/?repage";
	}

}