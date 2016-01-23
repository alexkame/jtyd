/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydSendRate;
import com.thinkgem.jeesite.modules.weixin.dao.JtydSendRateDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-14
 */
@Service
@Transactional(readOnly = true)
public class JtydSendRateService extends CrudService<JtydSendRateDao, JtydSendRate> {

	public JtydSendRate get(String id) {
		return super.get(id);
	}
	
	public List<JtydSendRate> findList(JtydSendRate jtydSendRate) {
		return super.findList(jtydSendRate);
	}
	
	public Page<JtydSendRate> findPage(Page<JtydSendRate> page, JtydSendRate jtydSendRate) {
		return super.findPage(page, jtydSendRate);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydSendRate jtydSendRate) {
		super.save(jtydSendRate);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydSendRate jtydSendRate) {
		super.delete(jtydSendRate);
	}
	
}