package com.zgw.service;

import java.util.List;
import java.util.Map;

import com.zgw.pojo.EmpDeptInfoView;
/**
 * 
 * @author domesteven
 * 2018-11-18
 * service层接口
 */
public interface EmpDeptViewService {
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<EmpDeptInfoView>
	 *查询所有的view
	 */
	public List<EmpDeptInfoView> queryView();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<String>
	 *查询所有的工作
	 */
	public List<String> queryJob();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<String>
	 *查询所有的部门名称
	 */
	public List<String> queryDeptName();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<String>
	 *查询所有的工作地点
	 */
	public List<String> queryLoc();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param map 传入条件查询的值以及分页的规则
	 * @return
	 *List<EmpDeptInfoView>
	 *分页的条件查询，返回查询集合
	 */
	public List<EmpDeptInfoView> queryViewByMap(Map<Object, Object> map);
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param map 传入条件查询的值
	 * @return
	 *int
	 *返回一个数据总数
	 */
	public int getCount(Map<Object, Object> map);
}
