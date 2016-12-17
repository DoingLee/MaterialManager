package com.material.login.service;

import com.material.login.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Service
public class LoginService implements ILoginService {

    @Autowired
    private LoginDao loginDao;

    public LoginService() {
    }

    public boolean checkPassword (long accountId, String password){
        String real = loginDao.getPassword(accountId);
        if (real!= null && password.equals(real)){
            return true;
        }else {
            return false;
        }
    }

    public boolean updatePassword (long accountId, String oldPassword, String newPassword){
        int result = loginDao.updatePassword(accountId, oldPassword, newPassword);
        if (result == 1){
            return true;
        }else{
            return false;
        }
    }
}
