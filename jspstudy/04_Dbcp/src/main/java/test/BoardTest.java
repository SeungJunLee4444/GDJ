package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Board;
import repository.BoardDao;

// [JUNIT TEST 클래스]
// - import static org.junit.Assert.*;, import org.junit.Test; 가 import된 자바 클래스(클래스와 차이x)


/* 
 * [JUNIT 단위 테스트]
 * - 기능 : DAO의 메서드 단위로 단위 테스트를 수행하여, 서버(톰캣)을 작동시키지 않고 db의 데이터 여부를 테스트할 수 있다
 * & DAO = BEAN
 * 
 * => 서버(톰캣)가 돌지 않는 상태(controller 작동x)로 db에 접속
 * - Service 실행 결과가 "특정값인 경우" Service 대상으로 단위테스트를 수행할 수 있다
 * - 세팅 : BuildPath - AddLibrary - JUNIT4/5
 * 
 * - 테스트 수행 : 프로젝트 실행 : Run - JUNIT
 * - 주요 에너테이션
 * 	(1) @Test	: 단위 테스트를 수행하는 메서드
 * 	(2) @Before : 단위 테스트 수행 이전에 실행하는 메서드
 * 	(3) @After  : 단위 테스트 수행 이후에 실행되는 메서드
 * */



public class BoardTest {

	@Test
	public void 목록테스트() {	// # 메서드명은 한글을 많이 쓴다
		
		// 목록의 개수가 5개이면 성공, 아니면 실패
		List<Board> boards = BoardDao.getInstance().selectAllBoards();
		assertEquals(5, boards.size());	// 리스트의 길이가 5개이길 기대한다
		
	}
	

}
