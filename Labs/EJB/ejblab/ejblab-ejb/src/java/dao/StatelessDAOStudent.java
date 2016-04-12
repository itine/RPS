
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import models.Student;

/**
 *
 * @author Сергей
 */
@Stateless
public class StatelessDAOStudent implements StatelessDAOStudentLocal {
     
    @Resource(lookup = "jdbc/studentJ")
    
    private DataSource dataSource;

    @Override
    public List<Student> getStudents() {
        try (Connection connection = dataSource.getConnection()) {
            String query = "SELECT * FROM student";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet res = stmt.executeQuery();
            List<Student> students = new ArrayList<>();
            while (res.next()) {
                Student student = new Student();
                student.setIdStudent(res.getInt(1));
                student.setName(res.getString(2));
                student.setSurName(res.getString(3));
                student.setAge(res.getInt(4));
                students.add(student);
            }
            return students;
        } catch (Exception ex) {
            throw new RuntimeException("An error has occured in listStudents methos", ex);
        }

    }
}
