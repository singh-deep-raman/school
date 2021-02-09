package com.app.teacher.bootstrap;

import com.app.teacher.domain.Teacher;
import com.app.teacher.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TeacherDataBootstrap implements CommandLineRunner {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void run(String... args) throws Exception {
        if (teacherRepository.count() == 0) {
            loadTeachers();
        }
    }

    private void loadTeachers() {
        Teacher teacher1 = Teacher.builder().name("Ross Geller").gender("M").build();
        Teacher teacher2 = Teacher.builder().name("Monica Geller").gender("F").build();

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);
    }
}
