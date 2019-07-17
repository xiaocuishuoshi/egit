
package com.whfp.oa.manager.jiedu.service;

import com.whfp.oa.commons.base.IBaseService;
import com.whfp.oa.commons.model.DataGrid;
import com.whfp.oa.commons.model.PageParam;
import com.whfp.oa.manager.jiedu.bean.JdActTalk;
import com.whfp.oa.manager.jiedu.bean.JdActVisit;

/**
 * 操作（谈话，走访）
 * @author wenhu
 *
 */
public interface JdActService extends  IBaseService{
	
	//谈话
	public DataGrid selectTalkList(PageParam param,JdActTalk m);
	public boolean saveTalk(JdActTalk m);
	public JdActTalk findTalkById(Long id);
	public boolean deleteTalk(Long[] ids);
	
	//走访
	public DataGrid selectVisitList(PageParam param,JdActVisit m);
	public boolean saveVisit(JdActVisit m);
	public JdActVisit findVisitById(Long id);
	public boolean deleteVisit(Long[] ids);
	
	
	
}
