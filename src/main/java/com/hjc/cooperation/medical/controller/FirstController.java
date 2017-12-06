package com.hjc.cooperation.medical.controller;

import com.alibaba.fastjson.JSONObject;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/first")
public class FirstController {

    @RequestMapping(value = "/test")//,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Object test(HttpServletResponse response) {
        // 加载配置文件activiti.cfg.xml，创建引擎，如果出现null，可能原因
        //1.加载路径不是根目录。
        //2.依赖包不完全
        // 获取配置文件后，引擎开始创建数据库。
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 获取流程储存服务组件
        RepositoryService rs = engine.getRepositoryService();
        // 获取运行时服务组件
        RuntimeService rse = engine.getRuntimeService();
        // 获取流程中的任务TASK组件
        TaskService ts = engine.getTaskService();
        // 部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署
        rs.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
        // 开启流程，myprocess是流程的ID
        rse.startProcessInstanceByKey("myProcess");
        // 查询历史表中的Task
        List<Task> task = ts.createTaskQuery().list();
        Task task1 = task.get(task.size() - 1);
        System.out.println("第一环节：" + task1);
        System.out.println("推动流程到下一环节：" + task1);
        ts.complete(task1.getId());
        task1 = ts.createTaskQuery().executionId(task1.getExecutionId()).singleResult();
        System.out.println("第二环节：" + task1);
        return "测试成功";
    }

    @Autowired
    RepositoryService repositoryService;
    @Autowired
    RuntimeService runtimeService;
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/test2")
    @ResponseBody
    public Object test2() {
        StringBuffer sb = new StringBuffer();
        // 部署流程，只要是符合BPMN2规范的XML文件，理论上都可以被ACTIVITI部署
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
        // 开启流程，myprocess是流程的ID
        ProcessInstance pi = runtimeService.startProcessInstanceByKey("myProcess");

//        ProcessDefinition pd= repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
//        ProcessInstance pi= runtimeService.startProcessInstanceById(pd.getId());
        sb.append("流程：" + pi.getId() + pi.getName());
        // 查询历史表中的Task
        List<Task> task = taskService.createTaskQuery().list();
        //pi.getId() : act_ru_execution表中id
        Task task1 = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();// taskDefinitionKey("usertask1").singleResult();//task.get(task.size()-1);
        sb.append("第一环节：" + task1 + "<br/>");
        sb.append("推动流程到下一环节：" + task1 + "<br/>");
        Map<String, Object> var = new HashMap<>();
        var.put("num", 101);
        taskService.complete(task1.getId(), var);
        task1 = taskService.createTaskQuery().executionId(task1.getExecutionId()).singleResult();
        sb.append("第二环节：" + task1 + "<br/>");

        taskService.complete(task1.getId());
        task1 = taskService.createTaskQuery().executionId(task1.getExecutionId()).singleResult();
        sb.append("完成：" + task1);
        sb.append("总共：" + task.size());
        return sb.toString();
    }

    @RequestMapping("/test1")
    @ResponseBody
    public String test() {
        //表：act_ru_execution id
        List<Task> task = taskService.createTaskQuery().list();
//        Task task1 = taskService.createTaskQuery().executionId("207").singleResult();
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        map.put("num", 90);
        for (Task temp : task) {
            String taskDefkey = temp.getTaskDefinitionKey();
            sb.append(temp.toString() + "\r\n");
            System.out.println(taskDefkey);
            if (taskDefkey.equals("usertask1")) {
                taskService.complete(temp.getId(), map);
            } else
                taskService.complete(temp.getId());
        }
        //表：act_ru_task id
//        taskService.complete(task1.getId());
//        System.out.println(task1);
        return task.toString();
    }

    @RequestMapping("/test3")
    @ResponseBody
    public Object test3() {
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("MyProcess.bpmn").deploy();
        ProcessDefinition pd= repositoryService.createProcessDefinitionQuery().deploymentId(deployment.getId()).singleResult();
        ProcessInstance pi= runtimeService.startProcessInstanceById(pd.getId());
        Task task1 = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();// taskDefinitionKey("usertask1").singleResult();//task.get(task.size()-1);
        Map<String, Object> map = new HashMap<>();
        map.put("num", 101);
        taskService.complete(task1.getId(),map);
        StringBuilder sb = new StringBuilder();
        sb.append("第一环节：" + task1 + "<br/>");
        sb.append("推动流程到下一环节：" + task1 + "<br/>");
//        taskService.complete(task1.getId(), var);
        Task task = taskService.createTaskQuery().executionId(task1.getExecutionId()).singleResult();
        sb.append(task.toString());
//        taskService.createTaskQuery().processDefinitionId(task1.getId()).singleResult();
        return sb.toString();
    }

    @RequestMapping("test4")
    @ResponseBody
    public Object test4(String taskId) {
        if (taskId == null || taskId.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Task task = taskService.createTaskQuery().processDefinitionId(taskId).singleResult();
//        System.out.println(task.toString());
        taskService.complete(taskId);
        return "success";
    }

    /**
     * @Author: Administrator
     * @Description: check is not null。
     * @param: t
     * @Date: 10:29 2017/12/6 0006
     * @return: T
     * @throws: NullPointException
     */
    public <T> T checkNotNull(T t) {
        if (t == null) {
          throw new NullPointerException();
        }
        return (T) new Object();
    }

    public void test12() {
        checkNotNull(new ArrayList<>());

    }
}
