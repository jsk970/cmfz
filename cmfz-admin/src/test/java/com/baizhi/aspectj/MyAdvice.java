package com.baizhi.aspectj;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;


/**
 * @program: cmfz
 * @description: ${description}
 * @author: Elk love madness
 * @create: 2018-07-09 18:41
 */
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.baizhi.aspectj.GuruServiceImpl.add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object addLog(ProceedingJoinPoint pdjp) throws Throwable {
        Object obj = pdjp.proceed();
        Object[] args = pdjp.getArgs();
        MethodSignature methodSignature = (MethodSignature) pdjp.getSignature();
        System.out.println("方法名："+methodSignature.getName());


        SourceLocation sourceLocation = pdjp.getSourceLocation();
        Object target = pdjp.getTarget();//com.baizhi.aspectj.GuruServiceImpl@3e22f21d
        JoinPoint.StaticPart staticPart = pdjp.getStaticPart();//execution(Guru com.baizhi.aspectj.GuruService.addGuru(Guru))

        //System.out.println("操作资源："+target.toString());
        String substring = target.toString().substring(0,target.toString().lastIndexOf("ServiceImpl"));
        String s = substring.substring(substring.lastIndexOf(".")+1);
        System.out.println("操作对象："+s);


        for (Object arg : args) {

            System.out.println("方法参数："+arg);
        }
        System.out.println("======addlog==========");

        return obj;
    }


}
