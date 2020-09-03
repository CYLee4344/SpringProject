<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
    <%@ include file="assets/inc/same_css.jsp"%>
	<link rel="stylesheet" type="text/css" href="assets/css/header.css" />
	<link rel="stylesheet" type="text/css" href="assets/css/Login.css" />
    <link rel="stylesheet" href="assets/plugins/sweetalert/sweetalert2.min.css" />
</head>

<body>
	<!-- 헤더 -->
	<div id="header">
        <ul>
            <li class="back"><a href="javascript:history.back()"><img src="assets/image/back.png"></a></li>
            <li class="search"><a href="#"><img src="assets/image/search.png"></a></li>
            <div class="searchbox">
                <input placeholder="search..." type="text" />
                <a href=""><img src="assets/image/search.png"></a>
            </div>
            <li class="title"><h1><strong>로그인</strong></h1></li>
            <li class="cart"><a href="ShoppingCart.jsp"><img src="assets/image/shopping_cart.png"></a></li>
        </ul>
    </div>
    
    <!-- 로그인 정보 입력 -->
	<div class="content">
    <div class="login_input_area">
        <form id="loginForm" class="form-inline" method="post" >
            <input id="user_id" type="text" name="user_id" class="form-control" placeholder="아이디를 입력하세요." />
            <br />
            <input id="user_pw" type="password" name="user_pw" class="form-control" placeholder="비밀번호를 입력하세요." />
            <!-- ajax 결과를 출력하기 위한 HTML -->
			<div id="result"></div>
            <br />
            <button type="submit" class="btn btn-primary" id="btn">로그인</button>
        </form>
        <div class="login_checking">
            <input type="checkbox" id="cb1" name="자동 로그인" />
            <label id="cb2" for="cb1"><span>자동 로그인</span></label>
        </div>
        <div class="borderline">
            <p name="구분선"></p>
        </div>
        <div class="signup">
            <a href="${pageContext.request.contextPath}/signup.do">회원가입</a>
        </div>
    </div>
    <div id="find_info">
        <p>아이디/비밀번호를 잊으셨나요?</p>
        <a href="Find_ID.jsp"><button id="find_id">아이디 찾기</button></a>
        <a href="Find_PW.jsp"><button id="find_pw">비밀번호 찾기</button></a>
    </div>
	</div>
	
	<!-- footer -->
    <%@ include file="assets/inc/footer.jsp"%>

    <!-- bottom_bar -->
    <%@ include file="assets/inc/bottom_bar.jsp"%>
    
    <!-- 스크립트 영역 -->
    <script src="assets/plugins/sweetalert/sweetalert2.all.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function() {

            $(".search").click(function() {
                $(".title").toggle();
                $(".searchbox").toggle();
            });

            $("#bottom_bar li:first-child").click(function(e) {
                e.preventDefault();
                $("#category_bar").slideToggle(100);
            });

            $("#user_id").focus(function() {
                $("#user_id").attr("placeholder", "");
            });

            $("#user_pw").focus(function() {
                $("#user_pw").attr("placeholder", "");
            });

            $("#user_id").blur(function() {
                $("#user_id").attr("placeholder", "아이디를 입력하세요.");
            });

            $("#user_pw").blur(function() {
                $("#user_pw").attr("placeholder", "비밀번호를 입력하세요.");
            });

            /** 로그인 양식 입력 시 **/
            $("#loginForm").submit(function(e) {
                // <form>태그가 submit되어 페이지가 이동되는 것을 방지한다.
                e.preventDefault();

                // 사용자의 입력값을 가져온다.
                var uid = $("#user_id").val();
                var pwd = $("#user_pw").val();

                // 올바른 ID와 PW를 입력 시,
                if (uid == "ajax" && pwd == "123qwe!@#" ) {
                	location.href='index.jsp';
                } else {
    	            $.ajax( {
    	                url:"../api/post.do",
    	                method: "post",
    	                data: { user_id: uid, user_pw: pwd },
    	                dataType: 'html',
    	                success: function(req) {
    	                    $("#result").html(req);
    	                }
    	            }); // end $ .ajax
                    $("#user_pw").val(""); // 로그인 실패 시 비밀번호 초기화
                    $("#user_pw").focus();
                } // 틀린 ID와 PW를 입력
            }); // end submit

            /** 3회, 5회 잘못입력 시 오류를 위한 조건문 **/
         	var counter = 0;
         	$("#btn").click(function(e) {
         		counter++;
    	     	
         		if (counter == 3) {
         			swal('잘못된 아이디 또는 비밀번호를 <br/>3회 입력하셨습니다.','5회이상 입력시<br/>로그인은 제한됩니다.','warning');
                        
    	     	} else if (counter == 5) {
    	     		swal({
                        title: '<font color="#E46764">잘못된 아이디 또는 비밀번호를<br/>5회 입력하셨습니다.</font>', // 제목
                        html: '비밀번호 찾기 페이지로 이동합니다.', // 내용
                        type: 'error',              // 종류
                        showCloseButton: true,      // 닫기 버튼 표시 여부
                        confirmButtonText: '확인',  // 확인버튼 표시 문구
                        confirmButtonColor: '#a00', // 확인버튼 색상
                        showCancelButton: true,     // 취소버튼 표시 여부
                        cancelButtonText: '취소',   // 취소버튼 표시 문구
                        cancelButtonColor: '#f60'   // 취소버튼 색상
                    }).then(function(result) {
                    	if (result.value) {
                    		location.href='Find_PW.jsp'
                    	} else if (result.dismiss) {
                    		location.href='Login.jsp'
                    	}
                    });
        	    } 
         	});
        });
    </script>
</body>
</html>