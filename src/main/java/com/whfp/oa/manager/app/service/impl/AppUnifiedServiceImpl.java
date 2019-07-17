package com.whfp.oa.manager.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.whfp.framework.core.dao.base.INormalBaseDao;
import com.whfp.framework.core.dao.base.impl.NormalBaseServiceImpl;
import com.whfp.oa.manager.app.service.AppUnifiedService;
import com.whfp.oa.manager.jd.bean.JdRyb;

@Service
public class AppUnifiedServiceImpl  extends  NormalBaseServiceImpl<JdRyb> implements AppUnifiedService{

	 @Resource(name = "normalBaseDaoImpl")
	 private INormalBaseDao normalBaseDao;

}
