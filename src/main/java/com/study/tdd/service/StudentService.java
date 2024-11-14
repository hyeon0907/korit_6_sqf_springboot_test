package com.study.tdd.service;

import com.study.tdd.Dto.ReqAddStudent;
import com.study.tdd.Dto.RespSaveDto;
import com.study.tdd.entity.Student;
import com.study.tdd.repository.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public RespSaveDto saveStudent(ReqAddStudent dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());

        if(studentMapper.save(student) < 0){
            return new RespSaveDto(false, "학생 등록 실패");
        }
        return new RespSaveDto(true, "학생 등록 완료");
    }
}
