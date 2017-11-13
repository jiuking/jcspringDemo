package com.hjc.cooperation.medical.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public enum GenderEnum {
   WOMAN("0","女"), MAN("1","男");
   @Getter
   @Setter
   private String index;
   @Getter
   @Setter
   private String value;

   GenderEnum(String index, String value){
      this.index = index;
      this.value = value;
   }
   public static String  getIndex(String value){
      if (value == null) {
         return null;
      }
      for (GenderEnum temp : GenderEnum.values()) {
         if (temp.getValue().equals(value))
            return temp.getIndex();
      }
      return null;
   }
}
