package com.hjc.cooperation.medical.service.impl;

import com.hjc.common.util.UUIDUtil;
import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import com.hjc.cooperation.medical.service.CooperateService;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.beans.Transient;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class CooperateServiceImpl implements CooperateService {

    private static final Logger logger = Logger.getLogger(CooperateServiceImpl.class);

    @Resource
    private CooperativeBaseInfoMapper cooperativeBaseInfoMapper;

    @Override
    public void transferToDB(MultipartFile file) {
        Workbook workbook = null;
        try {
            workbook = new HSSFWorkbook(file.getInputStream());
        }catch (IOException e){
            logger.error("读取文件异常！",e);
            e.printStackTrace();
        }
        List<CooperativeBaseInfo> cooperativeBaseInfoList = this.readExcel(workbook);
        int result = batchBindingList(cooperativeBaseInfoList);
        logger.info("批量导入返回结果"+result);
    }

    public List<CooperativeBaseInfo> readExcel(Workbook workbook) {
        List<CooperativeBaseInfo> cooperativeBaseInfoList = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        int totalCells = 0;
        if (totalRows > 0 && sheet.getRow(0) != null)
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        Set<String> set = new HashSet<>();
        CooperativeBaseInfo cooperativeBaseInfo;
        for (int i = 1; i < totalRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null)
                continue;
            cooperativeBaseInfo = new CooperativeBaseInfo();
            //循环列
            for (int j = 0; j < totalCells; j++) {
                Cell cell = row.getCell(j);
                if (cell != null) {
                    cooperativeBaseInfo.setId(UUIDUtil.generateUUID());
                    switch (j) {
                        case 1:
                            cooperativeBaseInfo.setCooperativeno(cell.getStringCellValue());
                            break;
                        case 2://根据姓名去重复数据
                            String tempName = cell.getStringCellValue();
                            if (set.contains(tempName)) {
                                break;
                            }
                            cooperativeBaseInfo.setName(tempName);
                            set.add(tempName);
                            break;
                        case 3:
                            cooperativeBaseInfo.setGender(cell.getStringCellValue().equals("男") ? 0 : 1);
                            break;
                        case 4:
                            cooperativeBaseInfo.setAge(Integer.parseInt(cell.getStringCellValue().trim()));
                            break;
                        case 5:
                            cooperativeBaseInfo.setAddress(cell.getStringCellValue());
                            break;
                        case 6:
                            cooperativeBaseInfo.setVisitordate(cell.getStringCellValue());
                            break;
                        case 7:
                            cooperativeBaseInfo.setInvoiceno(cell.getStringCellValue());
                            break;
                        case 8:
                            cooperativeBaseInfo.setCompensateamount(new BigDecimal(cell.getStringCellValue()));
                            break;
                    }
                }
                cooperativeBaseInfoList.add(cooperativeBaseInfo);
            }
        }
        return cooperativeBaseInfoList;
    }

    @Transactional
    public int batchBindingList(List<CooperativeBaseInfo> cooperativeBaseInfos){
        return cooperativeBaseInfoMapper.batchBindCooperatvieBaseInfos(cooperativeBaseInfos);
    }
}

