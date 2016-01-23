/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.weixin.entity.JtydWeixinArticlePlatformRef;
import com.thinkgem.jeesite.modules.weixin.dao.JtydWeixinArticlePlatformRefDao;

/**
 * weixinService
 * @author niu
 * @version 2015-10-19
 */
@Service
@Transactional(readOnly = true)
public class JtydWeixinArticlePlatformRefService extends CrudService<JtydWeixinArticlePlatformRefDao, JtydWeixinArticlePlatformRef> {

	
	public JtydWeixinArticlePlatformRef get(String id) {
		JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef = super.get(id);
		return jtydWeixinArticlePlatformRef;
	}
	
	public List<JtydWeixinArticlePlatformRef> findList(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef) {
		return super.findList(jtydWeixinArticlePlatformRef);
	}
	
	public Page<JtydWeixinArticlePlatformRef> findPage(Page<JtydWeixinArticlePlatformRef> page, JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef) {
		return super.findPage(page, jtydWeixinArticlePlatformRef);
	}
	
	@Transactional(readOnly = false)
	public void save(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef) {
		super.save(jtydWeixinArticlePlatformRef);
	}
	
	@Transactional(readOnly = false)
	public void delete(JtydWeixinArticlePlatformRef jtydWeixinArticlePlatformRef) {
		super.delete(jtydWeixinArticlePlatformRef);
	}
	
}