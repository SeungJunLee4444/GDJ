<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <% String contextPath = request.getContextPath(); %> --%>
<%-- & ${contextPath}로 쓸수없는 이유
=> 4개의 영역 아무곳에도 저장하지 않았기 때문
 --%>
 <% String contextPath = request.getContextPath();
 pageContext.setAttribute("contextPath", contextPath);
 %>
 <%-- & el은 라이브러리 없이도 사용가능하며, c:set이 동일한 기능을 처리한다
 	  & 자바코드를 태그로 바꾼것이 jstl
  --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	// = onload = function() {} (자바스크립트)
	$(document).ready(function() {
		fn_getAllMembers();	// 모든 멤버정보
		fn_getMember();		
		fn_registration();
		
	}) 
	function fn_getAllMembers() {
		$.ajax({
			/* 파라미터없는 요청 */
			type : 'get',
			url : '${contextPath}/member/list.do',
			/* 응답 */
			datatype : 'json',
			/* 성공한 json 데이터는 전부 resData로 온다 */
			success : function(resData) {
				
				// = resData['count']
				$('#count').text(resData.count);
				// member_list 영역 초기화 : empty : 비우기
				$('#member_list').empty();
				
				
			// resData.members : [{}, {}, {}]
			/* $.each(배열, function(인덱스, 배열요소){}) */
			$.each(resData.members, function(i, member){
				var tr = '<tr>';
				tr += '<td>' + member.memberNo + '</td>';
				tr += '<td>' + member.id + '</td>';
				tr += '<td>' + member.name + '</td>';
				tr += '<td>' + (member.gender == 'M' ? '남자' : '여자') + '</td>';
				tr += '<td>' + member.grade + '</td>';
				tr += '<td>' + member.address + '</td>';
				tr += '<td><input type="hidden" value="' + member.memberNo + '"><input type="button" value="조회" class="btn_detail"></td>';
				
				// & input type=hidden을 쓰는 이유
				// 1) btn_detail의 ajax의 파라미터값으로 멤버번호값이 필요하다
				// 2) input type=hidden은 보이지않는 버튼값이다(사용자에게 보이지않지만 파라미터 전송이 가능)
				// 3) 조회 버튼을 누르면, 파라미터값으로 이전 태그(prev())인 input type=hidden의 val()값을 호출해 저장하는 함수를 생성
				// 이런복잡한 구조를 만든 이유는, btn_detail이 정적 버튼이 아니라 동적 버튼이기 때문이다
				
				
				tr += '</tr>';
				$('#member_list').append(tr);
				// & 제이쿼리
				// html : 원래 있는 내용을 지워서 추가
				// append : 원래있는 내용에 추가
				
				// & btn_detail은 id대신 class를 사용해야한다
				// - 상황 : 동일한 버튼이 3개 만들어질 예정
				// - 동일한 id는 불가능, class는 가능
			});
				
			}
			/* => 등록되있는 3명의 데이터를 확인할 수 있다 */
			
		});
	}
	
	//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
	// & 동적버튼 : 이벤트에 의해 생성된 버튼은 일반적인 버튼 이벤트로는 작동하지않는다
	// => 해결을 위해서는 on()에 정적요소 부모를 추가해야한다
	// - 형태 : $('부모요소').on(이벤트타입, 이벤트대상, 이벤트리스너)
	
	// 목적 : btn_detail로  조회를 누르면, db에 저장된 해당 데이터를 텍스트창에 호출한다 
	
	// 1) 실패
		function fn_getMember() {
			/* 	$('.btn_detail').click(function()  */
			
	// 2) 성공
	$('body').on('click', '.btn_detail', function() {
		
			$.ajax({
				/* 요청 */
				type : 'get',
				url : '${contextPath}/member/detail.do',
				data : 'memberNo=' + $(this).prev().val(),
				// 요청할 파라미터 + 파라미터값
				
				/* 응답 */
				dataType : 'json',
				success : function(resData) {	// resData : {"exist" : true, "member" : { "id" : user3}}
					if(resData.exists) {
						alert('회원정보를 조회했습니다');
						$('#id').val(resData.member.id).prop('readonly', true);	
						$('#name').val(resData.member.name)	;
						$(':radio[name=gender][value=' + resData.member.gender +']').prop('checked', true);		
						// radio 조회하는법, 
						// value값을 찾아야함
						$('#grade').val(resData.member.grade);
						$('#address').val(resData.member.address);
					} else {
						alert('조회된 회원정보가 없습니다');
					}
					
				}
			});
	});	
	}	// fn_getMember() 끝-----------------------------------
	
	// & ajax가 ajax를 내부에서 부르면 promise의 대상이 될 수 있다
	
	// & insert, update는 post로 진행
	// # 신규등록 버튼을 누를 때(정적요소) 이벤트 발생
	function fn_registration() {
		$('#btn_add').click(function() {
			
			$.ajax({
				/* 요청 */
				type : 'post',
				url : '${contextPath}/member/add.do',
				
				/* 파라미터 
				제이쿼리 이벤트 serialize() : 폼 내부의 모든 입력요소를 파라미터로 만들어준다
				=> 사용하지않으면 모든 파라미터를 일일히 붙여줘야한다
				*/
				data : $('#frm_member').serialize(), 
				
				/* 응답 */
				dataType : 'json',
				// 1) 정상응답
				success : function(resData) {	// resData : {"isSuccess" : true}
					if(resData.isSuccess) {
						alert('신규회원이 등록되었습니다');	// isSuccess : 자바스크립트에서 성공시 true반환
						fn_getAllMembers();		// 등록된 멤버 포함 목록을 새로 가져옴
					} else {
						alert('신규회원 등록이 실패했습니다');
					}
					
				},
				// 2) 에러응답
				error : function(jqXHR) {	// 예외처리 응답 데이터(일반텍스트)는 jqXHR 객체의 responseText 속성에 저장(규칙)
					alert(jqXHR.responseText);	
					
				}
			});
			
		});
		
		
		
	} // fn_registration(); 끝-----------------------------------
	
</script>
</head>
<body>
	<div class="wrap">
		<h1 class="title"></h1>
		<form id="frm_member">
			<div>
				<label for="id">아이디</label>
				<input type="text" id="id" name="id">
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" id="name" name="name">
			</div>
			<div>
				<label for="male">남자</label>
				<input type="radio" id="male" name="gender" value="M">
				<label for="female">여자</label>
				<input type="radio" id="female" name="gender" value="F">
			</div>
			<div>
				<label for="grade">회원등급</label>
				<select id="grade" name="grade">
					<option value="" disabled selected>등급선택</option>
					<option value="gold">골드</option>
					<option value="silver">실버</option>
					<option value="bronze">브론즈</option>
				</select>
			</div>
			<div>
				<label for="address">주소</label>
				<input type="text" id="address" name="address">
			</div>
			<div>
				<input type="button" value="초기화" id="btn_init">
				<input type="button" value="신규등록" id="btn_add">
				<input type="button" value="변경내용저장" id="btn_modify">
				<input type="button" value="회원삭제" id="btn_remove">
				<%-- => ajax 처리할 버튼들 --%> 
			</div>
		</form>
		<hr>
		<table class="member_table">
			<caption>전체 회원 수 : <span id="count"></span>명</caption>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>번호</td>
					<td>성별</td>
					<td>등급</td>
					<td>주소</td>
					<td></td>		
				</tr>
			</thead>
			<tbody id="member_list">
				<tr>
					<%-- sql에 삽입된 인원 3명을 ajax로 출력 --%>  
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>					
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>