package com.material.qr_code.service;

import com.material.qr_code.dao.QRCodeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Doing on 2016/12/17 0017.
 */
@Service
public class QRCodeService implements IQRCodeService {

    @Autowired
    private QRCodeDao qrCodeDao;

    public QRCodeService() {
    }

    public int addMaterialName(String materialName){
        return qrCodeDao.addMaterialName(materialName);
    }

    public int addBlenderName(String blenderName) {
        return qrCodeDao.addBlenderName(blenderName);
    }

    @Override
    public List<String> getAllMaterialName() {
        return qrCodeDao.getAllMaterialName();
    }

    @Override
    public List<String> getAllBlenderName() {
        return qrCodeDao.getAllBlenderName();
    }
}
