package com.brunner.service.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.brunner.service.util.LogUtil;

import mw.utility.BrunnerLogger;

public class TB_COR_AUTHORITY_GROUP_PROGRAM {
	private static final Logger logger = BrunnerLogger.getLogger(TB_COR_AUTHORITY_GROUP_PROGRAM.class.getName());
	
	public static int insert_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String createUserId,
			String authorityGroupId,
			String programId,
			String useFlag
			) throws IOException {
		
 		String sqlId = "insert_TB_COR_AUTHORITY_GROUP_PROGRAM_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("createUserId", createUserId);
		params.put("authorityGroupId", authorityGroupId);
		params.put("programId", programId);
		params.put("useFlag", useFlag);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	

	public static int update_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String updateUserId,
			String authorityGroupId, 
			String programId
			
			) throws IOException {
		
 		String sqlId = "update_TB_COR_AUTHORITY_GROUP_PROGRAM_01";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("authorityGroupId", authorityGroupId);
 		params.put("programId", programId);
		params.put("updateUserId", updateUserId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}	
	
	public static int update_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String updateUserId,
			String authorityGroupId,
			String programId
			) throws IOException {
		
 		String sqlId = "update_TB_COR_AUTHORITY_GROUP_PROGRAM_02";
 		int nEffected = 0;
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("updateUserId", updateUserId);
		params.put("authorityGroupId", authorityGroupId);
		params.put("programId", programId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		nEffected = session.insert(sqlId, params);
		
		return nEffected;
	}		
	
	public static List<HashMap<String, Object>> select_01(
			SqlSession session,
			String txnId,
			String systemCode, 
			String authorityGroupId, 
			String programId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_AUTHORITY_GROUP_PROGRAM_01";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("authorityGroupId", authorityGroupId);
		params.put("programId", programId);

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}

	public static List<HashMap<String, Object>> select_02(
			SqlSession session,
			String txnId,
			String systemCode, 
			String authorityGroupId, 
			String programId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_AUTHORITY_GROUP_PROGRAM_02";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("authorityGroupId", authorityGroupId);
		params.put("programId", programId);
		

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}	

	public static List<HashMap<String, Object>> select_03(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String parentProgramId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_AUTHORITY_GROUP_PROGRAM_03";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("parentProgramId", parentProgramId);
		

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}
	public static List<HashMap<String, Object>> select_04(
			SqlSession session,
			String txnId,
			String systemCode, 
			String userId, 
			String parentProgramId) throws IOException{
		
		List<HashMap<String, Object>> ret = null;
 		String sqlId = "select_TB_COR_AUTHORITY_GROUP_PROGRAM_04";
 		
 		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("systemCode", systemCode);
		params.put("userId", userId);
		params.put("parentProgramId", parentProgramId);
		

		logger.log(Level.INFO, String.format("[%s]\n%s", txnId, LogUtil.getSqlLog(session, sqlId, params)));   		
		ret = session.selectList(sqlId, params);
		
		return ret;
	}			
}