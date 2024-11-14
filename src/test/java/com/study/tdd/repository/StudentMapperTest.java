package com.study.tdd.repository;

import com.study.tdd.entity.Student;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
// 실제 데이터 베이스에 영향을 주지 않겠다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/student_schema.sql")
@Transactional
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void save() {
        Student student = new Student(1L, "김정현", 20);
        int result = studentMapper.save(student);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void findById() {
        Student student = new Student(1L, "김정현", 20);
        int result = studentMapper.save(student);
        assertThat(result).isEqualTo(1);

        Student foundStudent = studentMapper.findById(1L);
        assertThat(foundStudent).isEqualTo(student);
//        assertThat(foundStudent.getId()).isEqualTo(1L);
//        assertThat(foundStudent.getName()).isEqualTo("김정현");
//        assertThat(foundStudent.getAge()).isEqualTo(20);
    }
}