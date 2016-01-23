/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.weixin.entity.JtydFansKeywords;
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatform;
import com.thinkgem.jeesite.modules.weixin.entity.JtydSendRate;
import com.thinkgem.jeesite.modules.weixin.entity.JtydSendTasks;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticle;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinUser;
import com.thinkgem.jeesite.modules.weixin.service.JtydFansKeywordsService;
import com.thinkgem.jeesite.modules.weixin.service.JtydPlatformService;
import com.thinkgem.jeesite.modules.weixin.service.JtydSendRateService;
import com.thinkgem.jeesite.modules.weixin.service.JtydSendTasksService;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinArticleService;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinUserService;

/**
 * weixinController
 * @author niu
 * @version 2015-11-14
 */
@Controller
@RequestMapping(value = "${adminPath}/weixin/jtydSendTasks")
public class JtydSendTasksController extends BaseController {

	@Autowired
	private JtydSendTasksService jtydSendTasksService;
	@Autowired
	private JtydWeixinUserService jtydWeixinUserService;
	@Autowired
	private JtydFansKeywordsService jtydFansKeywordsService;
	@Autowired
	private JtydSendRateService jtydSendRateService;
	@Autowired
	private JtydPlatformService jtydPlatformService;
	@Autowired
	private JtydWeixinArticleService jtydWeixinArticleService;
	@ModelAttribute
	public JtydSendTasks get(@RequestParam(required=false) String id) {
		JtydSendTasks entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = jtydSendTasksService.get(id);
		}
		if (entity == null){
			entity = new JtydSendTasks();
		}
		return entity;
	}
	
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = {"list", ""})
	public String list(JtydSendTasks jtydSendTasks, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<JtydSendTasks> page = jtydSendTasksService.findPage(new Page<JtydSendTasks>(request, response), jtydSendTasks); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydSendTasksList";
	}

	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "form")
	public String form(JtydSendTasks jtydSendTasks, Model model) {
		model.addAttribute("jtydSendTasks", jtydSendTasks);
		return "modules/weixin/jtydSendTasksForm";
	}

	@RequiresPermissions("weixin:jtydSendTasks:edit")
	@RequestMapping(value = "save")
	public String save(JtydSendTasks jtydSendTasks, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, jtydSendTasks)){
			return form(jtydSendTasks, model);
		}
		jtydSendTasksService.save(jtydSendTasks);
		addMessage(redirectAttributes, "保存推广设置成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydSendTasks/?repage";
	}
	
	@RequiresPermissions("weixin:jtydSendTasks:edit")
	@RequestMapping(value = "delete")
	public String delete(JtydSendTasks jtydSendTasks, RedirectAttributes redirectAttributes) {
		jtydSendTasksService.delete(jtydSendTasks);
		addMessage(redirectAttributes, "删除推广设置成功");
		return "redirect:"+Global.getAdminPath()+"/weixin/jtydSendTasks/?repage";
	}
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "showConfigs")
	public String showConfigs(JtydSendTasks jtydSendTasks, HttpServletRequest request, HttpServletResponse response, Model model) {
		//查询微信公众号
		JtydWeixinUser entity = new JtydWeixinUser();
		List<JtydWeixinUser> jtydWeixinUserlist = jtydWeixinUserService.findList(entity);
		model.addAttribute("jtydWeixinUserlist", jtydWeixinUserlist);
		//查询粉丝特征
		JtydFansKeywords entity1 = new JtydFansKeywords();
		List<JtydFansKeywords> jtydFansKeywordslist = jtydFansKeywordsService.findList(entity1);
		model.addAttribute("jtydFansKeywordslist", jtydFansKeywordslist);
		//查询发送频率
		JtydSendRate entity2 = new JtydSendRate();
		List<JtydSendRate> jtydSendRatelist = jtydSendRateService.findList(entity2);
		model.addAttribute("jtydSendRatelist", jtydSendRatelist);
		//查询平台
		JtydPlatform entity3 = new JtydPlatform();
		List<JtydPlatform> jtydPlatformlist = jtydPlatformService.findList(entity3);
		model.addAttribute("jtydPlatformlist", jtydPlatformlist);
		//查询文章
		JtydWeixinArticle jtydWeixinArticle = new JtydWeixinArticle();
		Page<JtydWeixinArticle> page = jtydWeixinArticleService.findPage(new Page<JtydWeixinArticle>(request, response), jtydWeixinArticle); 
		model.addAttribute("page", page);
		return "modules/weixin/jtydSendTasksShowConfigs";
	}
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "getArticleList")
	public String getArticleList(@RequestParam(required=false) String weixinCode,String rp, Model model) {
		//查询文章
		JtydWeixinArticle jtydWeixinArticle = new JtydWeixinArticle();
		jtydWeixinArticle.setWeixinCode(weixinCode);
		List<JtydWeixinArticle> jtydWeixinArticleList = jtydWeixinArticleService.findList(jtydWeixinArticle);
		model.addAttribute("jtydWeixinArticleList", jtydWeixinArticleList);
		return "modules/weixin/jtydSendTasks-getArticleList";
	}
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "getPlatformlist")
	public String getPlatformlist(@RequestParam(required=false) String weixinArticleCode,String weixinArticleName, Model model) {
		//查询平台
		JtydPlatform entity3 = new JtydPlatform();
		List<JtydPlatform> jtydPlatformlist = jtydPlatformService.findList(entity3);
		model.addAttribute("jtydPlatformlist", jtydPlatformlist);
		//查询粉丝特征
		JtydFansKeywords entity1 = new JtydFansKeywords();
		List<JtydFansKeywords> jtydFansKeywordslist = jtydFansKeywordsService.findList(entity1);
		model.addAttribute("jtydFansKeywordslist", jtydFansKeywordslist);
		model.addAttribute("weixinArticleCode",weixinArticleCode);
		try {
			model.addAttribute("weixinArticleName",URLDecoder.decode(weixinArticleName,"UTF-8") );
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "modules/weixin/jtydSendTasks-getPlatformlist";
	}
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "getSendRatelist" ,method = RequestMethod.POST)
	public String getSendRatelist(@RequestParam(required=false) 
	        String weixinArticleCode,String weixinArticleName,
	        String jtydPlatformCode,String jtydPlatformName,
	        String fansKeywordsCode,String fansKeywordsName,
	        Model model) {
		//查询发送频率
		JtydSendRate entity2 = new JtydSendRate();
		List<JtydSendRate> jtydSendRatelist = jtydSendRateService.findList(entity2);
		model.addAttribute("jtydSendRatelist", jtydSendRatelist);
		try {
			model.addAttribute("weixinArticleCode",weixinArticleCode);
			model.addAttribute("jtydPlatformCode",jtydPlatformCode);
			model.addAttribute("fansKeywordsCode",fansKeywordsCode);
			model.addAttribute("weixinArticleName",URLDecoder.decode(weixinArticleName,"UTF-8") );
			model.addAttribute("jtydPlatformName",URLDecoder.decode(jtydPlatformName,"UTF-8") );
			model.addAttribute("fansKeywordsName",URLDecoder.decode(fansKeywordsName,"UTF-8") );
			 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "modules/weixin/jtydSendTasks-getSendRatelist";
	}
	@RequiresPermissions("weixin:jtydSendTasks:view")
	@RequestMapping(value = "getSendTask")
	public String getSendTask(@RequestParam(required=false) String weixinCode,String rp, Model model) {
		//生成任务
//		JtydSendRate entity2 = new JtydSendRate();
//		List<JtydSendRate> jtydSendRatelist = jtydSendRateService.findList(entity2);
//		model.addAttribute("jtydSendRatelist", jtydSendRatelist);
		return "modules/weixin/jtydSendTasks-getSendTask";
	}
}