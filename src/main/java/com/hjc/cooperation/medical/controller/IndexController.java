package com.hjc.cooperation.medical.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.hjc.cooperation.medical.service.CooperateService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Controller
@RequestMapping("/cooperate")
public class IndexController {

    @Resource
    private CooperateService cooperateService;

    @RequestMapping("/index")
    public String index(){
        return "cooperate/upload";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request) throws Exception{
        //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();

            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    cooperateService.transferToDB(file);
                }

            }

        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "success");
        return jsonObject;
    }

    @RequestMapping("/list")
    public String list(){
        return "cooperate/list";
    }
}
