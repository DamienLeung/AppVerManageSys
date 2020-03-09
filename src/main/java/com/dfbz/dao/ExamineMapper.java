package com.dfbz.dao;

import com.dfbz.entity.Examine;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface ExamineMapper extends Mapper<Examine> {

    @SelectProvider(type = ExamineSqlProvider.class, method = "selectByConditions")
    List<Examine> selectByConditions(Map<String, Object> parameters);

}
