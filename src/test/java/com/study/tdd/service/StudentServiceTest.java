package com.study.tdd.service;

import com.study.tdd.Dto.ReqAddStudent;
import com.study.tdd.Dto.RespSaveDto;
import com.study.tdd.entity.Student;
import com.study.tdd.repository.StudentMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentService studentService;

    @Test
    void saveStudent2() {
        given(studentMapper.save(any(Student.class))).willReturn(1);

        ReqAddStudent dto = new ReqAddStudent();
        dto.setName("김정현");
        dto.setAge(20);

        RespSaveDto respSaveDto = studentService.saveStudent(dto);
        assertEquals(new RespSaveDto(true, "학생 등록 완료"), respSaveDto);
    }

    @Test
    void saveStudent() {
        ReqAddStudent dto = new ReqAddStudent();
        dto.setName("김정현");
        dto.setAge(20);

        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        given(studentMapper.save(student)).willReturn(1);
        verify(studentMapper).save(student);

        Optional<Student> optional = Optional.of(student);
        RespSaveDto respSaveDto = null;
        if(optional.isEmpty()){
            respSaveDto = new RespSaveDto(false, "학생 등록 실패");
        }
        else {
            respSaveDto = new RespSaveDto(true, "학생 등록 완료");
        }

        assertEquals(new RespSaveDto(true, "학생 등록 완료"), respSaveDto);
    }
}