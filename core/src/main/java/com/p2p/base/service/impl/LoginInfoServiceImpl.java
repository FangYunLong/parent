package com.p2p.base.service.impl;

import com.p2p.base.domain.Logininfo;
import com.p2p.base.mapper.LogininfoMapper;
import com.p2p.base.service.ILoginInfoService;
import com.p2p.base.util.MD5;
import com.p2p.base.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Fang on 2018/1/23.
 */
@Service
public class LoginInfoServiceImpl implements ILoginInfoService {

    @Autowired
    private LogininfoMapper logininfoMapper;

    @Override
    public void register(String username, String passwrd) {
        int count = logininfoMapper.getCountByUsername(username);
        if (count <= 0)
        {
            Logininfo logininfo = new Logininfo();
            logininfo.setUsername(username);
            logininfo.setPassword(MD5.encode(passwrd));
            logininfo.setState(Logininfo.USERTYPE_NORMAL);
            logininfoMapper.insert(logininfo);
        }
        else
        {
            throw new RuntimeException("用户名已经存在!");
        }
    }

    @Override
    public boolean checkUsername(String username) {
        return logininfoMapper.getCountByUsername(username) <= 0;
    }

    @Override
    public Logininfo login(String username,String password){
        Logininfo current = logininfoMapper.login(username,MD5.encode(password));
        if (current != null){
            UserContext.putLogininfo(current);
        }
        return current;
    }
}
