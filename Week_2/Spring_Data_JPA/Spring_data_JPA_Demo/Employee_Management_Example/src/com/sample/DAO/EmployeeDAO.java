package com.sample.DAO;
import java.util.List;
import com.sample.Models.Employee;

public interface EmployeeDAO {
  void Save(Employee emp);
  void Update(Employee emp);
  void Delete(int id);
  List<Employee> GetAll();
  
}
