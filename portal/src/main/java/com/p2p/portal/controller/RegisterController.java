package com.p2p.portal.controller;

import com.p2p.base.service.ILoginInfoService;
import com.p2p.base.util.ResultJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fang on 2018/1/23.
 */
@Controller
public class RegisterController {

    @Autowired
    ILoginInfoService loginInfoService;

    @RequestMapping("/register")
    @ResponseBody
    public ResultJSON register(String username,String password){
        ResultJSON json = new ResultJSON();
        try {
            loginInfoService.register(username,password);
            json.setSuccess(true);
        }catch (RuntimeException e){
            json.setMsg(e.getMessage());
        }
        return json;
    }

    @RequestMapping("/checkUsername")
    @ResponseBody
    public ResultJSON checkUsername(String username){
        ResultJSON json = new ResultJSON();
        json.setSuccess(loginInfoService.checkUsername(username));
        return json;
    }
}
