package com.whfp.oa.manager.hlkj.sbgl.service;

import java.util.List;
import java.util.Map;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.hlkj.sbgl.bean.HlkjSbgl;
import com.whfp.oa.manager.system.bean.SyLoginLog;
import com.whfp.oa.manager.system.bean.SyUsers;

public interface ISbglService extends IBaseService {

	
	public String addSbgl(HlkjSbgl s,String bel);
	
	public List getAddress(String lm);
	
    public List<Map<String,Object>> selectAddressByLmMap(String lm);
    
    public DataGrid selectSbgl(PageParam param,HlkjSbgl  s);
    
    public DataGrid selectSbglSin(PageParam param,HlkjSbgl  s);
    
    public SyUsers findUser(String username);
    
    public boolean updateUser(SyUsers us);
    
    public boolean saveLoginLog(SyLoginLog sl);
    
    public DataGrid selectAllSb(PageParam param,HlkjSbgl  s);
   
}
