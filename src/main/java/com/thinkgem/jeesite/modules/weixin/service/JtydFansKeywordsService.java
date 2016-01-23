/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydFansKeywords;
import com.thinkgem.jeesite.modules.weixin.dao.JtydFansKeywordsDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-14
 */
@Service
@Transactional(readOnly = true)
public class JtydFansKeywordsService extends CrudService<JtydFansKeywordsDao, JtydFansKeywords> {

	public JtydFansKeywords get(String id) {
		return super.get(id);
	}
	
	public List<JtydFansKeywords> findList(JtydFansKeywords jtydFansKeywords) {
		return super.findList(jtydFansKeywords);
	}
	
	public Page<JtydFansKeywords> findPage(Page<JtydFansKeywords> page, JtydFansKeywords jtydFansKeywords) {
		return super.findPage(page, jtydFansKeywords);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydFansKeywords jtydFansKeywords) {
		super.save(jtydFansKeywords);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydFansKeywords jtydFansKeywords) {
		super.delete(jtydFansKeywords);
	}
	
}