package com.example.demo.Student;

import Example.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.DeploymentException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService _studentService;
    private Example ex = new Example();

    @Autowired
    public StudentController(StudentService studentService) throws IOException {
        _studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() throws DeploymentException, IOException {
        ex.run();
        return _studentService.getStudents();


    }
}
