package tn.esprit.examen.services;

import tn.esprit.examen.entities.Student;

public interface IStudentService {

    Student addStudent(Student e);
    public Boolean deleteStudent(String id);
    Student updateStudent(String id, Student e);


}
