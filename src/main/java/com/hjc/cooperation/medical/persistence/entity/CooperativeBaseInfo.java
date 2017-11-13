package com.hjc.cooperation.medical.persistence.entity;

import com.hjc.common.util.excel.ExcelColumn;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class CooperativeBaseInfo {
    private String id;

    @ExcelColumn(name = "合医证号",index = 1)
    private String cooperativeno;

    @ExcelColumn(name = "姓名",index = 2)
    private String name;

    @ExcelColumn(name = "性别",index = 3)
    private int gender;

    @ExcelColumn(name = "年龄",index = 4)
    private int age;

    @ExcelColumn(name = "地址" ,index = 5)
    private String address;

    @ExcelColumn(name = "就诊时间",index = 6)
    private String visitordate;

    @ExcelColumn(name = "发票号码",index = 7)
    private String invoiceno;

    @ExcelColumn(name = "补偿金额",index = 8)
    private BigDecimal compensateamount;

}