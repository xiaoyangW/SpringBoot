package com.ikuijia.datalog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author WXY
 * 获取添加@UserDataLog注解的方法并记录数据日志到mongoDB
 */
@Aspect
@Component
public class AnnotationLog {

    private MongoTemplate mongoTemplate;
    @Autowired
    public AnnotationLog(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Pointcut("@annotation(com.ikuijia.datalog.annotation.UserDataLog)")
    public void operationLog(){}

    @Before("operationLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        /*// 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString()+
                ",HTTP_METHOD : " + request.getMethod()+
                ",IP : " + request.getRemoteAddr()+
                ",CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()+
                ",ARGS : " + Arrays.toString(joinPoint.getArgs()));

        Object[] parem = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        Class<?> targetClass = joinPoint.getTarget().getClass();
*/
    }

    @AfterReturning(returning = "ret",pointcut = "operationLog()")
    public void doAfterReturning(JoinPoint joinPoint,Object ret) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Object[] params = joinPoint.getArgs();
        for (Object param:params) {
            mongoTemplate.save(param);
        }

    }

}
