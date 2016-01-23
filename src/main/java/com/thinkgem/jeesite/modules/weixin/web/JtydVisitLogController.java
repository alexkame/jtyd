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
import com.thinkgem.jeesite.modules.weixin.entity.JtydVisitLog;
import com.thinkgem.jeesite.modules.weixin.service.JtydVisitLogService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-29
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydVisitLog")
public class JtydVisitLogController extends BaseController {

	@Autowired
	private JtydVisitLogService jtydVisitLogService;
	
	@ModelAttribute
	public JtydVisitLog get(@RequestParam(required=false) String id) {
		JtydVisitLog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydVisitLogService.get(id);
		}
		if (entity == null){
			entity = new JtydVisitLog();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydVisitLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydVisitLog jtydVisitLog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydVisitLog> page = jtydVisitLogService.findPage(new Page<JtydVisitLog>(request, response), jtydVisitLog); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydVisitLogList";
	}

	@RequiresPermissions("weixin:jtydVisitLog:view")
	@RequestMapping(value = "form")
	public String form(JtydVisitLog jtydVisitLog, Model model) {
		model.addAttribute("jtydVisitLog", jtydVisitLog);
		return "modules/weixin/jtydVisitLogForm";
	}

	@RequiresPermissions("weixin:jtydVisitLog:edit")
	@RequestMapping(value = "save")
	public String save(JtydVisitLog jtydVisitLog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydVisitLog)){
			return form(jtydVisitLog, model);
		}
		jtydVisitLogService.save(jtydVisitLog);
		addMessage(redirectAttributes, "保存平台用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydVisitLog/?repage";
	}
	
	@RequiresPermissions("weixin:jtydVisitLog:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydVisitLog jtydVisitLog, RedirectAttributes redirectAttributes) {
		jtydVisitLogService.delete(jtydVisitLog);
		addMessage(redirectAttributes, "删除平台用户成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydVisitLog/?repage";
	}

}