package com.bottleh.studycodecollection.unittest.chap5;

public class UserController {

    public void renameUser(String userId, String newName) {
        User user = new User(userId);

        String normalizeName = user.normalizeName(newName);
        user.setName(normalizeName);
    }
}