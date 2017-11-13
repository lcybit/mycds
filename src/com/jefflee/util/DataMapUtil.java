package com.jefflee.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DataMapUtil {

	public static Map<String, String> parseDataMap(Map<String, String[]> parameterMap) {
		Map<String, String> dataMap = new HashMap<String, String>();
		Iterator<Entry<String, String[]>> entrySetIterator = parameterMap.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		String key = "";
		String value = "";
		while (entrySetIterator.hasNext()) {
			entry = entrySetIterator.next();
			key = entry.getKey().toString();
			String[] values = entry.getValue();
			if (null == values) {
				value = "";
			} else {
				value = StringUtil.strings2String(values);
			}
			dataMap.put(key, value);
		}
		return dataMap;
	}

}
