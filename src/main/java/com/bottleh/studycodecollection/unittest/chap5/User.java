package com.bottleh.studycodecollection.unittest.chap5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@Getter
@Setter
@AllArgsConstructor
public class User {

    public String Name;

    public String normalizeName(String name) {
        String result = (StringUtils.hasText(name) ? name : "").trim();

        if (result.length() > 50) {
            return result.substring(0, 50);
        }
        return result;
    }
}
