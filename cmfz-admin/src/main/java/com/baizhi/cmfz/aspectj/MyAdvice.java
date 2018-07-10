package com.baizhi.cmfz.aspectj;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 19:44
 */

@Aspect
public class MyAdvice {


    @Autowired
    private LogService logService;
    //execution(* com.baizhi.cmfz.service.impl.*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..))
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.modify*(..)) || execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..))")
    public void pc(){}



    @Around("pc()")
    public Object addLog(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("------------------------------------");
        Object object = null;
        String result = "success";
        try {
            object = pjp.proceed();
        } catch (Throwable throwable) {
            result = "fail";
            throwable.printStackTrace();
        }
        Log log = new Log();

       // HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
       // HttpSession session = request.getSession();

        //Admin admin = (Admin) session.getAttribute("Admin");
        //log.setUser(admin.getName());
        log.setResult(result);

        log.setTime(new Date());
        Object target = pjp.getTarget();
        String s = target.toString().substring(0,target.toString().lastIndexOf("ServiceImpl"));
        String resource = s.substring(s.lastIndexOf(".")+1);
        //System.out.println("操作对象："+s);
        log.setResource(resource);


        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        System.out.println("方法名："+methodSignature.getName());
        String methodName =  methodSignature.getName();
        if(methodName.contains("add")){
            log.setAction("add");
        }else if(methodName.contains("modify")){
            log.setAction("modify");
        }else if(methodName.contains("remove")){
            log.setAction("remove");
        }

        Object[] args = pjp.getArgs();
        String message = "";
        for (Object arg : args) {
            message+=arg.toString();
        }
        log.setMessage(message);

        System.out.println("log:"+log);

        logService.addLog(log);

        return object;
    }

}
