package com.dfbz.controller;

import com.dfbz.entity.ResultMsg;
import com.dfbz.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/manage/examine")
public class ExamineController {

    @Autowired
    ExamineService service;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/examine/index");
    }

    @RequestMapping(value = "/listPage/{pageNum}/{pageSize}", method = RequestMethod.POST)
    public ResultMsg listPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,
                              @RequestBody Map<String, Object> parameters) {
        return new ResultMsg(true, "成功", service.selectByConditions(parameters, pageNum, pageSize));
    }

}
