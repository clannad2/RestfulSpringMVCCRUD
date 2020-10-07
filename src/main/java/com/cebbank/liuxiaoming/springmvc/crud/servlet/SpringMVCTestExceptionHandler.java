package com.cebbank.liuxiaoming.springmvc.crud.servlet;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
//@ControllerAdvice
public class SpringMVCTestExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
	public ModelAndView handleArithmeticException2(Exception ex){
		System.out.println("[出异常了]: " + ex);
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("exception", ex);
		return mv;
	}
}
