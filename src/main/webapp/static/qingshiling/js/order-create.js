$(document).ready(function() {
	
	// Definition the AJAX form.
	$("#publishOrderForm").ajaxForm({
		beforeSubmit:	function() { 
			
			// Validate data.
			if (!validate()) {
				return false;
			}
			
			// Block document until request finished.
			$.blockUI({ css: { 
				border: "none", 
				padding: "15px", 
				backgroundColor: "#000", 
				"border-radius": "10px", 
				opacity: 0.5, 
				color: "#fff" 
			} }); 
		},
		success:	function(data) { 

			if (data == "success") {
				
				// Clear form data.
				$("#publishOrderForm").resetForm();
				
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
	
	// Calculate cost on ticket count change.
	$(".ticket-count").change(function() {
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