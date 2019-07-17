package com.whfp.oa.manager.jiedu.service.impl;

import org.springframework.stereotype.Service;

import com.whfp.oa.commons.base.BaseServiceImpl;
import com.whfp.oa.manager.jiedu.service.JieduCommService;
import com.whfp.oa.manager.system.bean.SyUsers;

@Service
public class JieduCommServiceImpl  extends BaseServiceImpl implements JieduCommService{

	@Override
	public SyUsers findAccountByName(String name) {
		
		SyUsers u = (SyUsers) dao.findOne(
				"from SyUsers where userName = ?", new Object[] { name });
		
		return u;
	}

	@Override
	public SyUsers findAccountByMobile(String mobile) {
		
		SyUsers u = (SyUsers) dao.findOne(
				"from SyUsers where mobilePhoneNumber = ?", new Object[] { mobile });
		
		return u;
	}

	

	
}
