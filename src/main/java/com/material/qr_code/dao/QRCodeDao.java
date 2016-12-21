package com.material.qr_code.dao;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
public interface QRCodeDao {

    int addMaterialName(String materialName);

    int addBlenderName(String blenderName);

    List<String> getAllMaterialName();

    List<String> getAllBlenderName();

}
