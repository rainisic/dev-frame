$(document).ready(function() {
	
	$("#publishOrderForm").ajaxForm({
		beforeSubmit:	function() { 
			
			// Validate datas.
			if (!validate()) {
				return false;
			}
			
			// Block document until request finished.
			$.blockUI({ css: { 
				border: 'none', 
				padding: '15px', 
				backgroundColor: '#000', 
				'-webkit-border-radius': '10px', 
				'-moz-border-radius': '10px', 
				opacity: .5, 
				color: '#fff' 
			} }); 
		},
		success:	function(data) { 
			$.unblockUI();
			$("#publishOrderForm").clearForm();
		},
		error:		function(data) { 
			$.unblockUI();
		}
	});
});

function validate() {
	return true;
}