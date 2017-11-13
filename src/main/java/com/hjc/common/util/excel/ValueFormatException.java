package com.hjc.common.util.excel;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class ValueFormatException extends Exception{

    private static final long serialVersionUID = -5740943821968954570L;

    @Getter
    @Setter
    private int row;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String reason;

    public ValueFormatException(int row,String name,String reason)
    {
        super();
        this.row=row;
        this.name=name;
        this.reason=reason;
    }

    public ValueFormatException(String msg)
    {
        super();
        reason=msg;
    }

    public ValueFormatException()
    {
        super();
    }

    public String getMessage()
    {
        String msg="";
        if(row>0)
            msg+="读取第"+row+"行数据错误，";
        else
            msg+="读取数据错误，";

        if(name!=null)
            msg+=name;

        if(reason!=null)
            msg+=reason;
        return msg;
    }

}
