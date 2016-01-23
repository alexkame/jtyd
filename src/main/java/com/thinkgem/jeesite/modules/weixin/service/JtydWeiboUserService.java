/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeiboUser;
import com.thinkgem.jeesite.modules.weixin.dao.JtydWeiboUserDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-14
 */
@Service
@Transactional(readOnly = true)
public class JtydWeiboUserService extends CrudService<JtydWeiboUserDao, JtydWeiboUser> {

	public JtydWeiboUser get(String id) {
		return super.get(id);
	}
	
	public List<JtydWeiboUser> findList(JtydWeiboUser jtydWeiboUser) {
		return super.findList(jtydWeiboUser);
	}
	
	public Page<JtydWeiboUser> findPage(Page<JtydWeiboUser> page, JtydWeiboUser jtydWeiboUser) {
		return super.findPage(page, jtydWeiboUser);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydWeiboUser jtydWeiboUser) {
		super.save(jtydWeiboUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydWeiboUser jtydWeiboUser) {
		super.delete(jtydWeiboUser);
	}
	
}