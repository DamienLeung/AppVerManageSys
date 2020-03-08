package com.dfbz.dao;

import org.springframework.util.StringUtils;

import java.util.Map;

public class QualificationSqlProvider {

    public String selectAllByCondition(Map<String, Object> parameters) {
        StringBuilder sql = new StringBuilder();
        sql.append("select qu.*, uu.`name` upload_user_name, uu.office_id office_id, su.`name` check_user_name from qualification qu " +
                "left join sys_user uu " +
                "on qu.upload_user_id = uu.id " +
                "left join sys_user su " +
                "on qu.check_user_id = su.id " +
                "where qu.del_flag = 0 ");
        if (parameters.containsKey("startDate") && !StringUtils.isEmpty(parameters.get("startDate"))) {
            sql.append("and qu.create_date > #{startDate} ");
        }

        if (parameters.containsKey("endDate") && !StringUtils.isEmpty(parameters.get("endDate"))) {
            sql.append("and qu.create_date < #{endDate} ");
        }

        if (parameters.containsKey("type") && !StringUtils.isEmpty(parameters.get("type"))) {
            sql.append("and qu.type = #{type} ");
        }

        if (parameters.containsKey("check") && !StringUtils.isEmpty(parameters.get("check"))) {
            sql.append("and qu.`check` < #{check} ");
        }
        System.out.println(sql);
        return sql.toString();
    }
}
