package com.brunner.service.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

import mw.utility.BrunnerLogger;

public class TB_COR_COMMON_CODE_GROUP {
	private static final Logger logger = BrunnerLogger.getLogger(TB_COR_COMMON_CODE_GROUP.class.getName());

	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String commonCodeGroupId,
			String commonCodeGroupDesc,
			String attribute1,
			String attribute2,
			String attribute3,
			String attribute4,
			String attribute5,
			String useFlag,
			String createUserId
			) throws IOException{
		
		int nEffected = 0;
 		String sqlId = "insert_TB_COR_COMMON_CODE_GROUP_01";

 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("commonCodeGroupId", commonCodeGroupId);
		params.put("commonCodeGroupDesc", commonCodeGroupDesc);
		params.put("attribute1", attribute1);
		params.put("attribute2", attribute2);
		params.put("attribute3", attribute3);
		params.put("attribute4", attribute4);
		params.put("attribute5", attribute5);
		params.put("useFlag", useFlag);
		params.put("createUserId", createUserId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}	
	
	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String commonCodeGroupId,
			String commonCodeGroupDesc,
			String attribute1,
			String attribute2,
			String attribute3,
			String attribute4,
			String attribute5,
			String useFlag,
			String updateUserId
			) throws IOException{
		
		int nEffected = 0;
 		String sqlId = "update_TB_COR_COMMON_CODE_GROUP_01";

 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("commonCodeGroupId", commonCodeGroupId);
		params.put("commonCodeGroupDesc", commonCodeGroupDesc);
		params.put("attribute1", attribute1);
		params.put("attribute2", attribute2);
		params.put("attribute3", attribute3);
		params.put("attribute4", attribute4);
		params.put("attribute5", attribute5);
		params.put("useFlag", useFlag);
		params.put("updateUserId", updateUserId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}
	
	public static int update_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String commonCodeGroupId,
			String updateUserId
			) throws IOException{
		
		int nEffected = 0;
 		String sqlId = "update_TB_COR_COMMON_CODE_GROUP_02";

 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("commonCodeGroupId", commonCodeGroupId);
		params.put("updateUserId", updateUserId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.update(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String commonCodeGroupId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_COMMON_CODE_GROUP_01";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("commonCodeGroupId", commonCodeGroupId); 

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String commonCodeGroupId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_COMMON_CODE_GROUP_02";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("commonCodeGroupId", commonCodeGroupId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	
}