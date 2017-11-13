package com.hjc.common.util.excel;

import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public final class ReadExcelUtil {

//    private static final Logger logger = Logger.getLogger(ReadExcelUtil.class);

    private ReadExcelUtil(){

    }
    public static List<?> readExcelConvertObject(InputStream input, Class<?> clazz) throws IOException, IllegalAccessException, ValueFormatException, InstantiationException {
        //获取所有属性
        List<Object> list = new ArrayList<>();
        Workbook workbook = new HSSFWorkbook(input);
        Sheet sheet = workbook.getSheetAt(6);
        System.out.println(sheet.getSheetName());
        if (sheet == null)
            return new ArrayList<>();
        //获取Excel行数
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows < 2)//无数据直接返回
            return new ArrayList<>();
        //获取Excel列数
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 2; i < rows; i++) {
            Object obj = clazz.newInstance();
            Row row = sheet.getRow(i);
            for (Field field : fields) {
                field.setAccessible(true);
                String type = field.getType().toString();
                ExcelColumn excelColumn = field.getAnnotation(ExcelColumn.class);
                String value = "";
                if (excelColumn != null) {
                    Cell cell = row.getCell(excelColumn.index());
                    value = cell.toString();
                    System.out.println(value);
                    System.out.println(type);
                    formatValue(obj,field,type,value);//类型转换
                }
                Convert convert = field.getAnnotation(Convert.class);
                if (convert !=null){
                    Class<?> cla = convert.convert();
                    PropertyConvert<?> propertyconvert = null;
                    try {
                        propertyconvert=(PropertyConvert<?>) cla.newInstance();
                    } catch (Exception e) {
//                        logger.error("\"不能创建\"+cla.getName()+\"的实例\"",e);
                    }

                    field.set(obj,propertyconvert.convert(value));
                }
            }
            list.add(obj);
        }
        clazz.getName();
        return list;
    }

    private static void formatValue(Object obj,Field field,String type,String value) throws IllegalAccessException {
        if (type.endsWith("String"))
            field.set(obj,value);
        if (type.endsWith("int") || type.endsWith("Integer"))
            field.set(obj,Integer.parseInt(value));
        if (type.endsWith("BigDecimal"))
            field.set(obj,new BigDecimal(value));
    }

    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\Administrator\\Documents\\Tencent Files\\1838778265\\FileRecv\\2016年电子表格太平.xls");
            List<CooperativeBaseInfo> list = (List<CooperativeBaseInfo>) ReadExcelUtil.readExcelConvertObject(new FileInputStream(file), CooperativeBaseInfo.class);
            for (CooperativeBaseInfo temp: list) {
                System.out.println(temp.getAddress());
            }
        }catch (Exception e){
            e.printStackTrace();
//            logger.error("发生错误",e);
        }

    }
}
