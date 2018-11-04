package com.example.baseframe.myspringboot.exception;

import com.example.baseframe.myspringboot.domain.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author 01378803
 * @date 2018/11/2 17:03
 * Description  :
 */
@Controller
@RequestMapping({"${server.error.path:${error.path:/error}}"})
public class MyBasicErrorController extends AbstractErrorController {
    private final static Logger logger = LoggerFactory.getLogger(MyBasicErrorController.class);
    private final ErrorProperties errorProperties;
//    @Autowired
//    private ApplicationContext applicationContext;

    @Autowired
    public MyBasicErrorController(ErrorAttributes errorAttributes,ServerProperties serverProperties) {
        super(errorAttributes);
        this.errorProperties=serverProperties.getError();
    }

    @Override
    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

    @RequestMapping(produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request,
                                  HttpServletResponse response) {
        ModelAndView modelAndView=new ModelAndView("error");
        Map<String, Object> errorMap = getErrorAttributes(
                request, isIncludeStackTrace(request, MediaType.ALL));
        if(errorMap != null){
            modelAndView.addObject("msg",errorMap.get("error"));
            modelAndView.addObject("statusCode",errorMap.get("status"));
            logHandler(errorMap);
        }
        return modelAndView;
    }

    @RequestMapping
    @ResponseBody
    public ResultData error(HttpServletRequest request) {
        Map<String, Object> body = getErrorAttributes(request,
                isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
        logHandler(body);
        ResultData resultData = new ResultData();
        Integer status = (Integer)body.get("status");
        resultData.setCode(status);
        resultData.setMsg("testing SUCCESS");
        return resultData;
    }

    private void logHandler(Map<String, Object> errorMap) {
        logger.error("url:{},status{},time:{},errorMsg:{}",errorMap.get("path"),errorMap.get("status"),errorMap.get("timestamp"),errorMap.get("message"));
    }

    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        ErrorProperties.IncludeStacktrace include = this.getErrorProperties().getIncludeStacktrace();
        return include == ErrorProperties.IncludeStacktrace.ALWAYS?true:(include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM?this.getTraceParameter(request):false);
    }

    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }
}
