/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.sql.DataSource;
import models.Student;

/**
 *
 * @author Сергей
 */
@Stateful
public class StatefullStudentDAO implements StatefullStudentDAOLocal {
     
    private int count;
    @Inject
    Conversation conv;
    @Resource(lookup = "jdbc/studentJ")
    private DataSource dataSource;

    @PostConstruct
    public void initStart() {//
        count = 0;
    }
    
    public void endConv(){
        count = 0;
        if (!conv.isTransient()) {
            conv.end();
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public int addStudent(Student student) {
         try (Connection connection = dataSource.getConnection()) {
            String query = "INSERT INTO student "
                    + "(name, surname, age)"
                    + "VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurName());
            stmt.setInt(3, student.getAge());
            stmt.execute();
            if (conv.isTransient()) {
                conv.begin();
            }
            count++;
            return count;
           
        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in lisStudents methos", ex);
        }
    }

    @Override
    public int editStudent(Student student) throws Exception {
       try (Connection connection = dataSource.getConnection()) {
            String query = "UPDATE  student "
                    + "set name=?, surname=?, age=? where id=? ";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getSurName());
            stmt.setInt(3, student.getAge());
            stmt.setInt(4, student.getIdStudent());
            stmt.execute();
            endConv();           
            return count;
        } catch (Exception ex) {
            throw new Exception(ex);
        } 
    }
      @Override
    public int deleteStudent(Student student) throws Exception {
       try (Connection connection = dataSource.getConnection()) {
            String query = "delete from student "
                    + " where id=?";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, student.getIdStudent());
            stmt.execute();
            endConv();           
            return count;
        } catch (Exception ex) {
            throw new Exception(ex);
        } 
    }
    }

