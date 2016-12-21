package com.material.qr_code.service;

import java.util.List;

/**
 * Created by Doing on 2016/12/20 0020.
 */
public interface IQRCodeService {

    int addMaterialName(String materialName);

    int addBlenderName(String blenderName);

    List<String> getAllMaterialName();

    List<String> getAllBlenderName();
}
