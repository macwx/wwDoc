package com.macw.wwdoc.util;

public class IntegerUtils {

	
	 public static boolean isBlank(Integer integer) {
		 if(integer==null || integer==0) {
			 return true;
		 }
		 return false;
	 }
	 public static boolean isNotBlank(Integer integer) {
		 if(integer==null || integer==0) {
			 return false;
		 }
		 return true;
	 }
}
