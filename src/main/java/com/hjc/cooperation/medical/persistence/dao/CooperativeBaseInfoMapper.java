package com.hjc.cooperation.medical.persistence.dao;


import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;

import java.util.List;

public interface CooperativeBaseInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(CooperativeBaseInfo record);

    int insertSelective(CooperativeBaseInfo record);

    CooperativeBaseInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CooperativeBaseInfo record);

    int updateByPrimaryKeyWithBLOBs(CooperativeBaseInfo record);

    int updateByPrimaryKey(CooperativeBaseInfo record);

    int batchBindCooperatvieBaseInfos(List<CooperativeBaseInfo> cooperativeBaseInfos);
}