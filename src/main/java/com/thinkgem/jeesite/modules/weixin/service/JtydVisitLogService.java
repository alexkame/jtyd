/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.weixin.entity.JtydVisitLog;
import com.thinkgem.jeesite.modules.weixin.dao.JtydVisitLogDao;

/**
 * weixinService
 * @author niu
 * @version 2015-11-29
 */
@Service
@Transactional(readOnly = true)
public class JtydVisitLogService extends CrudService<JtydVisitLogDao, JtydVisitLog> {

	public JtydVisitLog get(String id) {
		return super.get(id);
	}
	
	public List<JtydVisitLog> findList(JtydVisitLog jtydVisitLog) {
		return super.findList(jtydVisitLog);
	}
	
	public Page<JtydVisitLog> findPage(Page<JtydVisitLog> page, JtydVisitLog jtydVisitLog) {
		return super.findPage(page, jtydVisitLog);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydVisitLog jtydVisitLog) {
		super.save(jtydVisitLog);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydVisitLog jtydVisitLog) {
		super.delete(jtydVisitLog);
	}
	
}