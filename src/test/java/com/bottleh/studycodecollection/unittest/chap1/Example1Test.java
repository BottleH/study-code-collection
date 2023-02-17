package com.bottleh.studycodecollection.unittest.chap1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Example1Test {

    @Autowired
    private Example1 example1;

    @Test
    void isStringLongTest() {
        boolean result = example1.isStringLong("abc");
        assertFalse(result);
    }

    @Test
    @DisplayName("예제 1.3 검증이 없는 테스트는 언제나 통과한다.")
    void isStringLongTest2() {
        boolean result1 = example1.isStringLong("abc");
        boolean result2 = example1.isStringLong("abcdef");
    }

    @Test
    void parseExampleTest() {
        int result = example1.parseExample("5");
        assertEquals(5, result);
    }
}