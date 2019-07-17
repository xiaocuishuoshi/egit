package com.whfp.oa.manager.jd.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdDhyj;
import com.whfp.oa.manager.jd.bean.JdJdKtv;
import com.whfp.oa.manager.jd.bean.JdKnxx;
import java.util.List;

public abstract interface IJdXXjgService extends IBaseService {
	
  public DataGrid select(PageParam param, JdDhyj jd);
  
  public boolean deleteUser(String[] ids);
  
  public String add(JdDhyj jd);
  
  public String add(JdKnxx jd);
  
  public String updateJdKnxx(JdKnxx jd);
  
  public String selectId(String jd);
  
  public JdJdKtv findBegxx(String paramString);
  
  public JdKnxx findEndxx(String paramString);
  
  public List<Object[]> findsj(String sql);
  
  public abstract List<JdDhyj> selectXx(String hql); 
}
