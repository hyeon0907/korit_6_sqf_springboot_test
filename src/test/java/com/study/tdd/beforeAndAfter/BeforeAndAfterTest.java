package com.study.tdd.beforeAndAfter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@Slf4j
public class BeforeAndAfterTest {

    @Mock // 실체 객체를 생성하는 것이 아니라 가짜 객체를 생성하는 행위
    private AddTest addTest;

    /**
     * Each: 메서드가 실행될 때마다 무조건 한번
     * All: 모든 테스트가 실행될 때 한번
     * @BeforeEach
     * @AfterEAch
     * @BeforeAll
     * @AfterAll
     */
    @BeforeEach
    void setAddTest(){
        log.info("Mock 생성");
        MockitoAnnotations.openMocks(this);
    }

    @BeforeEach
    void beforeEachTest() {
        log.info("BeforeEach 실행");
    }
    @AfterEach
    void afterEachTest() {
        log.info("AfterEach 실행");
    }

    @BeforeAll
    static void beforeAllTest() {
        log.info("BeforeAll 실행");
    }
    @AfterAll
    static void afterAllTest() {
        log.info("AfterAll 실행");
    }

    @Test
    void test1(){
        given(addTest.add()).willReturn(true);

        Boolean result = addTest.add();

        log.info("test 메서드 실행");
        assertEquals(true, result);
    }

    @Test
    void test2() {
        log.info("test2 메소드 실행 !!!!");
    }
}
