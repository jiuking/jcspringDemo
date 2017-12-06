package test.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

public class DictEntity implements Serializable {

    private static final long serialVersionUID = 1117423050234624357L;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String value;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Integer sort;

    @Getter
    @Setter
    private String parentId;

    @Getter
    @Setter
    private Integer status;

    @Getter
    @Setter
    private String remarks;

    @Getter
    @Setter
    private String createId;

    @Getter
    @Setter
    private Date createTime;

    @Getter
    @Setter
    private String updateId;

    @Getter
    @Setter
    private Date updateTime;

    @Getter
    @Setter
    private String parentName;

    @Getter
    @Setter
    private String isLevel;
}
