package com.kh.member.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

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
	public Member updateMemer(Member m) {
		
		
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
		Member updateMember = null;
		if(result>0) {
			commit(conn);
			updateMember = new MemberDao().selectMember(conn, m.getMemberId());
			
		}else {
			// 회원 정보 수정이 실패했을 경우 null이 반환될 것임.
			rollback(conn);
		}
		close(conn);
		return updateMember;
	}


}
