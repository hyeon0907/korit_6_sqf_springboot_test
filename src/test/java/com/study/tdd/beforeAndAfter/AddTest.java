package com.study.tdd.beforeAndAfter;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@Slf4j
public class AddTest {

    public Boolean add(){
        return true;
    }
}
