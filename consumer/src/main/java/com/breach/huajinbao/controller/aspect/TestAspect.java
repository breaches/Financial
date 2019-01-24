package com.breach.huajinbao.controller.aspect;

import com.sun.media.jfxmedia.logging.Logger;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 08:38
 **/
@Aspect
//@Configuration
@Component
public class TestAspect {
/*
    *//**
     * create a aspect
     *//*
    @Pointcut("execution(public * com.breach.huajinbao.controller.product.*(..))")
    public void webLog() {

    }

    *//**
     * before 连接点之前执行
     *//*
    @Around("webLog()")
    public void doBefore(ProceedingJoinPoint joinpoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        System.out.println("URL: " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD: " + request.getMethod());
        System.out.println("IP: " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD: " + joinpoint.getSignature().getDeclaringTypeName());
        System.out.println("ARGS: " + Arrays.toString(joinpoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "webLog()")
    public void doAfterReturning(Object ret){
        System.out.println("RESPONSE: " + ret);
    }*/


}
