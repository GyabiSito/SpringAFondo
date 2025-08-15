package com.gyabisito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int create(Employee emp) {
        String sql = "insert into employee values(?,?,?)";
        int res = jdbcTemplate.update(sql, emp.getId(),emp.getFirstName(),emp.getLastName());
        return res;
    }

    @Override
    public int update(Employee emp) {
        String sql = "update employee set firstName=?,lastName=? where id=?";
        int res = jdbcTemplate.update(sql, emp.getFirstName(),emp.getLastName(),emp.getId());
        return res;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from employee where id=?";
        int res = jdbcTemplate.update(sql, id);
        return res;
    }

    @Override
    public Employee read(int id) {
        String sql = "select * from employee where id=?";
        EmployeeRowmapper rowmapper = new EmployeeRowmapper();
        Employee employee=jdbcTemplate.queryForObject(sql,rowmapper,id);
        return employee;
    }

    @Override
    public List<Employee> readAll() {
        String sql = "select * from employee";
        EmployeeRowmapper rowmapper = new EmployeeRowmapper();
        List<Employee> employees=jdbcTemplate.query(sql,rowmapper);
        return employees;
    }

    public JdbcTemplate getJdbcTemplate() {

        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
