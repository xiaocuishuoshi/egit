package com.whfp.oa.manager.jiedu.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.manager.system.bean.SyUsers;

public interface JieduCommService  extends  IBaseService{

	SyUsers findAccountByName(String name);
	
	SyUsers findAccountByMobile(String mobile);
}
