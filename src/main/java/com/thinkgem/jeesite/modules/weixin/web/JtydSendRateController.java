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
import com.thinkgem.jeesite.modules.weixin.entity.JtydSendRate;
import com.thinkgem.jeesite.modules.weixin.service.JtydSendRateService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydSendRate")
public class JtydSendRateController extends BaseController {

	@Autowired
	private JtydSendRateService jtydSendRateService;
	
	@ModelAttribute
	public JtydSendRate get(@RequestParam(required=false) String id) {
		JtydSendRate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydSendRateService.get(id);
		}
		if (entity == null){
			entity = new JtydSendRate();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydSendRate:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydSendRate jtydSendRate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydSendRate> page = jtydSendRateService.findPage(new Page<JtydSendRate>(request, response), jtydSendRate); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydSendRateList";
	}

	@RequiresPermissions("weixin:jtydSendRate:view")
	@RequestMapping(value = "form")
	public String form(JtydSendRate jtydSendRate, Model model) {
		model.addAttribute("jtydSendRate", jtydSendRate);
		return "modules/weixin/jtydSendRateForm";
	}

	@RequiresPermissions("weixin:jtydSendRate:edit")
	@RequestMapping(value = "save")
	public String save(JtydSendRate jtydSendRate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydSendRate)){
			return form(jtydSendRate, model);
		}
		jtydSendRateService.save(jtydSendRate);
		addMessage(redirectAttributes, "保存微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydSendRate/?repage";
	}
	
	@RequiresPermissions("weixin:jtydSendRate:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydSendRate jtydSendRate, RedirectAttributes redirectAttributes) {
		jtydSendRateService.delete(jtydSendRate);
		addMessage(redirectAttributes, "删除微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydSendRate/?repage";
	}

}