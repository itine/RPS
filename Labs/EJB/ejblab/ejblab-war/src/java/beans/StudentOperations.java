/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.StatefullStudentDAO;
import dao.StatefullStudentDAOLocal;
import models.Student;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
/**
 *
 * @author Сергей
 */
@SessionScoped
@Named
public class StudentOperations implements Serializable {

    @EJB
    private StatefullStudentDAOLocal studentsRemoteStatefull;

  
    @PostConstruct
    private void initBean() {
        count = 0;
        student = new Student();
    }
    private int count;
    private Student student;
    private int idStudent;
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public String add() {
        this.count = studentsRemoteStatefull.addStudent(student);
        return "/pages/allStudents.xhtml";
    }
    public String delete(int id) throws Exception {
        student.setIdStudent(id);
        this.studentsRemoteStatefull.deleteStudent(student);
        return "/pages/allStudents.xhtml";
    }
   public String toEdit(int id) throws Exception{
        student.setIdStudent(id);
        return "/pages/editStudent.xhtml";
    }

    public String editStudent() throws Exception {   
        this.studentsRemoteStatefull.editStudent(student);
        return "/pages/allStudents.xhtml";
    }
}