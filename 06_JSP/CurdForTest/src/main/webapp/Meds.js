const $btn = $("table.productList button");

function addCart() {
	$(this).click(() => {
		$(this).addClass("test");
	});
	
	const tableTo = $("table.customerCart");
	var cart = "<tr>" +
				"<td></td>" + 
				"<td><input type='number' name='listedQuant'></td>" + 
				"<td></td>" + 
				"<td></td>" + 
				"<td><input type='checkbox' name='listedDelete'></td>" + 
				"</tr>";
	tableTo.append(cart);
}