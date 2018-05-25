package com.springbootlog;

import com.springbootlog.controller.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author WXY
 */
@Aspect
@Order(5)
@Component
public class AnnotationLog {

    private Logger logger = LogManager.getLogger(Controller.class.getName());

    @Pointcut("execution(* *(..))&&@annotation(com.springbootlog.UserDataLog)")
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

        String methodName = joinPoint.getSignature().getName();
        Class<?> targetClass = joinPoint.getTarget().getClass();
        Method method = null;
        for (Method mt : targetClass.getMethods()) {
            if (methodName.equals(mt.getName())) {
                method = mt;
                break;
            }
        }
        assert method != null;
        UserDataLog datalog = method.getAnnotation(UserDataLog.class);
        Constant[] constant=datalog.constant();
        logger.info("URL : " + request.getRequestURL().toString()+
                    " ,OPERATION:"+datalog.operation()+
                    " ,MSG:"+datalog.msg()+
                    " ,RETURN_DATA:"+ret.toString()+
                    " ,ARGS : " + Arrays.toString(joinPoint.getArgs())+
                    " ,Constant"+ Arrays.toString(constant));

    }

}
