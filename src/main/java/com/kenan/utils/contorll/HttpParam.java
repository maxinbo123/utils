package com.kenan.utils.contorll;

import com.kenan.utils.utils.HttpReqUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by maxb on 2020/2/21.
 */
@Controller
public class HttpParam {


    @RequestMapping(value = "add")
    @ResponseBody
    public String get(HttpServletRequest request, HttpServletResponse response){
       return HttpReqUtils.getRequestPrefix(request);
    }


}
