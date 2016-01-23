/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.weixin.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.weixin.entity.JtydPlatformUsers;

/**
 * weixinDAO接口
 * @author niu
 * @version 2015-11-15
 */
@MyBatisDao
public interface JtydPlatformUsersDao extends CrudDao<JtydPlatformUsers> {
	
}