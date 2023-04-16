package com.brunner.service.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

import mw.utility.BrunnerLogger;

public class TB_COR_USER_MST {
	private static final Logger logger = BrunnerLogger.getLogger(TB_COR_USER_MST.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String password, 
			String userName, 
			String address, 
			String phoneNumber,
			String eMailId,
			String registerNo,
			String registerName,
			String salesType,
			String salesCategory,
			String useFlag
			) throws IOException {
		
 		String sqlId = "insert_TB_COR_USER_MST_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("password", password);
		params.put("userName", userName);
 		params.put("address", address);
		params.put("registerNo", registerNo);
		params.put("phoneNumber", phoneNumber);
		params.put("eMailId", eMailId);
		params.put("registerNo", registerNo);
		params.put("registerName", registerName);
		params.put("salesType", salesType);
		params.put("salesCategory", salesCategory);
		params.put("useFlag", useFlag);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String newPassword, 
			String systemCode, 
			String userId, 
			String currentPassword) throws IOException {
		
 		String sqlId = "update_TB_COR_USER_MST_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("newPassword", newPassword);
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("currentPassword", currentPassword);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}
	
	
	public static int update_02(
			SqlSession session,
			String txnId,
			String userName, 
			String address, 
			String phoneNumber, 
			String eMailId,
			String systemCode, 
			String userId, 
			String password) throws IOException {
		
 		String sqlId = "update_TB_COR_USER_MST_02";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
 		params.put("address", address);
		params.put("phoneNumber", phoneNumber);
		params.put("eMailId", eMailId);
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("password", password);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}

	public static int update_03(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String password) throws IOException {
		
 		String sqlId = "update_TB_COR_USER_MST_03";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("password", password);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}

	public static int update_04(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String authorityGroupId, 
			String updateUserId) throws IOException {
		
 		String sqlId = "update_TB_COR_USER_MST_04";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("authorityGroupId", authorityGroupId);
		params.put("updateUserId", updateUserId);


		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}
	
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_USER_MST_01";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);

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
 		String sqlId = "select_TB_COR_USER_MST_02";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
	
	public static List<HashMap<String, Object>> select_03(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_USER_MST_03";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}		
}