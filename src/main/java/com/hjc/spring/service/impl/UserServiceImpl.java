package com.hjc.spring.service.impl;

import com.hjc.spring.persistence.dao.UserMapper;
import com.hjc.spring.persistence.entity.User;
import com.hjc.spring.service.UserService;
import com.hjc.spring.service.UserServiceCopy;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserServiceCopy userServiceCopy;

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional
    public void test() throws Exception{
        User user = new User();
        user.setId(2);
        user.setAge(12);
        user.setUserName("函数");
        user.setPassword("124");
        insert(user);

        User userUp = new User();
        userUp.setId(1);
        userUp.setAge(12);
        update(userUp);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User get() {
        return userMapper.selectByPrimaryKey(1);
    }

    /**
     * 将insertRequires_New方法提取到另一个类即可。考虑因是
     * spring 管理bean生成的代理对象在具体调用该方法，so，可以再进切面方法。事务管理成功
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertRequest() {
        User user = new User();
        user.setId(4);
        user.setAge(14);
        user.setUserName("函数4");
        user.setPassword("124");
        userMapper.insert(user);
        /*try {
            ((UserService) AopContext.currentProxy()).insertRequires_New();
        } catch (Exception e) {
            System.out.println("error:算法错误");
            e.printStackTrace();
        }*/
        //同样会存在问题 userMapper无法依赖注入。且new新建的对象应该也同样会事务失效
//        new UserServiceImpl().insertRequires_New();
//        System.out.println("AopContext:"+AopContext.currentProxy());
        //直接获取aop代理对象，或者通过依赖注入ApplicationContext对象 用getBean获取该代理对象，再调用该方法，即可获取正确的事务。此种方法不适合于prototype Bean，因为每次getBean返回一个新的Bean
//        ((UserService)AopContext.currentProxy()).insertRequires_New();
        ((UserService)AopContext.currentProxy()).insertRequires_New();
        int a = 1 /0;
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int insertRequires_New() {
        User user = new User();
        user.setId(5);
        user.setAge(15);
        user.setUserName("函数new");
        user.setPassword("124");
        userMapper.insert(user);
        return 0;
    }
}
