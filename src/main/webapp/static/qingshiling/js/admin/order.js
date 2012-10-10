$(document).ready(function() {
	
	// Delete target activity.
	$(".delete").click(function() {
		
		// Get activity id.
		var delete_id = $(this).parents("tr").attr("id");
		
		// Show hint dialog.
		$( "#delete-confirm" ).dialog({
			resizable: false,
			width: 400,
			height: 160,
			modal: true,
			buttons: {
				"取消": function() {
					$( this ).dialog( "close" );
				},
				"删除": function() {
					window.location.href = "/order/admin/delete.html?id=" + delete_id;
					$( this ).dialog( "close" );
				}
			}
		});
	});
});