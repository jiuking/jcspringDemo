package com.hjc.cooperation.medical.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public interface CooperateService<T> {
    void transferToDB(MultipartFile file);
}