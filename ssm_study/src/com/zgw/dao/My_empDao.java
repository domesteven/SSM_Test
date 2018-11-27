package com.zgw.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.zgw.bean.My_emp;
import com.zgw.pojo.EmpDeptInfoView;
/**
 * 
 * @author domesteven
 * 2018-11-18
 * My_empDao接口
 */
public interface My_empDao {
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<My_emp>
	 */
	public List<My_emp> queryAllEmp();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param eName 通过员工名字查询
	 * @return
	 *List<My_emp>
	 */
	public List<My_emp> getEmpByEname(String eName);
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param map 多条件查询
	 * @return
	 *List<My_emp>
	 */
	public List<My_emp> getEmpByempNoAndEname(Map<Object, Object> map);
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param hireDate
	 * @return
	 *My_emp
	 *通过日期查询
	 */
	public My_emp getEmpByDate(Date hireDate);
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<EmpDeptInfoView>
	 *以默认规则查询数据
	 */
	public List<EmpDeptInfoView> queryView();
	/**
	 * 
	 *author
	 *2018-11-18
	 * @return
	 *List<String>
	 *查询所有的工作职位
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
	 * @param map 带有查询条件和分页规则的map集合
	 * @return
	 *List<EmpDeptInfoView>
	 *带条件的分页查询
	 */
	public List<EmpDeptInfoView> queryViewByMap(Map<Object, Object> map);
	/**
	 * 
	 *author
	 *2018-11-18
	 * @param map 带有条件的map集合
	 * @return
	 *int
	 *根据条件获得符合的数据的总数
	 */
	public int getCount(Map<Object, Object> map);
} 
