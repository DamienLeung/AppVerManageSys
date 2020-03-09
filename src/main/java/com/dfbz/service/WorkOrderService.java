package com.dfbz.service;

import com.dfbz.entity.WorkOrder;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface WorkOrderService extends CommonService<WorkOrder> {

    PageInfo<WorkOrder> selectByConditions(Map<String, Object> params, int pageNum, int pageSize);

    WorkOrder selectByCode(String code);
}
