package com.dfbz.dao;

import com.dfbz.entity.WorkOrder;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkOrderMapper extends Mapper<WorkOrder> {

    @SelectProvider(type = WorkOrderSqlProvider.class, method = "selectByConditions")
    List<WorkOrder> selectByConditions(Map<String, Object> parameters);

    @Select("select wo.*, cu.`name` create_user_name, cu.phone create_user_phone, co.`name` create_user_office, " +
            "tu.`name` transport_user_name, tu.phone transport_user_phone, `to`.`name` transport_user_office, " +
            "ru.`name` recipient_user_name, ru.phone recipiet_user_phone, ro.NAME recipient_user_office " +
            "from work_order wo " +
            "left join sys_user cu on wo.create_user_id = cu.id " +
            "left join sys_user tu on wo.transport_user_id = tu.id " +
            "left join sys_user ru on wo.recipient_user_id = ru.id " +
            "left join sys_office co on cu.office_id = co.id " +
            "left join sys_office `to` on tu.office_id = `to`.id " +
            "left join sys_office ro on ru.office_id = ro.id " +
            "where wo.del_flag = '0' and wo.code = #{code}")
    WorkOrder selectByCode(String code);
}
