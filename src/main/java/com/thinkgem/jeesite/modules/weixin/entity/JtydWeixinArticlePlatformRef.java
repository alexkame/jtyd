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
public class JtydWeixinArticlePlatformRef extends DataEntity<JtydWeixinArticlePlatformRef> {
	
	private static final long serialVersionUID = 1L;
	private String platformId;		// 平台编码
	private String articleId;		// 文章id
	private String articleUrl;		// 文章url
	private String articleName;		// 文章名称
	
	public JtydWeixinArticlePlatformRef() {
		super();
	}

	public JtydWeixinArticlePlatformRef(String id){
		super(id);
	}

	@Length(min=1, max=64, message="平台编码长度必须介于 1 和 64 之间")
	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	
	@Length(min=0, max=200, message="文章id长度必须介于 0 和 200 之间")
	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	@Length(min=0, max=64, message="文章url长度必须介于 0 和 64 之间")
	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl;
	}
	
	@Length(min=0, max=200, message="文章名称长度必须介于 0 和 200 之间")
	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	
}