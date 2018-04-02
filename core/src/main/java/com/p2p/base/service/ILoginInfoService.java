package com.p2p.base.service;

import com.p2p.base.domain.Logininfo;

/**
 * Created by Fang on 2018/1/23.
 */
public interface ILoginInfoService {

    void register(String username,String passwrd);

    boolean checkUsername(String username);

    Logininfo login(String username, String password);
}
