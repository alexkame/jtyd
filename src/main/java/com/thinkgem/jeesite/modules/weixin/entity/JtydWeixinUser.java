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
public class JtydWeixinUser extends DataEntity<JtydWeixinUser> {
	
	private static final long serialVersionUID = 1L;
	private String weixinName;		// 公众号名称
	private String weixinCode;		// 公众号
	private String weixinDesc;		// 描述
	
	public JtydWeixinUser() {
		super();
	}

	public JtydWeixinUser(String id){
		super(id);
	}

	@Length(min=1, max=64, message="公众号名称长度必须介于 1 和 64 之间")
	public String getWeixinName() {
		return weixinName;
	}

	public void setWeixinName(String weixinName) {
		this.weixinName = weixinName;
	}
	
	@Length(min=1, max=64, message="公众号长度必须介于 1 和 64 之间")
	public String getWeixinCode() {
		return weixinCode;
	}

	public void setWeixinCode(String weixinCode) {
		this.weixinCode = weixinCode;
	}
	
	@Length(min=0, max=64, message="描述长度必须介于 0 和 64 之间")
	public String getWeixinDesc() {
		return weixinDesc;
	}

	public void setWeixinDesc(String weixinDesc) {
		this.weixinDesc = weixinDesc;
	}
	
}