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
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatform;
import com.thinkgem.jeesite.modules.weixin.service.JtydPlatformService;

/**
 * weixinController
 * @author niu
 * @version 2015-10-19
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydPlatform")
public class JtydPlatformController extends BaseController {

	@Autowired
	private JtydPlatformService jtydPlatformService;
	
	@ModelAttribute
	public JtydPlatform get(@RequestParam(required=false) String id) {
		JtydPlatform entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydPlatformService.get(id);
		}
		if (entity == null){
			entity = new JtydPlatform();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydPlatform:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydPlatform jtydPlatform, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydPlatform> page = jtydPlatformService.findPage(new Page<JtydPlatform>(request, response), jtydPlatform); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydPlatformList";
	}

	@RequiresPermissions("weixin:jtydPlatform:view")
	@RequestMapping(value = "form")
	public String form(JtydPlatform jtydPlatform, Model model) {
		model.addAttribute("jtydPlatform", jtydPlatform);
		return "modules/weixin/jtydPlatformForm";
	}

	@RequiresPermissions("weixin:jtydPlatform:edit")
	@RequestMapping(value = "save")
	public String save(JtydPlatform jtydPlatform, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydPlatform)){
			return form(jtydPlatform, model);
		}
		jtydPlatformService.save(jtydPlatform);
		addMessage(redirectAttributes, "保存微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydPlatform/?repage";
	}
	
	@RequiresPermissions("weixin:jtydPlatform:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydPlatform jtydPlatform, RedirectAttributes redirectAttributes) {
		jtydPlatformService.delete(jtydPlatform);
		addMessage(redirectAttributes, "删除微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydPlatform/?repage";
	}

}