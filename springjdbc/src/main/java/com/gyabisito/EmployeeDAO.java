package com.gyabisito;

import java.util.List;

public interface EmployeeDAO {
    int create(Employee emp);
    int update(Employee emp);
    int delete(int id);
    Employee read(int id);
    List<Employee> readAll();
}
