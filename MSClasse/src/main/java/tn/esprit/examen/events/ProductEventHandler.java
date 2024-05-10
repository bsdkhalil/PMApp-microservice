package tn.esprit.examen.events;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.examen.dto.StudentDto;
import tn.esprit.examen.services.IStudentService;

@Service
@RequiredArgsConstructor
public class ProductEventHandler {
    private final IStudentService studentService;

    public void handleStudentCreatedEvent(StudentDto studentDto) {
        studentService.addStudent(StudentDto.mapToStudent(studentDto));
    }

    public void handleStudentUpdatedEvent(StudentDto studentDto) {
        studentService.updateStudent(studentDto._id(), StudentDto.mapToStudent(studentDto));
    }

    public void handleStudentDeletedEvent(String idProduct) {
        studentService.deleteStudent(idProduct);
    }
}
