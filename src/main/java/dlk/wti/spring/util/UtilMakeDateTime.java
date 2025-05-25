package dlk.wti.spring.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilMakeDateTime {
	
	LocalDateTime now = LocalDateTime.now();
	
	public String nano() {
	    int nanoSeconds = now.getNano(); // 나노일자시간 값 가져오기
	    return String.valueOf(nanoSeconds); // 문자열로 변환하여 반환
	}
	
	public String YYYYMMDD() {
	    String pattern = "yyyyMMdd";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	    return now.format(formatter);
	}
	
	public String hhmmss() {
	    String pattern = "HHmmss";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	    return now.format(formatter);
	}
	
	public String YYYYMMDDhhmmss() {
	    String pattern = "yyyyMMddHHmmss";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	    return now.format(formatter);
	}
	
	public String hhmmssColon() {
	    String pattern = "yyyy-MM-dd";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	    return now.format(formatter);
	}
	
	public String YYYYMMDDHyphen() {
	    String pattern = "HH:mm:ss";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	    return now.format(formatter);
	}

}
