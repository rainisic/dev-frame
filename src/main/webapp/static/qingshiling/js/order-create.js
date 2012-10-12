$(document).ready(function() {
	
	// Submit form by AJAX.
	$("#submit").click(function(event) {
		
		// Validate data.
		if (!validate()) {
			return false;
		}
		
		// Block document until request finished.
		$.blockUI({
			css: { 
				border: "none", 
				padding: "15px", 
				backgroundColor: "#000", 
				"border-radius": "10px", 
				opacity: 0.5, 
				color: "#fff" 
			}
		});
		
		// Construct data.
		var data =	"contact=" + $("#contact").val() +
					"&phone=" + $("#phone").val() +
					"&email=" + $("#email").val() +
					"&qq=" + $("#qq").val() +
					"&remark=" + $("#remark").val() +
					"&ticketInfo=";
		$(".ticket-count").each(function() {
			if ($(this).val() > 0) {
				data += $(this).parents("tr").find(".ticket-name").text() + ":" + $(this).val() + " ";
			}
		});
		
		// Post form.
		$.ajax({
			url:		$(event.target).parents("form").attr("action"),
			data:		data,
			type:		"post",
			dataType:	"text",
			success:	function(data) {
				
				if (data == "success") {
					
					// Clear form data.
					$("#publishOrderForm").resetForm();
					calculate();
					
					// Write hint message.
					$("div.hint h1").text("订单提交成功！");
				} else if (data == "failure") {
					
					// Write hint message.
					$("div.hint h1").text("订单提交失败，请检查数据！");
				}
				
				// Unblock UI.
				$.unblockUI();
				
				// Show success message.
				setTimeout(function() {
					
					// Show hint message.
					$.blockUI({ 
			            message: $("div.hint"), 
			            fadeIn: 1000, 
			            fadeOut: 1000, 
			            timeout: 2000, 
			            showOverlay: false,
			            css:	{
			            	border: "none",
			            	backgroundColor: "#000",
			            	opacity: 0.5,
			            	"border-radius": "10px"
			            }
			        });
				}, 500);
			},
			error:		function(data) { 

				// Unblock UI.
				$.unblockUI();
				
				// Show success message.
				setTimeout(function() {
					
					// Write hint message.
					$("div.hint h1").text("订单提交失败，请稍后重试！");
					
					// Show hint message.
					$.blockUI({ 
			            message: $("div.hint"), 
			            fadeIn: 1000, 
			            fadeOut: 1000, 
			            timeout: 2000, 
			            showOverlay: false,
			            css:	{
			            	border: "none",
			            	backgroundColor: "#000",
			            	opacity: 0.5,
			            	"border-radius": "10px"
			            }
			        });
					
					// Clear hint message.
					$("div.hint h1").text("");
				}, 500);
			}
		});
	});
	
	// Calculate cost on ticket count change.
	$(".ticket-count").change(function() {
		
		// Format data.
		if ($.trim($(this).val()).length == 0) {
			$(this).val("0");
		} else {
			$(this).val(parseInt($(this).val()));
		}
		
		// Calculate price.
		calculate();
	});
});

/**
 * Validate the form data.
 * @returns {Boolean}
 */
function validate() {
	
	// Check ticket count.
	if (parseInt($("#totalPrice").text()) <= 0) {
		$(".ticket-count").addClass("error");
		$.growlUI("错误提示", "您尚未购买任何类型的门票！");
		window.location.href = "#ticket-table";
		return false;
	} else {
		$(".ticket-count").removeClass("error");
	}
	
	// Check contact
	if ($.trim($("#contact").val()).length == 0) {
		$("#contact").addClass("error");
		$.growlUI("错误提示", "请填写联系人！"); 
		window.location.href = "#contact";
		return false;
	} else {
		$("#contact").removeClass("error");
	}
	
	// Check phone.
	if ($.trim($("#phone").val()).length == 0) {
		$("#phone").addClass("error");
		$.growlUI("错误提示", "请填写联系电话！"); 
		window.location.href = "#phone";
		return false;
	} else if ($.trim($("#phone").val()).length != 8 && $.trim($("#phone").val()).length != 11) {
		$("#phone").addClass("error");
		$.growlUI("错误提示", "联系电话应为8位或11位！"); 
		window.location.href = "#phone";
		return false;
	} else {
		$("#phone").removeClass("error");
	}
	return true;
}

/**
 * Calculate total cost.
 */
function calculate() {
	
	var totalPrice = 0;
	$(".ticket-count").each(function() {
		totalPrice += $(this).val() * parseInt($(this).parent().prev().text());
	});
	$("#totalPrice").text(totalPrice);
}