/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-10-18
 */
public class JtydWeixinArticle extends DataEntity<JtydWeixinArticle> {
	
	private static final long serialVersionUID = 1L;
	private String weixinName;		// 公众号名称
	private String weixinCode;		// 公众号
	private String articleName;		// 文章标题
	private String articleUrl;		// 文章地址
	private String articleContent;		// 文章内容
	
//	jtyd_task_id：任务表的任务ID 
//	from_plantform_id  从什么平台 我们这里是微信   
//	to_plantform_id 到哪个平台 我们这里是 微博  
	 
	private String jtydTaskId;		// 文章内容
	private String fromPlantformId;		// 文章内容
	private String toPlantformId;		// 文章内容
	private String clientType;		// 文章内容
	
	public JtydWeixinArticle() {
		super();
	}

	public JtydWeixinArticle(String id){
		super(id);
	}

	@Length(min=0, max=200, message="公众号名称长度必须介于 0 和 200 之间")
	public String getWeixinName() {
		return weixinName;
	}

	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}
	
	@Length(min=0, max=64, message="公众号长度必须介于 0 和 64 之间")
	public String getWeixinCode() {
		return weixinCode;
	}

	public void setWeixinCode(String weixinCode) {
		this.weixinCode = weixinCode;
	}
	
	@Length(min=0, max=200, message="文章标题长度必须介于 0 和 200 之间")
	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	
	@Length(min=1, max=600, message="文章地址长度必须介于 1 和 600 之间")
	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	
	@Length(min=0, max=5000, message="文章内容长度必须介于 0 和 5000 之间")
	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
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

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
}