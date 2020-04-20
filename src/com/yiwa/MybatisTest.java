package com.yiwa;


import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import com.yiwa.mybatisBean.Department;
import com.yiwa.mybatisBean.Employee;
import com.yiwa.mybatisDao.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    public SqlSessionFactory getSqlSessionFactory() throws IOException  {
        String resource = "conf/mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Employee employee=new Employee();
        employee.setLastName("qiangqiang");
        employee.setGender("0");
        employee.setEmail("184832389@qq.com");
        Map<String,Object> map=new HashMap<>();
        map.put("id",1);
        map.put("lastName","tom");
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//            Employee employee1 = mapper.getEmployeeById(1);
            Employee tom = mapper.getEmployeeByIdAndLastName(1, "tom");
            Employee employeeByMap = mapper.getEmployeeByMap(map);
            List<Employee> qiang = mapper.getEmployeeListsById("q%");
            Map<String, Object> employeeByIdReturnMap = mapper.getEmployeeByIdReturnMap(1);
            Map<String, Employee> employeeByLastNameLikeMap = mapper.getEmployeeByLastNameLikeMap("%q%");
            Employee joinEmployeeById = mapper.getJoinEmployeeById(1);
//            Boolean num=mapper.insetEmployee(employee);
//            sqlSession.commit();
//            System.out.println(employeeByIdReturnMap.get("lastName"));
            Employee employeeById1 = mapper.getEmployeeById1(1);
            System.out.println(joinEmployeeById);
//            System.out.println(employee.getId());
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test2() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee joinEmployeeById = mapper.getJoinEmployeeById(1);
            Employee emptByIdStep = mapper.getEmptByIdStep(2);
            Department deptListById = mapper.getDeptListById(1);
            System.out.println(deptListById);
        } finally {
            sqlSession.close();
        }
    }
}
