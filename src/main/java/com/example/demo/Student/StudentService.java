package com.example.demo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents(){
        return List.of(new Student(
                "Tarik",
                "Arnaut",
                "BB200024"
        ));
    }

}
