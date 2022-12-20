function submitFunc(){
	var form = document.insFrm;
	
	if(form.custname.value == ""){
		alert("회원성명이 입력되지 않았습니다.");
		form.custname.focus();
		return false;
	}
	if(form.phone.value == ""){
		alert("회원전화가 입력되지 않았습니다.");
		form.phone.focus();
		return false;
	}
	if(form.address.value == ""){
		alert("회원주소가 입력되지 않았습니다.");
		form.address.focus();
		return false;
	}
	if(form.joindate.value == ""){
		alert("가입일자가 입력되지 않았습니다.");
		form.joindate.focus();
		return false;
	}
	if(form.grade.value == ""){
		alert("고객등급이 입력되지 않았습니다.");
		form.grade.focus();
		return false;
	}
	if(form.city.value == ""){
		alert("도시코드가 입력되지 않았습니다.");
		form.city.focus();
		return false;
	}
	form.submit();
}