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
	
	$("button.modify").button({
		icons: {
            primary: "ui-icon-clipboard"
        }
	});
	
	$("button.set-cover").button({
		icons: {
            primary: "ui-icon-clipboard"
        }
	});
	
	$("button.delete").button({
		icons: {
            primary: "ui-icon-trash"
        }
	});
	
	// Initialize dialog.
	$("#create-dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: 400,
		height: 300,
		modal: true,
		buttons: {
			"保存": function() {
				$("#create-submit").click();
			},
			"取消": function() {
				$(this).dialog("close");
				$("#create-form")[0].reset();
			}
		}
	});
	$("#edit-dialog").dialog({
		autoOpen: false,
		resizable: false,
		width: 400,
		height: 250,
		modal: true,
		buttons: {
			"保存": function() {
				$("#edit-submit").click();
			},
			"取消": function() {
				$(this).dialog("close");
				$("#edit-form")[0].reset();
			}
		}
	});

	/*
	 * Scroll to the top.
	 * This is for resolved the bug.
	 */
	$("body > section")[0].scrollTop = 0;
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
				window.location.href = "/album/picture/admin/delete.html?id=" + delete_id;
				$(this).dialog("close");
			},
			"取消": function() {
				$(this).dialog("close");
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
	
	var album = $(this).parents("li");
	
	// Put values.
	$("#edit-id").val(album.attr("id"));
	$("#edit-name").val(album.find("figurecaption").text());
	$("#edit-description").val(album.find("article").text());

	// Show dialog.
	$("#edit-dialog").dialog("open");
}

/**
 * Perform the create activity button action.
 */
function createButtonClickActionPerformed() {
	
	// Show dialog.
	$("#create-dialog").dialog("open");
}
