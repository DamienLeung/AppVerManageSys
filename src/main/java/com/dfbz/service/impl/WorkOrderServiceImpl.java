package com.dfbz.service.impl;

import com.dfbz.dao.TransferMapper;
import com.dfbz.dao.WorkDetailMapper;
import com.dfbz.dao.WorkOrderMapper;
import com.dfbz.entity.WorkOrder;
import com.dfbz.service.WorkOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WorkOrderServiceImpl extends CommonServiceImpl<WorkOrder> implements WorkOrderService {

    @Autowired
    WorkOrderMapper workOrderMapper;

    @Autowired
    TransferMapper transferMapper;

    @Autowired
    WorkDetailMapper workDetailMapper;

    @Override
    public PageInfo<WorkOrder> selectByConditions(Map<String, Object> params, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<WorkOrder> workOrders = workOrderMapper.selectByConditions(params);
        return new PageInfo<>(workOrders);
    }

    @Override
    public WorkOrder selectByCode(String code) {
        WorkOrder workOrder = workOrderMapper.selectByCode(code);
        workOrder.setWorkDetails(workDetailMapper.selectByOrderedId(workOrder.getId()));
        workOrder.setTransfers(transferMapper.selectByOrderedId(workOrder.getId()));
        return workOrder;
    }

}
