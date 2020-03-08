package com.dfbz.service;

import com.dfbz.entity.Qualification;
import com.dfbz.service.impl.CommonServiceImpl;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface QualificationService extends CommonService<Qualification> {

    PageInfo<Qualification> selectAllByCondition(Map<String, Object> parameters, int pageNum, int pageSize);
}
