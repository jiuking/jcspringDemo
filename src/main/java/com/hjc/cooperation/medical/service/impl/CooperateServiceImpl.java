package com.hjc.cooperation.medical.service.impl;

import com.hjc.common.util.UUIDUtil;
import com.hjc.common.util.excel.ReadExcelUtil;
import com.hjc.common.util.excel.ValueFormatException;
import com.hjc.cooperation.medical.persistence.dao.CooperativeBaseInfoMapper;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import com.hjc.cooperation.medical.service.CooperateService;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Service
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
//        List<CooperativeBaseInfo> cooperativeBaseInfoList = this.readExcel(workbook);
        List<CooperativeBaseInfo> cooperativeBaseInfoList = new ArrayList<>();
        try{
            cooperativeBaseInfoList = this.readExcel(file.getInputStream());
        }catch (IOException ioe){
            logger.error("获取文件流错误",ioe);
            ioe.printStackTrace();
        } catch (IllegalAccessException e) {
            logger.error("非法使用错误",e);
            e.printStackTrace();
        } catch (ValueFormatException e) {
            logger.error("数据转换错误",e);
            e.printStackTrace();
        } catch (InstantiationException e) {
            logger.error("实例化错误",e);
            e.printStackTrace();
        }
        if (!cooperativeBaseInfoList.isEmpty()) {
            int result = batchBindingList(cooperativeBaseInfoList);
            logger.info("批量导入返回结果"+result);
        }else
            logger.info("读取Excel文件数据为空，未插入数据库");

    }

    @Override
    public CooperativeBaseInfo getCooperativeBaseInfo(String id) {
        return cooperativeBaseInfoMapper.selectByPrimaryKey(id);
    }

    public List<CooperativeBaseInfo> readExcel(InputStream inputStream) throws ValueFormatException, InstantiationException, IllegalAccessException, IOException {
        List<CooperativeBaseInfo> lists = (List<CooperativeBaseInfo>) ReadExcelUtil.readExcelConvertObject(inputStream,CooperativeBaseInfo.class);
        Set<String> set = new HashSet<>();
        List<CooperativeBaseInfo> result = new ArrayList<>();
        for (CooperativeBaseInfo cooperativeBaseInfo : lists){
            String name = cooperativeBaseInfo.getName();
            if(name == null || set.contains(name)){
                continue;
            }
            set.add(name);
            cooperativeBaseInfo.setId(UUIDUtil.generateUUID());
            result.add(cooperativeBaseInfo);
        }
        lists = null;
        return result;
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
                            cooperativeBaseInfo.setCooperativeNo(cell.getStringCellValue());
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
                            cooperativeBaseInfo.setVisitorDate(cell.getStringCellValue());
                            break;
                        case 7:
                            cooperativeBaseInfo.setInvoiceNo(cell.getStringCellValue());
                            break;
                        case 8:
                            cooperativeBaseInfo.setCompensateAmount(new BigDecimal(cell.getStringCellValue()));
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

