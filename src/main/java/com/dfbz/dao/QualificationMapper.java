package com.dfbz.dao;

import com.dfbz.entity.Qualification;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface QualificationMapper extends Mapper<Qualification> {

    @SelectProvider(type = QualificationSqlProvider.class, method = "selectAllByCondition")
    List<Qualification> selectAllByCondition(Map<String, Object> parameters);
}
