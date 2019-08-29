package spark.utils;

import java.lang.reflect.Field;

import org.apache.commons.lang3.reflect.FieldUtils;

public class DarkMagic {

	public static Object getField(Object obj, String fieldName) {
		try {
			Field field = FieldUtils.getField(obj.getClass(), fieldName, true);
			return field.get(obj);
		} catch (Exception e) {
			throw new RuntimeException("cannot get handlebars", e);
		}
	}

}
