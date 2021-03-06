package util.xsql.datamodifier.modifier;

import util.xsql.datamodifier.DataModifier;
import util.xsql.datamodifier.DefaultUtils;

import java.sql.Timestamp;
import java.text.DateFormat;

/**
 * @author badqiu
 */
public class TimestampDataModifier implements DataModifier {
	private static final String DEFAULT_TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	
	private String dateFormat = DEFAULT_TIMESTAMP_FORMAT;
	
	public TimestampDataModifier(){
	}
	
	public TimestampDataModifier(String dateFormat){
		this.dateFormat = dateFormat;
	}
	
	public Object modify(Object value, String modifierArgument) throws Exception{
		if(value == null) return null;
		if(value instanceof Timestamp) return value;
		DateFormat df = DefaultUtils.defaultDateFormat(modifierArgument, dateFormat);
		return new Timestamp(df.parse(value.toString()).getTime());
	}
	
}
