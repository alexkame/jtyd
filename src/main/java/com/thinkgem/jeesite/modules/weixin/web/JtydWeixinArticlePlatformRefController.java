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
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticlePlatformRef;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinArticlePlatformRefService;

/**
 * weixinController
 * @author niu
 * @version 2015-10-19
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydWeixinArticlePlatformRef")
public class JtydWeixinArticlePlatformRefController extends BaseController {

	@Autowired
	private JtydWeixinArticlePlatformRefService jtydWeixinArticlePlatformRefService;
	
	@ModelAttribute
	public JtydWeixinArticlePlatformRef get(@RequestParam(required=false) String id) {
		JtydWeixinArticlePlatformRef entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydWeixinArticlePlatformRefService.get(id);
		}
		if (entity == null){
			entity = new JtydWeixinArticlePlatformRef();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydWeixinArticlePlatformRef:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydWeixinArticlePlatformRef> page = jtydWeixinArticlePlatformRefService.findPage(new Page<JtydWeixinArticlePlatformRef>(request, response), jtydWeixinArticlePlatformRef); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydWeixinArticlePlatformRefList";
	}

	@RequiresPermissions("weixin:jtydWeixinArticlePlatformRef:view")
	@RequestMapping(value = "form")
	public String form(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef, Model model) {
		model.addAttribute("jtydWeixinArticlePlatformRef", jtydWeixinArticlePlatformRef);
		return "modules/weixin/jtydWeixinArticlePlatformRefForm";
	}

	@RequiresPermissions("weixin:jtydWeixinArticlePlatformRef:edit")
	@RequestMapping(value = "save")
	public String save(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydWeixinArticlePlatformRef)){
			return form(jtydWeixinArticlePlatformRef, model);
		}
		jtydWeixinArticlePlatformRefService.save(jtydWeixinArticlePlatformRef);
		addMessage(redirectAttributes, "保存微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeixinArticlePlatformRef/?repage";
	}
	
	@RequiresPermissions("weixin:jtydWeixinArticlePlatformRef:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef, RedirectAttributes redirectAttributes) {
		jtydWeixinArticlePlatformRefService.delete(jtydWeixinArticlePlatformRef);
		addMessage(redirectAttributes, "删除微信文章成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydWeixinArticlePlatformRef/?repage";
	}

}