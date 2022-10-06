// 비밀번호 없이 sign in 버튼 누르면 
// 경고창 띄우기 (비밀번호를 입력하세요)

// * 해결법
// (1) 버튼이 서브밋될때
// (2) form이 서브밋될 때
// => 두가지 방법이 있다

// 입력값(value)가 공백일때


document.getElementById('btn_signin').onclick = function(event) {
    var pw = document.getElementById('pw');
    if(pw.value == '') {
        alert('비밀번호를 입력하세요');

        // => form 위치가 잘못되서 작동안한것
        // 비밀번호 실패시 원래 사이트로 돌아가기(서브밋막는용도)
        event.preventDefault();
        return false;
    } 
}

// 글자쓸때마다 글자수 경고 나오기
document.getElementById('id').onkeyup = function(event) {
    var id = document.getElementById('id');
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0) {
        id_msg.textContent = '';
    } else if(id.value.length < 4) { 
        id_msg.textContent = '아이디는 4자 이상입니다';
    } else if(id.value.length >= 4) {
        id_msg.textContent = '정상적인 아이디입니다';
    }
}

// 4글자 이상이면 로그인 ok, 아니면 로그인x
// = 4점

