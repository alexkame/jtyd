/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydSendTasks;
import com.thinkgem.jeesite.modules.weixin.dao.JtydSendTasksDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-14
 */
@Service
@Transactional(readOnly = true)
public class JtydSendTasksService extends CrudService<JtydSendTasksDao, JtydSendTasks> {

	public JtydSendTasks get(String id) {
		return super.get(id);
	}
	
	public List<JtydSendTasks> findList(JtydSendTasks jtydSendTasks) {
		return super.findList(jtydSendTasks);
	}
	
	public Page<JtydSendTasks> findPage(Page<JtydSendTasks> page, JtydSendTasks jtydSendTasks) {
		return super.findPage(page, jtydSendTasks);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydSendTasks jtydSendTasks) {
		super.save(jtydSendTasks);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydSendTasks jtydSendTasks) {
		super.delete(jtydSendTasks);
	}
	
}