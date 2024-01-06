package com.bottleh.studycodecollection.object.chap12;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class Lecture {

    /**
     * 이수 여부를 판단할 기준 점수
     */
    private final int pass;

    /**
     * 과목명
     */
    private final String title;

    /**
     * 학생들의 성적
     */
    private final List<Integer> scores;

    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream().filter(score -> score >= pass).count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }

    public String stats() {
        return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());
    }

    public String getEvaluationMethod() {
        return "Pass or Fail";
    }
}
