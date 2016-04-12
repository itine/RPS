/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Local;
import models.Student;

/**
 *
 * @author Сергей
 */
@Local
public interface StatefullStudentDAOLocal {
    public int addStudent(Student student);
    public int editStudent(Student student) throws Exception;
    public int deleteStudent(Student student) throws Exception;
}
