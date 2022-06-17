package com.example.demo.aspect;

import com.example.demo.annotation.AnnotationForUs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/*1.创建一个类，使用@Aspect标注
2.@Aspect标注的类中，通过@Pointcut定义切入点
3.@Aspect标注的类中，通过AspectJ提供的一些通知相关的注解定义通知
        4.使用AspectJProxyFactory结合@Ascpect标注的类，来生成代理对象*/
/*https://blog.csdn.net/qq_41980255/article/details/116562923*/
@Aspect
@Component
public class AopForUs {
    //拦截这个注解
   // @Pointcut("within(com.example.demo.annotation..*)")
   @Pointcut("@annotation(com.example.demo.annotation.AnnotationForUs)")
    public void aopAndAnnotation() {
        System.out.println("################################aopAndAnnotation");
    }
    @Before("aopAndAnnotation()")
    public void loginBefore(JoinPoint joinPoint) {
        System.out.println("################################loginBefore");
        //先获取方法的签名，joinPoint中有相应的签名信息 首
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 通过方法的签名可以获取方法本身
        Method method = signature.getMethod();
        //判断是否存在自定义注解AnnotationForUs
        boolean isExsit = method.isAnnotationPresent(AnnotationForUs.class);
        if (!isExsit) return;
        AnnotationForUs annotation = method.getAnnotation(AnnotationForUs.class);
        //拿到注解的值，输出控制台
        String name = annotation.name();
        System.out.println("AnnotationForUs: "+name);
        //todo 做特定操作
    }



}
