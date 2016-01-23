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
public class JtydSendRate extends DataEntity<JtydSendRate> {
	
	private static final long serialVersionUID = 1L;
	private String keywordsDesc;		// 描述
	
	public JtydSendRate() {
		super();
	}

	public JtydSendRate(String id){
		super(id);
	}

	@Length(min=0, max=200, message="描述长度必须介于 0 和 200 之间")
	public String getKeywordsDesc() {
		return keywordsDesc;
	}

	public void setKeywordsDesc(String keywordsDesc) {
		this.keywordsDesc = keywordsDesc;
	}
	
}