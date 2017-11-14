package com.hjc.cooperation.medical.util;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/11/13 0013.
 */
public enum GenderEnum {
   WOMAN(0,"女"), MAN(1,"男");
   @Getter
   @Setter
   private int index;

   @Getter
   @Setter
   private String value;

   GenderEnum(int index,String value){
      this.index = index;
      this.value = value;
   }
   public static int getIndex(String value){
      for (GenderEnum enum : GenderEnum.values()){
         if (enum.getValue().equals(value)){
            return enum.getIndex()
         }
      }
      return 1;
   }
}
