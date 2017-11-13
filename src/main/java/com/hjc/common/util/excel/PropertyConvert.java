package com.hjc.common.util.excel;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public interface PropertyConvert<T> {
    public T convert(Object obj) throws ValueFormatException;
}
