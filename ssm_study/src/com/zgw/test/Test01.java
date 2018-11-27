package com.zgw.test;


import java.io.InputStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.zgw.dao.My_empDao;
import com.zgw.pojo.EmpDeptInfoView;
import com.zgw.pojo.querybean;

public class Test01 {
	public static void main(String[] args) throws Exception {
		InputStream in=Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(in);
		SqlSession session=sessionFactory.openSession();
//		Map<Object, Object> map=new HashMap<Object, Object>();
//		map.put("eName", "steven");
//		map.put("empNo", 7369);
//		String sdate="1980-12-17 00:00:00";
//		Date date=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(sdate);
		My_empDao empdao=session.getMapper(My_empDao.class);
//		My_emp my_emp=empdao.getEmpByDate(date);
////		for (My_emp my_emp : list) {
//			System.out.println(my_emp);
////		}
//		List<EmpDeptInfoView> list=empdao.queryView();
//		for (EmpDeptInfoView empDeptInfoView : list) {
//			System.out.println(empDeptInfoView.getEmpNo());
//		}
		querybean bean=new querybean();
		bean.setCount(14);
		bean.setCurrNum(1);
		bean.setPageSize(5);
		Map<Object, Object> map=new HashMap<Object, Object>();
		map.put("eName", "%%");
		map.put("dName", "%%");
		map.put("loc", "%%");
		map.put("bean", bean);
		List<EmpDeptInfoView> list=empdao.queryViewByMap(map);
		for (EmpDeptInfoView empDeptInfoView : list) {
			System.out.println(empDeptInfoView.getEmpNo());
		}
	}
}
