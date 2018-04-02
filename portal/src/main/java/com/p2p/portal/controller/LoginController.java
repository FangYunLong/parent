package com.p2p.portal.controller;

import com.p2p.base.domain.Logininfo;
import com.p2p.base.service.ILoginInfoService;
import com.p2p.base.util.ResultJSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Fang on 2018/2/9.
 */
@Controller
public class LoginController {

    @Autowired
    private ILoginInfoService loginInfoService;

    @RequestMapping("/login")
    @ResponseBody
    public ResultJSON login(String username,String password){
        ResultJSON json = new ResultJSON();
        Logininfo login = loginInfoService.login(username,password);
        if (login != null){
            json.setSuccess(true);
        }
        else {
            json.setMsg("用户名或密码错误！");
        }
        return json;
    }
}
