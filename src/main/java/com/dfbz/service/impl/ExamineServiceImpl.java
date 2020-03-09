package com.dfbz.service.impl;

import com.dfbz.dao.ExamineMapper;
import com.dfbz.entity.Examine;
import com.dfbz.service.ExamineService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ExamineServiceImpl extends CommonServiceImpl<Examine> implements ExamineService {

    @Autowired
    ExamineMapper mapper;

    @Override
    public PageInfo<Examine> selectByConditions(Map<String, Object> parameters, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Examine> examines = mapper.selectByConditions(parameters);
        return new PageInfo<>(examines);
    }
}
