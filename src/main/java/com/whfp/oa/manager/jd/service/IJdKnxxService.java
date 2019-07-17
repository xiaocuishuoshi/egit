package com.whfp.oa.manager.jd.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jd.bean.JdKnxx;
import java.util.List;

public interface IJdKnxxService extends IBaseService {
  public DataGrid select(PageParam param, JdKnxx Knxx);
  
  public List<JdKnxx> selectXx(String hql);
  
  public String updateKnxx(JdKnxx fg);
}
