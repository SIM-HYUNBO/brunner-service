package com.brunner.service.dao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

import mw.utility.BrunnerLogger;

public class TB_COR_USER_LICENSE {
	private static final Logger logger = BrunnerLogger.getLogger(TB_COR_USER_LICENSE.class.getName());

	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String licenseKey
			) throws IOException {
		
 		String sqlId = "insert_TB_COR_USER_LICENSE_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("licenseKey", licenseKey);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			Date expireDate
			) throws IOException {
		
 		String sqlId = "update_TB_COR_USER_LICENSE_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("expireDate", expireDate);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String licenseKey) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_USER_LICENSE_01";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("licenseKey", licenseKey);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_USER_LICENSE_02";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}
}