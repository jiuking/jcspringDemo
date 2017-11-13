package com.hjc.common.util.excel;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Convert {
    Class<? extends PropertyConvert<?>> convert();
}
