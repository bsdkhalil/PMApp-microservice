package tn.esprit.examen.dto;

import lombok.Builder;
import tn.esprit.examen.entities.Student;

@Builder
public record StudentDto(String _id, String nom, ClasseDTO classe) {

    public static Student mapToStudent(StudentDto studentDto) {
        return new Student(studentDto._id(), studentDto.nom(), studentDto.classe().id());
    }
}
