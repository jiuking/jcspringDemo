package com.hjc.cooperation.medical.service;

import com.hjc.common.util.page.PageEntity;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public interface CooperateService<T> {
    void transferToDB(MultipartFile file);

    CooperativeBaseInfo getCooperativeBaseInfo(String id);

    List<CooperativeBaseInfo> list(Map<String,String> map,PageEntity pageEntity);
}
