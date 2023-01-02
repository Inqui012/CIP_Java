$(".sellList tbody tr.sellmainList").on("click", function () {
	const sublist = $(this).nextUntil(".sellmainList");
	$(this).toggleClass("bgc");
	sublist.toggleClass("dispNone");
});

$(".prodEdit .productList tbody tr").on("click", function () {
	$(this).toggleClass("bgc");
	const prodName = null;
})

// function
function getTotalCart() {
	let totalPrice = 0;
	$("table.customerCart tbody tr").each(function(index, element) {
		var productTotal = Number($(element).children().eq(3).text());
		totalPrice += productTotal;
	});
	$("table.customerCart tfoot tr:first td").text(totalPrice);
}

function changeCart(row) {
	var price = Number($(row).parent().siblings("td:nth-child(2)").text());
	var newQuant = Number($(row).siblings("input").val());
	console.log(price);
	$(row).siblings("input").attr("value", newQuant);
	$(row).parent().siblings("td:nth-child(4)").text(newQuant * price);
	getTotalCart();
}

function deleteCart(row){
	$(row).parent().parent().remove();
	getTotalCart();
}

function addToCart(row, code) {
	var addToCart = $(row);
	var tr = addToCart.parent().parent();
	var td = tr.children();
	
	var nameToAdd = td.eq(0).text();
	var madeToAdd = td.eq(1).text();
	var priceToAdd = Number(td.eq(2).text());
	var cntToAdd = Number(td.eq(4).children("input").val());
	
	if(cntToAdd == ""){
		alert("수량을 입력해 주세요");
		return false;
	}
	let flag = false;

	$("table.customerCart tbody tr").each(function(index, element) {
		var CartProductName = $(element).children().eq(0).text();
		if (CartProductName == nameToAdd) {
			flag = true;
			var curQuant = Number($(element).children().eq(2).children("input").val());
			var newQuant = cntToAdd + curQuant;
			$(element).children().eq(2).children("input").attr("value", newQuant);
			$(element).children().eq(3).text(curQuant * priceToAdd);
		}
	});

	if (!flag) {
		const tableTo = $("table.customerCart");
		var btnAdd = "<button type='button' class='btn' onclick='changeCart(this);'>변경</button> ";
		var btnDel = "<button type='button' class='btn' onclick='deleteCart(this);'>삭제</button>";
		
		var nameTd = "<td><input type='hidden' name='medsCode' value='" + code + "'>" + nameToAdd + "</td>";
		var priceTd = "<td class='txtRight'>" + priceToAdd + "</td>";
		var cntTd = "<td class='quantInput'><input type='number' min='0' name='medsQuant' value='" + cntToAdd + "'> " + btnAdd + btnDel + "</td>";
		var totalTd = "<td class='txtRight'>" + priceToAdd * cntToAdd + "</td>";
		var newTR = "<tr>" + nameTd + priceTd + cntTd + totalTd + "</tr>";
		tableTo.append(newTR);
	}
	getTotalCart();
}

function cartSubmit() {
	const fm = $(".cartForm");
	const totalPrice = $("table.customerCart tfoot tr:first-child td").text();
	if (totalPrice == "") {
		alert("판매할 제품을 추가해 주세요");
		return false;
	}
	alert("판매를 완료했습니다.");
	fm.submit();
}

function cartReset() {
	const fm = $(".cartForm");
	$("table.customerCart tbody tr").each(function(index, element) {
		$(element).remove();
		getTotalCart();
	});
	alert("판매를 취소했습니다.");
	fm.reset();
}

function inputSubmit() {
	const fm = $(".prodForm");
	$("#prodIn").val() == "" ? $("#prodIn").val(0) : $("#prodIn").val();
	$("#prodStock").val() == "" ? $("#prodStock").val(0) : $("#prodStock").val();
	alert("제품을 추가하였습니다.");
	fm.submit();
}

function sellRefund(row) {
	const saleNo = $(row).parent().siblings().eq(0).text();
	const refChk = $(row).parent().siblings().eq(4).text();
	if (refChk == "환불완료") {
		alert("이미 환불처리된 결제입니다.");
		console.log
		return false;
	}
	const form = $(".refundForm");
	form.children("input").attr("value", saleNo);
	alert("판매번호 " + saleNo + " 를 환불 처리 하시겠습니까?")
	form.submit();
}

function prodRemove(row) {
	const prodCode = $(row).siblings("p").text();
	const prodName = $(row).parent().siblings().eq(0).text();
	const form = $(".removeForm");
	form.children("input").attr("value", prodCode);
	alert(prodName + " 을 판매목록에서 삭제 하시겠습니까?");
	form.submit();
}