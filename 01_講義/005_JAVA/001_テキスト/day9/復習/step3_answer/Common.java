package review_obj.step3_answer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {
	
	public static String getDateWithString(Date createDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(createDate);
	}
	
	public static String regexpCheck(String regex,String str,String defaultValue) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		if(m.find()) {
			return str;
		}
		return defaultValue;
	}
}
