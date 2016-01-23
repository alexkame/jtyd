/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.web;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

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
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticle;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinArticleService;

/**
 * weixinController
 * 
 * @author niu
 * @version 2015-10-18
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydWeixinArticle")
public class JtydWeixinArticleController extends BaseController {

	@Autowired
	private JtydWeixinArticleService jtydWeixinArticleService;

	@ModelAttribute
	public JtydWeixinArticle get(@RequestParam(required = false) String id) {
		JtydWeixinArticle entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = jtydWeixinArticleService.get(id);
		}
		if (entity == null) {
			entity = new JtydWeixinArticle();
		}
		return entity;
	}

	@RequiresPermissions("weixin:jtydWeixinArticle:view")
	@RequestMapping(value = { "list", "" })
	public String list(JtydWeixinArticle jtydWeixinArticle,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Page<JtydWeixinArticle> page = jtydWeixinArticleService.findPage(
				new Page<JtydWeixinArticle>(request, response),
				jtydWeixinArticle);
		model.addAttribute("page", page);
		return "modules/weixin/jtydWeixinArticleList";
	}

	@RequiresPermissions("weixin:jtydWeixinArticle:view")
	@RequestMapping(value = "form")
	public String form(JtydWeixinArticle jtydWeixinArticle, Model model) {
		model.addAttribute("jtydWeixinArticle", jtydWeixinArticle);
		return "modules/weixin/jtydWeixinArticleForm";
	}

	@RequiresPermissions("weixin:jtydWeixinArticle:edit")
	@RequestMapping(value = "save")
	public String save(JtydWeixinArticle jtydWeixinArticle, Model model,
			RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydWeixinArticle)) {
			return form(jtydWeixinArticle, model);
		}
		jtydWeixinArticleService.save(jtydWeixinArticle);
		addMessage(redirectAttributes, "保存微信文章成功");
		return "redirect:" + Global.getAdminPath()
				+ "/weixin/jtydWeixinArticle/?repage";
	}

	@RequiresPermissions("weixin:jtydWeixinArticle:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydWeixinArticle jtydWeixinArticle,
			RedirectAttributes redirectAttributes) {
		jtydWeixinArticleService.delete(jtydWeixinArticle);
		addMessage(redirectAttributes, "删除微信文章成功");
		return "redirect:" + Global.getAdminPath()
				+ "/weixin/jtydWeixinArticle/?repage";
	}
}