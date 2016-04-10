/**
 * Create by hedong
 * Since 2013-7-28下午2:16:19
 */
package com.accdays.jspTagAndFunction;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;

/**
 * @author hedong
 * @date 2013-7-28 下午2:16:19
 * @modifyNote
 * @version 1.0
 */
public class SelfJSPFunction {
	
	/**
	 * 将字符中的html标签过滤掉
	 * @Description
	 * @author hedong
	 * @date 2013-8-4 下午11:17:00
	 * @modifyNote 
	 * @param content
	 * @return
	 */
	public static String filterHtml(String content){
		return Jsoup.parse(content).text();
	}
	
	/**
	 * (0,10000)之间数字转大写
	 * @Description
	 * @author hedong
	 * @date 2013-7-28 下午2:22:25
	 * @modifyNote 
	 * @param num
	 * @return
	 */
	public static String intToChnNum(int num){
	    String resultNumber = null;
	    if(num > 10000 || num < 0){
	        return "";
	    }
	    Map<Integer,String> chnNumbers = new HashMap<Integer,String>();
	    chnNumbers.put(0, "零");
	    chnNumbers.put(1, "一");
	    chnNumbers.put(2, "二");
	    chnNumbers.put(3, "三");
	    chnNumbers.put(4, "四");
	    chnNumbers.put(5, "五");
	    chnNumbers.put(6, "六");
	    chnNumbers.put(7, "七");
	    chnNumbers.put(8, "八");
	    chnNumbers.put(9, "九");
	 
	    Map<Integer,String> unitMap = new HashMap<Integer,String>();
	    unitMap.put(1, "");
	    unitMap.put(10, "十");
	    unitMap.put(100, "百");
	    unitMap.put(1000, "千");
	    int[] unitArray = {1000, 100, 10, 1};
	 
	    StringBuilder result = new StringBuilder();
	    int i = 0;
	    while(num > 0){
	        int n1 = num / unitArray[i];
	        if(n1 > 0){
	            result.append(chnNumbers.get(n1)).append(unitMap.get(unitArray[i]));
	        }
	        if(n1 == 0){
	            if(result.lastIndexOf("零") != result.length()-1){
	                result.append("零");
	            }
	        }
	        num = num % unitArray[i++];
	        if(num == 0){
	            break;
	        }
	    }
	    resultNumber = result.toString();
	    if(resultNumber.startsWith("零")){
	        resultNumber = resultNumber.substring(1);
	    }
	    if(resultNumber.startsWith("一十")){
	        resultNumber = resultNumber.substring(1);
	    }
	    return resultNumber;
	}

}
