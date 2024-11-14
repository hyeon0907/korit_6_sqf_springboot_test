package com.study.tdd.controller;

import com.study.tdd.Dto.ReqAddStudent;
import com.study.tdd.Dto.RespSaveDto;
import com.study.tdd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<RespSaveDto> addStudent(@RequestBody ReqAddStudent dto) {
        return ResponseEntity.ok().body(studentService.saveStudent(dto));
    }
}
