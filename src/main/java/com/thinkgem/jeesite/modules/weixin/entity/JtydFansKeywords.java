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
public class JtydFansKeywords extends DataEntity<JtydFansKeywords> {
	
	private static final long serialVersionUID = 1L;
	private String keywords;		// 关键词描述
	private String flag;		// 添加标志
	
	public JtydFansKeywords() {
		super();
	}

	public JtydFansKeywords(String id){
		super(id);
	}

	@Length(min=0, max=64, message="关键词描述长度必须介于 0 和 64 之间")
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	@Length(min=0, max=64, message="添加标志长度必须介于 0 和 64 之间")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}