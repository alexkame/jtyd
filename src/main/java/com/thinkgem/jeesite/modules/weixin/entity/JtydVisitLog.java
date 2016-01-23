/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-11-29
 */
public class JtydVisitLog extends DataEntity<JtydVisitLog> {
	
	private static final long serialVersionUID = 1L;
	private String wbuserId;		// 用户微博id
	private String articleId;		// 访问的微信文章
	private String visitIp;		// 用户IP
	private Date visitDate;		// 访问时间
	private String browserType;		// 浏览器类型
	private String browserVersions;		// 浏览器版本
	private String province;		// 省份
	private String city;		// 市县

	private String jtydTaskId;		// 任务表的任务ID 
	private String fromPlantformId;		//  从什么平台 我们这里是微信   
	private String toPlantformId;		// 到哪个平台 我们这里是 微博  
	private String referer;		// 上级页面
	private String clientType;		//客户端类型
	private String articleName;
	private String userName;
	
	public JtydVisitLog() {
		super();
	}

	public JtydVisitLog(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户微博id长度必须介于 0 和 64 之间")
	public String getWbuserId() {
		return wbuserId;
	}

	public void setWbuserId(String wbuserId) {
		this.wbuserId = wbuserId;
	}
	
	@Length(min=0, max=64, message="访问的微信文章长度必须介于 0 和 64 之间")
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	@Length(min=0, max=2000, message="用户IP长度必须介于 0 和 2000 之间")
	public String getVisitIp() {
		return visitIp;
	}

	public void setVisitIp(String visitIp) {
		this.visitIp = visitIp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	@Length(min=0, max=64, message="浏览器类型长度必须介于 0 和 64 之间")
	public String getBrowserType() {
		return browserType;
	}

	public void setBrowserType(String browserType) {
		this.browserType = browserType;
	}
	
	@Length(min=0, max=64, message="浏览器版本长度必须介于 0 和 64 之间")
	public String getBrowserVersions() {
		return browserVersions;
	}

	public void setBrowserVersions(String browserVersions) {
		this.browserVersions = browserVersions;
	}
	
	@Length(min=0, max=64, message="省份长度必须介于 0 和 64 之间")
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	
	@Length(min=0, max=64, message="市县长度必须介于 0 和 64 之间")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getJtydTaskId() {
		return jtydTaskId;
	}

	public void setJtydTaskId(String jtydTaskId) {
		this.jtydTaskId = jtydTaskId;
	}

	public String getFromPlantformId() {
		return fromPlantformId;
	}

	public void setFromPlantformId(String fromPlantformId) {
		this.fromPlantformId = fromPlantformId;
	}

	public String getToPlantformId() {
		return toPlantformId;
	}

	public void setToPlantformId(String toPlantformId) {
		this.toPlantformId = toPlantformId;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}