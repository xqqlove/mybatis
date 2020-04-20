package com.yiwa.mybatisDao;

import com.yiwa.mybatisBean.Department;
import com.yiwa.mybatisBean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
  public Employee getEmployeeById(Integer id);
  public Employee getEmployeeById1(Integer id);
  public Boolean insetEmployee(Employee employee);
  public Employee getEmployeeByIdAndLastName(@Param("id") Integer id, @Param("lastName")String lastName);
  public Employee getEmployeeByMap(Map<String,Object> map);
  public List<Employee> getEmployeeListsById(String lastName);
  public Map<String ,Object> getEmployeeByIdReturnMap(Integer id);
  @MapKey("lastName")
  public Map<String,Employee> getEmployeeByLastNameLikeMap(String lastName);

  public Employee getJoinEmployeeById(Integer id);
  public Department getDeptById(Integer id);
  public Employee getEmptByIdStep(Integer id);
  public Department getDeptListById(Integer id);






}
