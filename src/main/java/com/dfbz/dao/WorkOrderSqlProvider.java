package com.dfbz.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class WorkOrderSqlProvider {

    public String selectByConditions(Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("select wo.*, cu.`name` create_user_name, cu.phone create_user_phone, co.`name` create_user_office, " +
                "tu.`name` transport_user_name, tu.phone transport_user_phone, `to`.`name` transport_user_office, " +
                "ru.phone recipient_user_phone, ro.`name` recipient_user_office " +
                "from work_order wo " +
                "left join sys_user cu on wo.create_user_id = cu.id " +
                "left join sys_user tu on wo.transport_user_id = tu.id " +
                "left join sys_user ru on wo.recipient_user_id = ru.id " +
                "left join sys_office co on cu.office_id = co.id " +
                "left join sys_office `to` on tu.office_id = `to`.id " +
                "left join sys_office ro on ru.office_id = ro.id " +
                "where wo.del_flag = '0' ");

        if(parameters.containsKey("startDate")&& !StringUtils.isEmpty(parameters.get("startDate"))) {
            sql.append("and wo.create_date > #{startDate} ");
        }
        if (parameters.containsKey("endDate")&& !StringUtils.isEmpty(parameters.get("endDate"))) {
            sql.append("and wo.create_date < #{endDate} ");
        }
        if (parameters.containsKey("status")&& !StringUtils.isEmpty(parameters.get("status"))) {
            sql.append("and wo.status < #{status} ");
        }
        if (parameters.containsKey("officeId")&& !StringUtils.isEmpty(parameters.get("officeId"))) {
            sql.append("and (co.id = #{officeId} or `to`.id = #{officeId} or ro.id = #{officeId})");
        }

        return sql.toString();
    }
}
