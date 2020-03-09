package com.dfbz.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class ExamineSqlProvider {

    public  String selectByConditions(Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("select ex.*, su.name user_name, su.office_id, so.`name` office_name " +
                "from examine ex, sys_user su, sys_office so " +
                "where ex.del_flag = 0 " +
                "and ex.examine_user_id = su.id " +
                "and su.office_id = so.id ");
        if(parameters.containsKey("officeId")&& !StringUtils.isEmpty(parameters.get("officeId"))){
            sql.append("and su.office_id = #{officeId} ");
        }
        if(parameters.containsKey("type")&& !StringUtils.isEmpty(parameters.get("type"))) {
            sql.append("and ex.type = #{type} ");
        }
        if(parameters.containsKey("userName")&& !StringUtils.isEmpty(parameters.get("userName"))) {
            sql.append("and su.name like concat ('%', #{userName}, '%') ");
        }
        return sql.toString();
    }
}
