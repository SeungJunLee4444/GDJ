
package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Member;


public class MemberDao {
	
	// DAO : DB에 직접 접근하는 클래스
	
	
	private SqlSessionFactory factory;
	
	
	private static MemberDao dao = new MemberDao();
	
	// 2) 외부에서 호출못하게 만들기
	private MemberDao() {
		
		try {
			String resource = "mybatis/config/mybatis-config.xml";
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static MemberDao getInstance() {
		return dao;
	}
	//----------------------------------------------------------------------------
	
	// # 메서드
	// & 반환하는 값이 여러개면 selectList 메서드, 하나면 selectOne 메서드
	// & 메서드의 경로는 mapper의 namespace + 각 쿼리 메서드의 id
	
	// # StudentListService 서비스 만들기
	
	String mapper = "mybatis.mapper.member.";	// => final 처리하기
	
	// 1. 회원 목록
	public List<Member> selectAllMembers() {
		SqlSession ss = factory.openSession();
		List<Member> members = ss.selectList(mapper + "selectAllMembers");
		ss.close();
		return members;
	}
	
	// 2. 회원수
	public int selectAllMembersCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne(mapper + "selectAllMembersCount");
		ss.close();
		return count;
	}
	
	// 3. 상세설명
	public Member selectMemberByNo(int memberNo) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne(mapper + "selectMemberByNo", memberNo);
		// & mapper을 통한 db접근과 int전달
		// 경로에 merberNo를 전달
		// 전달받은값을 member에 저장
		ss.close();
		return member;
	}
	
	// 4. 회원등록
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);	// false : 내가 커밋하고싶어서(insert니까)
		int result = ss.insert(mapper + "insertMember", member);
		if(result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	
		
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


