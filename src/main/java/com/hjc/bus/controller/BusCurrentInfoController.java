package com.hjc.bus.controller;

import com.hjc.bus.service.BusCurrentInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : Administrator
 * @date : 2018/7/27 0027 17:25
 * @description : 公交车实时信息查询Controller
 */
@Controller
@RequestMapping("bus/current/info")
public class BusCurrentInfoController {

    private static final Logger logger = LoggerFactory.getLogger(BusCurrentInfoController.class);

    @Autowired
    private BusCurrentInfoService busCurrentInfoService;

    @RequestMapping("/stand")
    public String index() {
        return "/bus/index";
    }

    @RequestMapping("/concrete")
    @ResponseBody
    public Object concrete(String busNo,String lineType) {
        String result;
        try {
            result = busCurrentInfoService.getBusCurrentInfo(busNo, lineType);
            result += "=========" + busCurrentInfoService.allBusStand(busNo, lineType);
        } catch (Exception e) {
            logger.error("请求数据发生异常：{}", e.getMessage());
            return "请求失败！";
        }
        return result;
    }
}
