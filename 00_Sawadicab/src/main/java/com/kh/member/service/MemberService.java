package com.kh.member.service;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		Member m = null;
		Connection conn = getConnection();
		m = new MemberDao().loginMember(conn,userId,userPwd);
		
		close(conn);
		
		
		
		return m;
	}

	public int insertMember(Member m) {
		int result = 0;
		
		Connection conn = getConnection();
		
		result = new MemberDao().insertMember(conn, m);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}
	

	public int deleteMem(String userId, String userPwd) {
		
		Connection conn = getConnection();
		int result = new MemberDao().deleteMem(conn, userId, userPwd);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	

}
