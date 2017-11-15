package com.hjc.cooperation.medical.util;

import com.hjc.common.util.excel.PropertyConvert;
import com.hjc.common.util.excel.ValueFormatException;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public class ConvertUtil implements PropertyConvert<Integer>{

    @Override
    public Integer convert(Object obj) throws ValueFormatException {
        if (obj instanceof String){
            return GenderEnum.getIndex(obj.toString().trim());
        }

        return null;
    }
}
