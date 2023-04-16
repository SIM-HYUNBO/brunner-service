package com.brunner.service.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

	public static String getFullMessage(Throwable e) {
		StringWriter sw = null;
		PrintWriter pw = null;
		String ret = Constants.emptyString;

		try {
			sw = new StringWriter();
			pw = new PrintWriter(sw);
			ret = Constants.emptyString;
			e.printStackTrace(pw);
			ret = String.format("%s\n%s", e.getMessage(), sw);
		} finally {
			if (pw != null) {
				pw.close();
				try {
					if (sw != null)
						sw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return ret;
	}
}
