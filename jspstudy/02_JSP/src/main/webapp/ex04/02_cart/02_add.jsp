<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 요청 파라미터
	request.setCharacterEncoding("utf-8");
	String item = request.getParameter("item");
	int amount = Integer.parseInt(request.getParameter("amount"));
	// null 처리는 안했음
	
	// 2. 구매할 제품 + 구매수량 -> map에 저장(장바구니)
	Map<String, Object> product = new HashMap<>();
	// => 저장해야할 값이 string, int 복수의타입이니 object
	product.put("item", item);
	product.put("amount", amount);
	
	// 3. session에 장바구니를 cart 속성으로 저장한 상황이다
	// session에 cart 속성으로 있는지 확인한다
	// cart 속성이 없으면 새로 만들어서 저장
	// & list에 map을 집어넣는건 실무에서도 자주쓰인다 => 복습필요
	
	// 1) list 만들어서 cart 속성 저장
	List<Map<String, Object>> cart = (List<Map<String, Object>>)session.getAttribute("cart");
	if(cart == null) {
		cart = new ArrayList<>();	// => 첫 물건을 담을꺼면 장바구니를 새로 만들어 새 카트를 사용
		session.setAttribute("cart", cart);
	}
	
	// 4. session의 cart에 product 저장하기(만들어진 cart 속성에 product 집어넣기)
	// => 기존에 물건이 담긴 카드는 그대로 물건을 담음
	cart.add(product);
	
	

%>
<script>
	alert('<%=product.get("item")%>제품을 장바구니에 추가했습니다');
	if(confirm('장바구니를 확인하려면 "확인", 계속 쇼핑하려면 "취소"를 누르세요')) {
			location.href = '03_cart_list.jsp';
		} else {
			location.href = '01_form.jsp'
		}
</script>