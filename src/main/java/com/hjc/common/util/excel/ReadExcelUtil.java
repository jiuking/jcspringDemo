package com.hjc.common.util.excel;

import com.hjc.common.util.Constants;
import com.hjc.cooperation.medical.persistence.entity.CooperativeBaseInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

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
        if (sheet == null)
            return list;
        //获取Excel行数
        int rows = sheet.getPhysicalNumberOfRows();
        System.out.println("总行数"+rows);
        if (rows < 2)//无数据直接返回
            return list;
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
                    value = cell.toString().trim();
                    /*CellType cellType = cell.getCellTypeEnum();*/
                    formatValue(obj,field,type,cell);//类型转换
                }
                Convert convert = field.getAnnotation(Convert.class);
                if (convert !=null){
                    Class<?> cla = convert.convert();
                    PropertyConvert<?> propertyConvert = null;
                    try {
                        propertyConvert=(PropertyConvert<?>) cla.newInstance();
                    } catch (Exception e) {
//                        logger.error("\"不能创建\"+cla.getName()+\"的实例\"",e);
                    }

                    field.set(obj,propertyConvert.convert(value));
                }
            }
            list.add(obj);
        }
        clazz.getName();
        return list;
    }

    private static void formatValue(Object obj,Field field,String type,Cell cell) throws IllegalAccessException {
        String value = cell.toString().trim();
        if (value == null || value.equals(""))
            return;
        if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
            DecimalFormat df = new DecimalFormat("0.0");
            value = df.format(cell.getNumericCellValue());
        }
        if (value.endsWith(".0"))
            value = value.substring(0,value.indexOf(".0"));
        if (type.endsWith("String"))
            field.set(obj,value);
        if (value.matches(Constants.REGEXSTR) && (type.endsWith("int") || type.endsWith("Integer")))
            field.set(obj,Integer.parseInt(value));
        if (type.endsWith("BigDecimal"))
            field.set(obj,new BigDecimal(value));
    }

    public static void main(String[] args) {
        try{
            File file = new File("C:\\Users\\Administrator\\Documents\\Tencent Files\\1838778265\\FileRecv\\2016年电子表格太平.xls");
            List<CooperativeBaseInfo> list = (List<CooperativeBaseInfo>) ReadExcelUtil.readExcelConvertObject(new FileInputStream(file), CooperativeBaseInfo.class);
            for (CooperativeBaseInfo temp: list) {
                System.out.println(temp.getCompensateAmount());
                System.out.println(temp.getInvoiceNo());
                System.out.println(temp.getAge());
            }
        }catch (Exception e){
            e.printStackTrace();
//            logger.error("发生错误",e);
        }

    }

    public static void main1(String[] args) {
        String value = "12443434.5";
        System.out.println(value.substring(0,7));
        if (value.endsWith(".0"))
            System.out.println(value.substring(0,value.indexOf(".0")));
    }
}
