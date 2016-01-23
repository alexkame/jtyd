/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticle;
import com.thinkgem.jeesite.modules.weixin.dao.JtydWeixinArticleDao;

/**
 * weixinService
 * @author niu
 * @version 2015-10-18
 */
@Service
@Transactional(readOnly = true)
public class JtydWeixinArticleService extends CrudService<JtydWeixinArticleDao, JtydWeixinArticle> {

	public JtydWeixinArticle get(String id) {
		return super.get(id);
	}
	
	public List<JtydWeixinArticle> findList(JtydWeixinArticle jtydWeixinArticle) {
		return super.findList(jtydWeixinArticle);
	}
	
	public Page<JtydWeixinArticle> findPage(Page<JtydWeixinArticle> page, JtydWeixinArticle jtydWeixinArticle) {
		return super.findPage(page, jtydWeixinArticle);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydWeixinArticle jtydWeixinArticle) {
		super.save(jtydWeixinArticle);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydWeixinArticle jtydWeixinArticle) {
		super.delete(jtydWeixinArticle);
	}
	
}