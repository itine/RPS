/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.StatelessDAOStudentLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import models.Student;

/**
 *
 * @author Сергей
 */
@RequestScoped
@Named
public class StudentsBean implements Serializable {

    @EJB
    private StatelessDAOStudentLocal studentDAOLocal;

    public List<Student> getAllStudents() {
        return this.studentDAOLocal.getStudents();
    }
}
