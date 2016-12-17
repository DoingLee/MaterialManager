package com.material.login.service;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public interface ILoginService {

    boolean checkPassword (long accountId, String password);

    boolean updatePassword (long accountId, String oldPassword, String newPassword);
}
