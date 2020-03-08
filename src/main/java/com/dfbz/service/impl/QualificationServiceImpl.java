package com.dfbz.service.impl;

import com.dfbz.dao.QualificationMapper;
import com.dfbz.entity.Qualification;
import com.dfbz.service.QualificationService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualificationServiceImpl extends CommonServiceImpl<Qualification> implements QualificationService {

    @Autowired
    private QualificationMapper dao;

    @Override
    public PageInfo<Qualification> selectAllByCondition(Map<String, Object> parameters, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Qualification> qualifications = dao.selectAllByCondition(parameters);
        return new PageInfo<Qualification>(qualifications);
    }
}
