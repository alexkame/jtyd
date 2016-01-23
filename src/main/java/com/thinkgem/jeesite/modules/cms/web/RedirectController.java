/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.cms.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkgem.jeesite.common.utils.AddressUtils;
import com.thinkgem.jeesite.common.utils.BrowseTool;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.weixin.entity.JtydVisitLog;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticle;
import com.thinkgem.jeesite.modules.weixin.service.JtydVisitLogService;
import com.thinkgem.jeesite.modules.weixin.service.JtydWeixinArticleService;

/**
 * 重定向Controller
 * 
 * @author ThinkGem
 * @version 2013-3-15
 */
@Controller
@RequestMapping(value = "${frontPath}/rd")
public class RedirectController extends BaseController {

	@Autowired
	private JtydWeixinArticleService jtydWeixinArticleService;
	@Autowired
	private JtydVisitLogService jtydVisitLogService;

	@RequestMapping(value = "wx")
	public String redirectUrl(HttpServletRequest request) {
		// 用户id jtyd_userid
		// 文章id jtyd_article_id
		// jtyd_task_id：任务表的任务ID
		// from_plantform_id 从什么平台 我们这里是微信
		// to_plantform_id 到哪个平台 我们这里是 微博
		// www.wmjtyd.com/f/rd/wx/jtyd_userid=123&jtyd_article_id=45
		// jtyd_userid=1811578147&jtyd_article_id=296&jtyd_task_id=3&plantform_id=1&from_plantform_id=1&to_plantform_id=2
//		http://localhost:8080/jeesite/f/rd/wx?
//		jtyd_userid=1811578147&jtyd_article_id=296&jtyd_task_id=3&plantform_id=1&from_plantform_id=1&to_plantform_id=2
		JtydVisitLog jtydVisitLog = new JtydVisitLog();
		String Agent = request.getHeader("User-Agent");
		// 客户端请求详细信息
		jtydVisitLog.setRemarks(Agent);
		// 浏览器类型
		jtydVisitLog.setBrowserType(BrowseTool.checkBrowse(Agent));
		// 它主要是用于获取链接的上一个引用 来源页面
		jtydVisitLog.setReferer(request.getHeader("referer"));
		// 解析 使用平台
		jtydVisitLog.setClientType(BrowseTool.browseType(Agent));
		//获取IP
		String ip = AddressUtils.getIpAddress(request);
		jtydVisitLog.setVisitIp(ip);
		jtydVisitLog.setVisitDate(new Date());
		// 获取省份和城市
		String pc = AddressUtils.getAddressByIP(ip);
		String pcs[] = pc.split("=");
		jtydVisitLog.setProvince(pcs[0]);
		jtydVisitLog.setCity(pcs[1]);
		jtydVisitLog.setWbuserId(request.getParameter("jtyd_userid"));
		jtydVisitLog.setToPlantformId(request.getParameter("to_plantform_id"));
		jtydVisitLog.setFromPlantformId(request.getParameter("from_plantform_id"));
		jtydVisitLog.setJtydTaskId(request.getParameter("jtyd_task_id"));
		JtydWeixinArticle jtydWeixinArticle = null;
		if (StringUtils.isNotBlank(request.getParameter("jtyd_article_id"))) {
			jtydWeixinArticle = jtydWeixinArticleService.get(request.getParameter("jtyd_article_id"));
		}
		if (jtydWeixinArticle != null&& StringUtils.isNotBlank(jtydWeixinArticle.getArticleUrl())) {
			jtydVisitLog.setArticleId(jtydWeixinArticle.getId());
			jtydVisitLogService.save(jtydVisitLog);
			return "redirect:" + jtydWeixinArticle.getArticleUrl();
		}
		return "redirect:http://www.wmjtyd.com";
	}
}
