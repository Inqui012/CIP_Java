$(document).ready(function() {
	$(".addToCart").click(function() {
		var addToCart = $(this);
		var tr = addToCart.parent().parent();
		var td = tr.children();

		var name = td.eq(0).text();
		var price = td.eq(1).text();
		var cnt = td.eq(2).children("input").val();
		let flag = false;

		$("table.customerCart tbody tr").each(function(index, element) {
			var text = $(element).children().eq(0).text();
			var priceAdd = $(element).children().eq(3).text();
			var totalPrice = Number(totalPrice) + Number(priceAdd);
			if (text == name) {
				flag = true;
				var curQuant = $(element).children().eq(2).children("input").val();
				var newQuant = Number(cnt) + Number(curQuant);
				$(element).children().eq(2).children("input").attr("value", newQuant);
				$(element).children().eq(3).text(Number(newQuant) * Number(price));
			}
		});

		if (!flag) {
			const tableTo = $("table.customerCart");
			var str = "<tr>" +
				"<td>" + name + "</td>" +
				"<td>" + price + "</td>" +
				"<td><input type='number' name='listedQuant' value='" + cnt + "'>" + 
				"<button type='button' class='changeCart'>변경</button>" + 
				"<button type='button' class='deleteCart'>삭제</button></td>" +
				"<td>" + price * cnt + "</td>" +
				"</tr>";
			tableTo.append(str);
		}
		let totalPrice = 0;
		$("table.customerCart tbody tr").each(function(index, element) {
			var priceAdd = $(element).children().eq(3).text();
			totalPrice += Number(priceAdd);
		});
		$("table.customerCart tfoot tr td").text(totalPrice);

	});
});
