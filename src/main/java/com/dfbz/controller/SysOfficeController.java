package com.dfbz.controller;

import com.dfbz.entity.ResultMsg;
import com.dfbz.service.SysOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage/office")
public class SysOfficeController {

    @Autowired
    SysOfficeService service;

    @RequestMapping("listAll")
    public ResultMsg listAll() {
        return new ResultMsg(true, "成功", service.selectAll());
    }

}
