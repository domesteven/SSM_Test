package com.zgw.service.impl;


import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.zgw.dao.My_empDao;
import com.zgw.pojo.EmpDeptInfoView;
import com.zgw.service.EmpDeptViewService;
/**
 * 
 * @author domesteven
 * 2018-11-18
 * 实现EmpDeptViewService 接口
 */
@Service
public class EmpDeptViewServiceImpl implements EmpDeptViewService {
	/*定义一个全局的My_empDao*/
	@Resource
	private My_empDao empdao;
	
	@Override
	public List<EmpDeptInfoView> queryView() {
		// TODO Auto-generated method stub
		List<EmpDeptInfoView> list=empdao.queryView();
		return list;
	}

	@Override
	public List<String> queryJob() {
		// TODO Auto-generated method stub	
		List<String> list=empdao.queryJob();
		return list;
	}
	@Override
	public List<String> queryDeptName() {
		// TODO Auto-generated method stub	
		List<String> list=empdao.queryDeptName();
		return list;
	}
	@Override
	public List<String> queryLoc() {
		// TODO Auto-generated method stub
		List<String> list=empdao.queryLoc();
		return list;
	}
	@Override
	public List<EmpDeptInfoView> queryViewByMap(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		List<EmpDeptInfoView> list=empdao.queryViewByMap(map);
		return list;
	}
	@Override
	public int getCount(Map<Object, Object> map) {
		// TODO Auto-generated method stub
		int count=empdao.getCount(map);
		return count;
	}
	
}
