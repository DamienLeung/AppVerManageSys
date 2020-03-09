package com.dfbz.dao;

import com.dfbz.entity.Transfer;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TransferMapper extends Mapper<Transfer> {

    @Select("select ts.*, su.`name` user_name, su.phone user_phone " +
            "from transfer ts, sys_user su " +
            "where ts.work_order_id = #{id} " +
            "and ts.del_flag = '0' " +
            "and ts.oprate_user_id = su.id " +
            "order by ts.create_date desc")
    List<Transfer> selectByOrderedId(Long id);
}
