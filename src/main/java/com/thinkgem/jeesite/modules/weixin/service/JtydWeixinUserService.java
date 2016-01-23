/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinUser;
import com.thinkgem.jeesite.modules.weixin.dao.JtydWeixinUserDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-14
 */
@Service
@Transactional(readOnly = true)
public class JtydWeixinUserService extends CrudService<JtydWeixinUserDao, JtydWeixinUser> {

	public JtydWeixinUser get(String id) {
		return super.get(id);
	}
	
	public List<JtydWeixinUser> findList(JtydWeixinUser jtydWeixinUser) {
		return super.findList(jtydWeixinUser);
	}
	
	public Page<JtydWeixinUser> findPage(Page<JtydWeixinUser> page, JtydWeixinUser jtydWeixinUser) {
		return super.findPage(page, jtydWeixinUser);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydWeixinUser jtydWeixinUser) {
		super.save(jtydWeixinUser);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydWeixinUser jtydWeixinUser) {
		super.delete(jtydWeixinUser);
	}
	
}