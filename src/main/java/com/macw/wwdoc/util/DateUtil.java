package com.macw.wwdoc.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * 自定义日期格式化转换器
 */
public class DateUtil implements Converter<String, LocalDateTime> {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String dateTime = "yyyy-MM-dd HH:mm:ss";

	public static String date = "yyyy-MM-dd";

	@Override
	public LocalDateTime convert(String s) {
		if ("".equals(s) || s == null) {
			return null;
		}
		try {
			Date date = simpleDateFormat.parse(s);
			Instant instant = date.toInstant();// An instantaneous point on the time-line.(时间线上的一个瞬时点。)
			ZoneId zoneId = ZoneId.systemDefault();// A time-zone ID, such as {@code Europe/Paris}.(时区)
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
			return localDateTime;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String dateFormat(LocalDateTime dateTime, String format) {
		if (dateTime == null) {
			return null;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return dateTime.format(formatter);
	}

	private static int secureGet(TemporalAccessor temporalAccessor, ChronoField chronoField) {
		if (temporalAccessor.isSupported(chronoField)) {
			return temporalAccessor.get(chronoField);
		}
		return 0;
	}

	/**
	 * @param date
	 * @return
	 * @Title: setDayZero
	 * @Description: (获得一天的开始日期)
	 * @date 2019年10月15日 下午3:42:27
	 * @author 兴隆
	 */
	public static LocalDateTime setDayZero(String date) {
		TemporalAccessor temporalAccessor = DateTimeFormatter.ISO_DATE.parse(date);
		LocalDateTime localDateTime = LocalDateTime.of(secureGet(temporalAccessor, ChronoField.YEAR),
				secureGet(temporalAccessor, ChronoField.MONTH_OF_YEAR),
				secureGet(temporalAccessor, ChronoField.DAY_OF_MONTH),
				secureGet(temporalAccessor, ChronoField.HOUR_OF_DAY),
				secureGet(temporalAccessor, ChronoField.MINUTE_OF_HOUR),
				secureGet(temporalAccessor, ChronoField.SECOND_OF_MINUTE),
				secureGet(temporalAccessor, ChronoField.NANO_OF_SECOND));
		return localDateTime;
	}

	/**
	 * @param date
	 * @return
	 * @Title: setDayLast
	 * @Description: (获得一天的结束日期)
	 * @date 2019年10月15日 下午3:42:52
	 * @author 马超伟
	 */
	public static LocalDateTime setDayLast(String date) {
		TemporalAccessor temporalAccessor = DateTimeFormatter.ISO_DATE.parse(date);
		LocalDateTime localDateTime = LocalDateTime.of(secureGet(temporalAccessor, ChronoField.YEAR),
				secureGet(temporalAccessor, ChronoField.MONTH_OF_YEAR),
				secureGet(temporalAccessor, ChronoField.DAY_OF_MONTH), 23, 59, 59, 0);
		return localDateTime;
	}

 
	/**
	 * 
	 * @Title: formatDateTime 
	 * @Description: (获得时间的天时分秒) 
	 * @param mss
	 * @return  
	 * @date 2020年1月13日 下午2:37:46
	 * @author 马超伟
	 */
	public static JSONObject formatDateTime(long mss) {
		JSONObject json = new JSONObject();
		json.put("day", 0);
		json.put("hours", 0);
		json.put("minutes", 0);
		json.put("seconds", 0);
		long days = mss / (60 * 60 * 24);
		long hours = (mss % (60 * 60 * 24)) / (60 * 60);
		long minutes = (mss % (60 * 60)) / 60;
		long seconds = mss % 60;
		json.put("day", days);
		json.put("hours", hours);
		json.put("minutes", minutes);
		json.put("seconds", seconds);
		return json;
	}
}
