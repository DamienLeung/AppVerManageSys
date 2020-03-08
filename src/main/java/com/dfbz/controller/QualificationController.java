package com.dfbz.controller;

import com.dfbz.entity.Qualification;
import com.dfbz.entity.ResultMsg;
import com.dfbz.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manage/qualification")
public class QualificationController {

    @Autowired
    QualificationService service;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/qualification/index");
    }

    @RequestMapping("listPage/{pageNum}/{pageSize}")
    public ResultMsg listPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize, @RequestBody Map<String, Object> conditions) {
        System.out.println(1);
        System.out.println(conditions);
        PageInfo<Qualification> pageInfo = service.selectAllByCondition(conditions, pageNum, pageSize);

        return new ResultMsg(true, "查詢成功", pageInfo);
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate() {
        return new ModelAndView("/qualification/update");
    }

    @RequestMapping(value = "doUpdate", method = RequestMethod.POST)
    public ResultMsg doUpdate(@RequestBody Qualification qualification) {
        int i = service.updateByPrimaryKeySelective(qualification);
        ResultMsg msg = new ResultMsg();
        if (i > 0) {
            msg.setMsg("更新成功");
            msg.setSuccess(true);
        }
        return msg;
    }
}
