package com.macw.wwdoc.util;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultUtil<T> {
	
	private Integer code;
	
	private String msg; 
	/** se  成功或者失败*/
	private boolean se;
	
	private T data;
	
	private Long count= 0L;
	
	private static final  int errorCode=400;
	
	private static final  int layuiCode=0;
	
	private static final  int apiCode=200;
	
	private static final String successMsg="操作成功";
	
	private static final String errorMsg="操作失败";
	
	private Map<String, Object> map = new HashMap<String, Object>();
	
	
	public static <T>ResultUtil<T> success() {
		return ResultUtil.ok(successMsg);
	}
	public static <T>ResultUtil<T>  success(T data) {
		return ResultUtil.ok(successMsg,data);
	}
	public static <T>ResultUtil<T>  success(String msg) {
		return ResultUtil.ok(msg);
	}
	public static <T>ResultUtil<T>  success(String msg,T data) {
		return ResultUtil.ok(msg,data);
	}
	
	
	public static <T>ResultUtil<T> error() {
		return ResultUtil.error(errorMsg);
	}
	public static <T>ResultUtil<T> error(T data) {
		return ResultUtil.error(errorMsg,data);
	}
	
	public static <T>ResultUtil<T> error(String msg, T data) {
		ResultUtil<T> result = new ResultUtil<T>();
		result.setCode(errorCode);
		result.setSe(false);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	public static <T>ResultUtil<T> error(String msg) {
		ResultUtil<T> result = new ResultUtil();
		result.setCode(errorCode);
		result.setSe(false);
		result.setMsg(msg);
		return result;
	}
	public static <T>ResultUtil<T> ok(String msg) {
		ResultUtil result = new ResultUtil();
		result.setCode(layuiCode);
		result.setSe(true);
		result.setMsg(msg);
		return result;
	}

	public static ResultUtil flag(Boolean b){
		if (b){
			return ResultUtil.success();
		}else {
			return ResultUtil.error();
		}
	}

	
	public static <T>ResultUtil<T> ok(String msg,T data) {
		ResultUtil<T> result = new ResultUtil<T>();
		result.setCode(layuiCode);
		result.setSe(true);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}


	/**
	 * 
	 * @Title: flag 
	 * @Description: (判断受影响行数大于successCode返回成功 否则返回false) 
	 * @param number
	 * @return  
	 * @date 2successCode19年9月23日 下午12:successCode3:54
	 * @author 马超伟
	 */
	public static ResultUtil influenceQuantity(Integer number) {
		if(number>0) {
			return ResultUtil.success();
		}else {
			return ResultUtil.error();
		}
	}
	/**
	 * 
	 * @Title: flag 
	 * @Description: (判断受影响行数大于successCode返回成功 否则返回false) 
	 * @param number
	 * @return  
	 * @date 2successCode19年9月23日 下午12:successCode3:54
	 * @author 马超伟
	 */
	public static ResultUtil influenceQuantity(Integer number,String msg) {
		if(number>0) {
			return ResultUtil.success(msg+successMsg);
		}else {
			return ResultUtil.error(msg+errorMsg);
		}
	}


	public static final ResultUtil selectOk() {
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg("查询成功");
		result.setSe(true);
		return result;
	}

	public static final ResultUtil saveOk() {
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg("保存成功");
		result.setSe(true);
		return result;
	}

	public static final ResultUtil deleteOk() {
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg("删除成功");
		result.setSe(true);
		return result;
	}

	public static final ResultUtil UpdateOk() {
		ResultUtil result = new ResultUtil();
		result.setCode(0);
		result.setMsg("修改成功");
		result.setSe(true);
		return result;
	}

	public static final ResultUtil UpdateFail() {
		ResultUtil result = new ResultUtil();
		result.setCode(400);
		result.setMsg("修改失败");
		result.setSe(false);
		return result;
	}

	public static final ResultUtil deleteFail() {
		ResultUtil result = new ResultUtil();
		result.setCode(400);
		result.setMsg("删除失败");
		result.setSe(false);
		return result;
	}

	public static final ResultUtil saveFail() {
		ResultUtil result = new ResultUtil();
		result.setCode(400);
		result.setMsg("添加失败");
		result.setSe(false);
		return result;
	}

	public static final ResultUtil selectFail() {
		ResultUtil result = new ResultUtil();
		result.setCode(400);
		result.setMsg("查询失败");
		result.setSe(false);
		return result;
	}
	
	

}
