package com.hjc.bus.service;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author : Hjc
 * @date : 2018/7/27 0027 17:00
 * @description : 公交实时查询service
 */
public interface BusCurrentInfoService {
    /**
     * 获取公交实时信息
     * @param busNo
     * @param lineType
     * @return
     */
    String getBusCurrentInfo(String busNo, String lineType) throws IOException;

    /**
     * 获取该路线所有公交站点
     * @param busNo
     * @param lineType
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    String allBusStand(String busNo,String lineType) throws URISyntaxException, IOException;
}
