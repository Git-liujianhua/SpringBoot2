package com.atguigu.admin.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Order(value = Ordered.HIGHEST_PRECEDENCE)  //优先级数字越小，优先级越高
//@Component
public class CustomerHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            response.sendError(000,"我喜欢的错误！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
