package com.hjc.cooperation.medical.persistence.dao;


import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;

import java.util.List;
import java.util.Map;

public interface CooperativeBaseInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CooperativeBaseInfo record);

    int insertSelective(CooperativeBaseInfo record);

    CooperativeBaseInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CooperativeBaseInfo record);

    int updateByPrimaryKeyWithBLOBs(CooperativeBaseInfo record);

    int updateByPrimaryKey(CooperativeBaseInfo record);

    int batchBindCooperativeBaseInfos(List<CooperativeBaseInfo> cooperativeBaseInfos);

    List<CooperativeBaseInfo> listCooperativeBaseInfo(Map<String,String> map);

    void updateBatchAge(List<CooperativeBaseInfo> list);
}