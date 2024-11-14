package com.study.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.tdd.Dto.ReqAddStudent;
import com.study.tdd.Dto.RespSaveDto;
import com.study.tdd.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
        import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StudentService studentService;

    @Test
    void addStudent() throws Exception {
        ReqAddStudent reqAddStudent = new ReqAddStudent();
        reqAddStudent.setName("김정현");
        reqAddStudent.setAge(20);

        ObjectMapper mapper = new ObjectMapper();
        String reqJsonBody = mapper.writeValueAsString(reqAddStudent);
        given(studentService.saveStudent(reqAddStudent))
                .willReturn(new RespSaveDto(true, "학생 등록 완료"));
        mvc.perform(post("/student")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(reqJsonBody)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isSaveSuccess").value(true))
                .andExpect(jsonPath("$.message").value("학생 추가 완료"))
                .andDo(print());
    }

}
