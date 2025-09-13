var itemPriceMap = new Map();
var categoryMenuListMap = new Map();
var salesArr = [];

$(document).ready(function(){
	//on load
	getMenuAndCategoryList();
});

function getMenuAndCategoryList(){
	$.ajax({
	    url:"getMenuAndCategoryList",
	    type:"POST",
	    dataType:"json",
	    success:function(data){ 
	    	if(data.categoryList != null && data.categoryList.length > 0){
		    	if(data.itemList != null && data.itemList.length > 0){
					var catHtml = "<option value='-1'>--- Category ---</option>";
					data.categoryList.forEach(function(cat){
						catHtml += "<option value='"+cat.id+"'>"+cat.description+"</option>";
						
						var itemHtml = "<option value='-1'>--- Item ---</option>";
						data.itemList.forEach(function(item){
							if(item.category==cat.id){
								itemHtml += "<option value='"+item.id+"'>"+item.description+"</option>";
								itemPriceMap.set(item.id, item.price);
							}
						});//-- item loop end
						categoryMenuListMap.set(cat.id, itemHtml);
						
					});//-- category loop end
					$("#category").html(catHtml);
					$("#item").html("<option value='-1'>--- Item ---</option>");
				} else {
					console.log("Items not found..!!");
				}
			} else {
				console.log("Category not found..!!");
			}
		},
		error : function() {
			console.log("Something went wrong..!!");
		}
    });
}

$(document).on('change', '#category', function(){
	var category = parseInt($("#category").val() || "-1");
	if(category != -1){
		$("#item").html(categoryMenuListMap.get(category));
	}else{
		$("#item").html("<option value='-1'>--- Item ---</option>");
	}
	$('#itemCount').html(1);
});

$(document).on('click', '#itemSubmit', function(){
	var item = parseInt($("#item").val() || "-1");
	var total = parseInt($("#total").html() || "0");
	var itemName = $("#item").find("option:selected").text();
	var itemCount = parseInt($("#itemCount").html() || "0");
	if(itemPriceMap.get(item) != undefined){
		var price = itemPriceMap.get(item);
		var itemAmount = itemCount*price;
		var tbRow = "<tr id='row"+item+"'>"
					+ "<td width='40%'>" + itemName + "</td>"
					+ "<td width='30%'>" + itemCount + "&times;" + price + "</td>"
					+ "<td width='15%'>&#8377;&nbsp;" + itemAmount + "</td>"
					+ "<td width='15%'>&nbsp;&nbsp;<i class='fas fa-trash text-danger item-delete' item-id="+item+" item-qn="+itemCount+" item-amt="+itemAmount+"></i></td>"
					+ "</tr>";
					
		//$('#itemsTable tr:last').after(tbRow);
		$('#itemsTable').append(tbRow);
		$("#total").html(total+itemAmount);
		salesArr.push(item + "_" + itemCount);
	}
	$('#itemCount').html(1);
});

$(document).on('click', '.item-delete', function(){
	var itemAmount = parseInt($(this).attr("item-amt") || "0");
	//alert(itemAmount);
	var itemId = parseInt($(this).attr("item-id") || "-1");
	var itemCount = parseInt($(this).attr("item-qn") || "0");
	if(itemId != -1 && itemCount > 0){
		$(this).parents("tr").remove();
		var total = parseInt($("#total").html() || "0");
		$("#total").html(total-itemAmount);
		var itemEle = itemId + "_" + itemCount;
		salesArr.splice(salesArr.indexOf(itemEle), 1);
		alert(salesArr);
	    //alert($('#itemsTable tr').length);
	}
});

$(document).on('click', '#itemAdd', function(){
	var itemCount = parseInt($("#itemCount").html() || "1");
	$("#itemCount").html(++itemCount);
});

$(document).on('click', '#itemRemove', function(){
	var itemCount = parseInt($("#itemCount").html() || "1");
	if(itemCount > 1){
		$("#itemCount").html(--itemCount);
	}
});

$(document).on('click', '#itemClear', function(){
	$("#itemCount").html(1);
});

$(document).on('click', '#btnSubmit', function(){
	$.ajax({
	    url:"salesEntry",
	    type:"POST",
	    data:{'items':JSON.stringify(salesMap), 'rebate':100},
	    dataType:"json",
	    success:function(data){ 
	    	if(data.msg == "success"){
				toastSuccess("SUCCESS", "Sale is saved successfully...!!");
			} else {
				toastError("ERROR", data.msg);
			}
		},
		error : function(data) {
			toastError("ERROR", data);
		}
    });
});



$(document).on('click', '#btnPosExcelUpload', function(){
	var file = $("#posExcelFile")[0].files[0];
	var formData = new FormData();
	formData.append("posExcelFile", file)
	
	if(file != ""){
		$.ajax({
		    url:"uploadPosExcel",
		    type:"POST",
		    data:formData,
			encType: 'multipart/form-data',
			contentType: false,  // Important!
			processData: false,  // Important!
			dataType:"json",
		    success:function(data){ 
		    	if(data.msg == "success"){
					toastSuccess("SUCCESS", "POS excel uploaded successfully...!!");
					$("#posExcelFile").val("");
				} else {
					toastError("ERROR", data.msg);
				}
			},
			error : function(data) {
				toastError("ERROR", data);
			}
	    });
	} else {
		toastError("ERROR", "Please select EXCEL file...!!");
	}
});


