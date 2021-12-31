package com.mnr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mnr.pojo.Employee;

public class EmployeeJdbc {


    private static String dbURL = "jdbc:h2:tcp://localhost:9092/~/employeeDB";
    private static String username = "sa";
    private static String password = "";

    //private static String dbURL = "jdbc:mysql://localhost:3306/DB_MVC_CAT";
    //private static String username = "root";
    //private static String password = "Mounir15429";


    private static Connection connection=null;
    static {
        try {
            //add jar of h2 to librairies
            Class.forName("org.h2.Driver");
            //Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(dbURL, username, password);

            if (connection != null) {
                System.out.println("Connected");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees=new ArrayList();
        Employee employee=null;
        try {
            String sql = "select * from employee";
            Statement createStmt=connection.createStatement();
            ResultSet result=createStmt.executeQuery(sql);
            while(result.next())
            {
                int id = result.getInt(1);
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String department = result.getString(4);
                employee= new Employee(id, firstName, lastName, department);
                employees.add(employee);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employees;
    }

    public Employee getEmployee(int id) {
        Employee employee=null;
        try {
            String sql = "select * from employee where id="+id;
            Statement createStmt=connection.createStatement();
            ResultSet result=createStmt.executeQuery(sql);
            if(result.next())
            {
                String firstName = result.getString(1);
                String lastName = result.getString(2);
                String department = result.getString(3);
                employee= new Employee(id, firstName, lastName, department);
            }else
            {
                System.out.println("No record found");
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
        return employee;
    }

    public boolean deleteEmployee(int id) {
        try {
            String sql = "delete from employee where id="+id;
            Statement createStmt=connection.createStatement();
            createStmt.executeUpdate(sql);
            System.out.println("Deleted successfully");
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean createEmployee(int id, String firstName, String lastName, String department) {
        try {
            String sql = "INSERT INTO employee (id, firstName, lastName, department) VALUES ("+id+", '"+firstName+"', '"+lastName+"', '"+department+"')";
            Statement createStmt=connection.createStatement();
            createStmt.executeUpdate(sql);
            System.out.println("Created successfully");
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateEmployee(int id, String firstName, String lastName, String department) {
        try {
            String sql = "update employee"
                    + " set firstName='"+firstName+"', "
                    + "lastName='"+lastName+"', "
                    + "department='"+department+"' "
                    + "where id="+id;
            Statement createStmt=connection.createStatement();
            createStmt.executeUpdate(sql);
            System.out.println("Updated successfully");
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
