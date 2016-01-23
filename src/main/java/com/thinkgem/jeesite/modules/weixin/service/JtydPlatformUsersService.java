/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatformUsers;
import com.thinkgem.jeesite.modules.weixin.dao.JtydPlatformUsersDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-15
 */
@Service
@Transactional(readOnly = true)
public class JtydPlatformUsersService extends CrudService<JtydPlatformUsersDao, JtydPlatformUsers> {

	public JtydPlatformUsers get(String id) {
		return super.get(id);
	}
	
	public List<JtydPlatformUsers> findList(JtydPlatformUsers jtydPlatformUsers) {
		return super.findList(jtydPlatformUsers);
	}
	
	public Page<JtydPlatformUsers> findPage(Page<JtydPlatformUsers> page, JtydPlatformUsers jtydPlatformUsers) {
		return super.findPage(page, jtydPlatformUsers);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydPlatformUsers jtydPlatformUsers) {
		super.save(jtydPlatformUsers);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydPlatformUsers jtydPlatformUsers) {
		super.delete(jtydPlatformUsers);
	}
	
}