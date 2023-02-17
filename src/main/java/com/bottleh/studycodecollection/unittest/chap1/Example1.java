package com.bottleh.studycodecollection.unittest.chap1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Example1 {

    private boolean wasLastStringLong;

    /**
     * 예제 1.1
     */
    public boolean isStringLong(String input) {
        if (input.length() > 5) { // 테스트가 다루는 영역
            return true; // 테스트가 다루지 않는 영역
        }
        return false; // 테스트가 다루는 영역
    }

    public boolean isStringLong2(String input) {
        return input.length() > 5;
    }

    /**
     * 예제 1.2
     */
    public boolean isStringLong3(String input) {
        boolean result = input.length() > 5;
        wasLastStringLong = result; // 첫 번째 결과
        return result; // 두 번째 결과
    }

    /**
     * 외부 라이브러리 경로 고려하지 않는 예제코드
     */
    public int parseExample(String input) {
        return Integer.parseInt(input);
    }
}
