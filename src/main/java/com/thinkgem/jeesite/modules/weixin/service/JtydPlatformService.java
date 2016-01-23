/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatform;
import com.thinkgem.jeesite.modules.weixin.dao.JtydPlatformDao;

/**
 * weixinService
 * @author niu
 * @version 2015-10-19
 */
@Service
@Transactional(readOnly = true)
public class JtydPlatformService extends CrudService<JtydPlatformDao, JtydPlatform> {

	public JtydPlatform get(String id) {
		return super.get(id);
	}
	
	public List<JtydPlatform> findList(JtydPlatform jtydPlatform) {
		return super.findList(jtydPlatform);
	}
	
	public Page<JtydPlatform> findPage(Page<JtydPlatform> page, JtydPlatform jtydPlatform) {
		return super.findPage(page, jtydPlatform);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydPlatform jtydPlatform) {
		super.save(jtydPlatform);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydPlatform jtydPlatform) {
		super.delete(jtydPlatform);
	}
	
}