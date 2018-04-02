package com.p2p.base.util;

import com.p2p.base.domain.Logininfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Fang on 2018/2/10.
 */
public class UserContext {

    public static final String LOGIN_SESSION = "logininfo";

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static void putLogininfo(Logininfo logininfo){
        getRequest().getSession().setAttribute(LOGIN_SESSION,logininfo);
    }

    public static Logininfo getCurrent(){
        return (Logininfo)getRequest().getSession().getAttribute(LOGIN_SESSION);
    }
}
