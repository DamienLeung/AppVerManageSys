package com.dfbz.service;

import com.dfbz.entity.Examine;
import com.dfbz.service.impl.CommonServiceImpl;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface ExamineService extends CommonService<Examine> {

    PageInfo<Examine> selectByConditions(Map<String, Object> parameters, int pageNum, int pageSize);
}
