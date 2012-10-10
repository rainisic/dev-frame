$(document).ready(function() {
	
	// Initialize all components..
	initialize();
	
	// Add action listener.
	actionListener();
});

/**
 * Initial method. Initialize all components.
 */
function initialize() {
	
	// Set button UI.
	$("#create").button({
		icons: {
            primary: "ui-icon-plus"
        }
	});
	
	// Initialize dialog.
	$("#edit-dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: 400,
		height: 250,
		modal: true,
		buttons: {
			"保存": function() {
				$("#submit").click();
			},
			"取消": function() {
				$(this).dialog("close");
				$("#edit-form")[0].reset();
			}
		}
	});
}

/**
 * Add action listener.
 */
function actionListener() {

	// Delete target activity.
	$(".delete").click( deleteButtonClickActionPerformed );
	
	// Modify activity.
	$(".modify").click( modifyButtonClickActionPerformed );
	
	// Show editor dialog.
	$("#create").click( createButtonClickActionPerformed );
}

/**
 * Perform the delete button action.
 */
function deleteButtonClickActionPerformed() {
	
	// Get activity id.
	var delete_id = $(this).parents("tr").attr("id");
	
	// Show hint dialog.
	$( "#delete-confirm" ).dialog({
		resizable: false,
		width: 400,
		height: 160,
		modal: true,
		buttons: {
			"删除": function() {
				window.location.href = "/ticket/admin/delete.html?id=" + delete_id;
				$( this ).dialog("close");
			},
			"取消": function() {
				$( this ).dialog("close");
			}
		}
	});
}

/**
 * Perform the modify button click action.
 * Load activity by ajax and displaied in the editor dialog.
 * Change the form action to "modify URL".
 */
function modifyButtonClickActionPerformed() {
	
	var row = $(this).parents("tr");
	
	// Put values.
	$("#id").val(row.attr("id"));
	$("#name").val(row.children("td:nth-child(2)").text());
	$("#price").val(row.children("td:nth-child(3)").text());

	// Change action url.
	$("#edit-form").attr("action", "/ticket/admin/update.html");
	
	// Show dialog.
	$("#edit-dialog").dialog("open");
}

/**
 * Perform the create activity button action.
 */
function createButtonClickActionPerformed() {
	
	// Change action url and show the editor dialog.
	$("#edit-form").attr("action", "/ticket/admin/publish.html");

	// Show dialog.
	$("#edit-dialog").dialog("open");
}
