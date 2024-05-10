package tn.esprit.examen.services;

import tn.esprit.examen.entities.Student;

import java.util.List;

public interface IStudentService {

    Student addStudent(Student e);
    public Boolean deleteStudent(String id);
    List<Student> getAllStudents();
    Student updateStudents(String id, Student e);

    Student searchStudentById(String id);

}
