package test.bean;

import com.hjc.common.util.migrate.Row;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Dict implements Serializable{

    private static final long serialVersionUID = 955958948179262294L;

    @Row(index = 1, rowName = "id")
    @Getter
    @Setter
    private String id;

    @Row(index = 2, rowName = "value")
    @Getter
    @Setter
    private String value;

    @Row(index = 3, rowName = "label")
    @Getter
    @Setter
    private String label;

    @Row(index = 4, rowName = "TYPE")
    @Getter
    @Setter
    private String type;

    @Row(index = 5, rowName = "DESCRIPTION")
    @Getter
    @Setter
    private String description;

    @Row(index = 6, rowName = "SORT")
    @Getter
    @Setter
    private Integer sort;

    @Row(index = 7, rowName = "PARENT_ID")
    @Getter
    @Setter
    private String parentId;

    @Row(index = 8, rowName = "STATUS")
    @Getter
    @Setter
    private Integer status;

    @Row(index = 9, rowName = "REMARKS")
    @Getter
    @Setter
    private String remarks;

    @Row(index = 10, rowName = "CREATE_ID")
    @Getter
    @Setter
    private String createId;

    @Row(index = 11, rowName = "CREATE_TIME")
    @Getter
    @Setter
    private Date createTime;

    @Row(index = 12, rowName = "UPDATE_ID")
    @Getter
    @Setter
    private String updateId;

    @Row(index = 13, rowName = "UPDATE_TIME")
    @Getter
    @Setter
    private Date updateTime;

    @Row(index = 14, rowName = "IS_LEVEL")
    @Getter
    @Setter
    private String isLevel;

//    @Getter
//    @Setter
//    private String parentName;
}
