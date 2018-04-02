package com.p2p.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Fang on 2018/2/10.
 */
@Controller
public class PersonalController {

    private ;

    @RequestMapping("/personal")
    public String personal(Model model){
        return "personal";
    }

}
