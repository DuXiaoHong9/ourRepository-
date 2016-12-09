package converter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.conversion.TypeConversionException;


public class DateConverter extends StrutsTypeConverter{
	private final DateFormat[] dfs = {
			new SimpleDateFormat("yyyy-MM-dd"),
			new SimpleDateFormat("yyyy��MM��dd��"),
			new SimpleDateFormat("yyyy/MM/dd"),
			new SimpleDateFormat("yyyy.MM.dd"),
			new SimpleDateFormat("yyyyMMdd"),
			new SimpleDateFormat("MM.dd.yy")
	};

	/**
	 * ���ַ���ת����Date
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Object convertFromString(Map context, String[] values, Class toType) {
		String datestr = values[0];
		for (int i = 0; i < dfs.length; i++) {
			try {
				return dfs[i].parse(datestr);
			} catch (Exception e) {
				continue;
			}
		}
		throw new TypeConversionException();
	}

	/**
	 * ��Dateת����String
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String convertToString(Map context, Object object) {
		Date date = (Date)object;
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

}
