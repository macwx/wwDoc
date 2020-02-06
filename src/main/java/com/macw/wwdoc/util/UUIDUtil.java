package com.macw.wwdoc.util;

import java.util.UUID;

public class UUIDUtil {

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getBytesUUID(byte[] b) {
		return UUID.nameUUIDFromBytes(b).toString().replace("-", "");
	}

	public static String getBytesUUID(String str) {
		return UUID.nameUUIDFromBytes(str.getBytes()).toString().replace("-", "");
	}

}
