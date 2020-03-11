package com.dfbz.controller;

import com.dfbz.entity.ResultMsg;
import com.dfbz.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/manage/work/")
public class WorkOrderController {

    @Autowired
    WorkOrderService service;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/work/admin/work");
    }

    @RequestMapping("listPage/{pageNum}/{pageSize}")
    public ResultMsg listPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                              @RequestBody Map<String, Object> parameters) {
        return new ResultMsg(true, "成功", service.selectByConditions(parameters, pageNum, pageSize));
    }

    @RequestMapping("toWorkDetail")
    public ModelAndView toWorkDetail() {
        System.out.println(1);
        return new ModelAndView("/work/work-detail");
    }

    @RequestMapping("getDetail/{code}")
    public ResultMsg getDetail(@PathVariable("code") String code) {
        return new ResultMsg(true, "成功", service.selectByCode(code));
    }
}
