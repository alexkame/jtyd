/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * weixinEntity
 * @author niu
 * @version 2015-10-19
 */
public class JtydPlatform extends DataEntity<JtydPlatform> {
	
	private static final long serialVersionUID = 1L;
	private String platformName;		// 平台名称
	private String platformCode;		// 平台编码
	
	public JtydPlatform() {
		super();
	}

	public JtydPlatform(String id){
		super(id);
	}

	@Length(min=0, max=200, message="平台名称长度必须介于 0 和 200 之间")
	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	
	@Length(min=0, max=64, message="平台编码长度必须介于 0 和 64 之间")
	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}
	
}