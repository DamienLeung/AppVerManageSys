package com.dfbz.controller;

import com.dfbz.entity.AppVersion;
import com.dfbz.entity.ResultMsg;
import com.dfbz.service.AppVersionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@RestController
@RequestMapping("/manage/app")
public class AppVersionController {

    @Autowired
    AppVersionService service;

    @RequestMapping("index")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @RequestMapping("list")
    public ResultMsg list() {
        return new ResultMsg(true, "成功", service.selectAll());
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ResultMsg insert(@RequestBody AppVersion version) {

        version.setCreateDate(new Date());
        version.setUpdateDate(new Date());
        version.setDelFlag("0");
        version.setPublisher("sys");

        ResultMsg msg = new ResultMsg();
        int i = service.insert(version);
        if (i > 0) {
            msg.setMsg("插入成功");
            msg.setSuccess(true);
        } else
            msg.setMsg("插入失敗！");

        return msg;
    }

    @RequestMapping("listPage/{pageNum}/{pageSize}")
    public ResultMsg listPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        AppVersion version = new AppVersion();
        version.setDelFlag("0");
        PageInfo<AppVersion> pageInfo = service.selectPage(version, pageNum, pageSize);
        return new ResultMsg(true, "成功", pageInfo);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public ResultMsg delete(@RequestBody AppVersion version) {
        int i = service.updateByPrimaryKey(version);
        ResultMsg msg = new ResultMsg();
        if (i > 0) {
            msg.setMsg("刪除成功");
            msg.setSuccess(true);
        } else
            msg.setMsg("刪除失敗！");

        return msg;
    }

    @RequestMapping("toUpdate")
    public ModelAndView toUpdate() {
        return new ModelAndView("/update");
    }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResultMsg update(@RequestBody AppVersion version) {
        System.out.println(1);
        int i = service.updateByPrimaryKey(version);
        ResultMsg msg = new ResultMsg();
        if (i > 0) {
            msg.setMsg("更新成功");
            msg.setSuccess(true);
        } else
            msg.setMsg("更新失敗！");
        System.out.println(msg);
        return msg;
    }
}
