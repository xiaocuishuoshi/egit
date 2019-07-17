package com.whfp.oa.manager.hlkj.sbgl.webservice;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.http.util.ByteArrayBuffer;

public class StringTools {

	public static String convertStream(InputStream is, Charset charset) {
		if (is == null) {
		return "";
		}
		ByteArrayBuffer buffer = new ByteArrayBuffer(1024);
		byte[] buf = new byte[1024];
		while (true) {
		int len = 0;
		try {
		len = is.read(buf);
		} catch (IOException e) {
		e.printStackTrace();
		}
		if (len <= 0) {
		break;
		}
		buffer.append(buf, 0, len);
		}
		byte[] res = buffer.toByteArray();
		return new String(res, charset);
		}
}
