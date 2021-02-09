package com.app.student.bootstrap;

import com.app.student.domain.Student;
import com.app.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StudentDataBootstrap implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0) {
            loadStudents();
        }
    }

    private void loadStudents() {
        Student student1 = Student.builder().name("Chandler Bing").gender("M").standard("V").build();
        Student student2 = Student.builder().name("Phoebe Buffay").gender("F").standard("VI").build();

        studentRepository.save(student1);
        studentRepository.save(student2);
    }
}
