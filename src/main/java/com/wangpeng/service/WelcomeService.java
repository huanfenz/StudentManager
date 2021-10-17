package com.wangpeng.service;

import java.util.Map;

public interface WelcomeService {
    public Map<String, Integer> getAllCount();

    Map<String, Integer> getAllCountByStudent(Integer sid);

    Map<String, Integer> getAllCountByTeacher(Integer tid);
}
