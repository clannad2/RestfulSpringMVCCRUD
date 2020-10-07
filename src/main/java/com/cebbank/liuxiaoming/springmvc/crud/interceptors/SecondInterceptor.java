package com.cebbank.liuxiaoming.springmvc.crud.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondInterceptor implements HandlerInterceptor {

    /**
     * 该方法在目标方法之前调用，若返回true，则继续调用后续拦截器和目标方法，false则不会继续调用
     * 可考虑做权限，日志，事务等
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("second:preHandle ");
        return true;
    }


    /**
     * 目标方法之后，渲染视图之前
     * 可以对请求域中的属性或视图做出修改
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("second:postHandle ");
    }

    /**
     * 渲染视图之后调用，释放资源
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("second:afterCompletion ");
    }
}
