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
	
	

}
