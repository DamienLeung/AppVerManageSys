package com.dfbz.dao;

import com.dfbz.entity.WorkDetail;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WorkDetailMapper extends Mapper<WorkDetail> {

    @Select("select dt.*, wa.`name` waste_name, wt.`code` waste_type_code, wa.`code` waste_code " +
            "from detail dt, waste_type wt, waste wa " +
            "where dt.work_order_id = #{id} " +
            "and dt.del_flag = '0' " +
            "and dt.waste_type_id = wt.id " +
            "and dt.waste_id = wa.id")
    List<WorkDetail> selectByOrderedId(Long id);
}
