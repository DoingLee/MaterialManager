package com.material.login.service;

import com.material.login.dao.LoginDao;
import com.material.login.dto.UserMsgDto;
import com.material.login.entity.LoginMsg;
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


    @Override
    public String checkPassword (long accountId, String password){
        LoginMsg loginMsg = loginDao.getUserLoginMsg(accountId);
        if (loginMsg!= null && password.equals(loginMsg.getPassword())){
            return loginMsg.getUserType();
        }else {
            return null;
        }
    }

    @Override
    public boolean updatePassword (long accountId, String oldPassword, String newPassword){
        int result = loginDao.updatePassword(accountId, oldPassword, newPassword);
        if (result == 1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public UserMsgDto getUserMsg(long accountId) {
        LoginMsg loginMsg = loginDao.getUserLoginMsg(accountId);
        if (loginMsg == null) {
            return null;
        }
        UserMsgDto userMsgDto = new UserMsgDto(accountId, loginMsg.getPassword(), loginMsg.getUserType());
        return userMsgDto;
    }
}
