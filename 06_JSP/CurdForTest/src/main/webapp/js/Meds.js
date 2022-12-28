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

function addToCart(row) {
	var addToCart = $(row);
	var tr = addToCart.parent().parent();
	var td = tr.children();

	var nameToAdd = td.eq(0).text();
	var priceToAdd = Number(td.eq(1).text());
	var cntToAdd = Number(td.eq(2).children("input").val());
	
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
		var str = "<tr>" +
			"<td>" + nameToAdd + "</td>" +
			"<td>" + priceToAdd + "</td>" +
			"<td><input type='number' name='listedQuant' value='" + cntToAdd + "'> " +
			"<button type='button' onclick='changeCart(this);'>변경</button> " +
			"<button type='button' onclick='deleteCart(this);'>삭제</button></td>" +
			"<td>" + priceToAdd * cntToAdd + "</td>" +
			"</tr>";
		tableTo.append(str);
	}
	getTotalCart();
}