/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-11-14
 */
public class JtydSendTasks extends DataEntity<JtydSendTasks> {
	
	private static final long serialVersionUID = 1L;
	private String articleId;		// 文章编码
	private String platformId;		// 推广平台编码
	private String userName;		// 用户名
	private String userPassword;		// 密码
	private String sendRateId;		// 发送频率
	private String fansKeywordsId;		// 粉丝特征
	private String flag;		// 状态，1带执行，2处理中，3已完成，4其他
	private String concents;		// 自定义推广内容
	
	public JtydSendTasks() {
		super();
	}

	public JtydSendTasks(String id){
		super(id);
	}

	@Length(min=0, max=200, message="文章编码长度必须介于 0 和 200 之间")
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	@Length(min=0, max=200, message="推广平台编码长度必须介于 0 和 200 之间")
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	@Length(min=0, max=200, message="用户名长度必须介于 0 和 200 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=200, message="密码长度必须介于 0 和 200 之间")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Length(min=0, max=200, message="发送频率长度必须介于 0 和 200 之间")
	public String getSendRateId() {
		return sendRateId;
	}

	public void setSendRateId(String sendRateId) {
		this.sendRateId = sendRateId;
	}
	
	@Length(min=0, max=200, message="粉丝特征长度必须介于 0 和 200 之间")
	public String getFansKeywordsId() {
		return fansKeywordsId;
	}

	public void setFansKeywordsId(String fansKeywordsId) {
		this.fansKeywordsId = fansKeywordsId;
	}
	
	@Length(min=0, max=200, message="状态，1带执行，2处理中，3已完成，4其他长度必须介于 0 和 200 之间")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	@Length(min=0, max=200, message="自定义推广内容长度必须介于 0 和 200 之间")
	public String getConcents() {
		return concents;
	}

	public void setConcents(String concents) {
		this.concents = concents;
	}
	
}