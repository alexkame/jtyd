/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-11-15
 */
public class JtydPlatformUsers extends DataEntity<JtydPlatformUsers> {
	
	private static final long serialVersionUID = 1L;
	private String platformId;		// 平台编码
	private String userName;		// 用户名
	private String userAcct;		// 登录账号
	private String userPassword;		// 登录密码
	
	public JtydPlatformUsers() {
		super();
	}

	public JtydPlatformUsers(String id){
		super(id);
	}

	@Length(min=0, max=200, message="平台编码长度必须介于 0 和 200 之间")
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	@Length(min=0, max=64, message="用户名长度必须介于 0 和 64 之间")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Length(min=0, max=600, message="登录账号长度必须介于 0 和 600 之间")
	public String getUserAcct() {
		return userAcct;
	}

	public void setUserAcct(String userAcct) {
		this.userAcct = userAcct;
	}
	
	@Length(min=0, max=200, message="登录密码长度必须介于 0 和 200 之间")
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}