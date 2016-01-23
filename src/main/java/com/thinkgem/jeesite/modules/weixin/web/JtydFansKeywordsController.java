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
import com.thinkgem.jeesite.modules.weixin.entity.JtydFansKeywords;
import com.thinkgem.jeesite.modules.weixin.service.JtydFansKeywordsService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydFansKeywords")
public class JtydFansKeywordsController extends BaseController {

	@Autowired
	private JtydFansKeywordsService jtydFansKeywordsService;
	
	@ModelAttribute
	public JtydFansKeywords get(@RequestParam(required=false) String id) {
		JtydFansKeywords entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydFansKeywordsService.get(id);
		}
		if (entity == null){
			entity = new JtydFansKeywords();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydFansKeywords:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydFansKeywords jtydFansKeywords, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydFansKeywords> page = jtydFansKeywordsService.findPage(new Page<JtydFansKeywords>(request, response), jtydFansKeywords); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydFansKeywordsList";
	}

	@RequiresPermissions("weixin:jtydFansKeywords:view")
	@RequestMapping(value = "form")
	public String form(JtydFansKeywords jtydFansKeywords, Model model) {
		model.addAttribute("jtydFansKeywords", jtydFansKeywords);
		return "modules/weixin/jtydFansKeywordsForm";
	}

	@RequiresPermissions("weixin:jtydFansKeywords:edit")
	@RequestMapping(value = "save")
	public String save(JtydFansKeywords jtydFansKeywords, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydFansKeywords)){
			return form(jtydFansKeywords, model);
		}
		jtydFansKeywordsService.save(jtydFansKeywords);
		addMessage(redirectAttributes, "保存粉丝特征成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydFansKeywords/?repage";
	}
	
	@RequiresPermissions("weixin:jtydFansKeywords:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydFansKeywords jtydFansKeywords, RedirectAttributes redirectAttributes) {
		jtydFansKeywordsService.delete(jtydFansKeywords);
		addMessage(redirectAttributes, "删除粉丝特征成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydFansKeywords/?repage";
	}

}