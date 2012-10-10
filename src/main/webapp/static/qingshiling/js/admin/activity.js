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
	
	// Load rich text editor
	$("textarea.tinymce").tinymce({
		// Location of TinyMCE script
		script_url : "/static/common/js/tiny_mce/tiny_mce.js",
		language: "cn",

		// General options
		theme : "advanced",
		plugins : "autolink,lists,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template,advlist",

		// Theme options
		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,emotions,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,template,pagebreak",
		theme_advanced_toolbar_location : "top",
		theme_advanced_toolbar_align : "left",
		theme_advanced_statusbar_location : "bottom",
		theme_advanced_resizing : false,
		
		// Style formats
		style_formats : [
			{title : 'Bold text', inline : 'b'},
			{title : 'Red text', inline : 'span', styles : {color : '#ff0000'}},
			{title : 'Red header', block : 'h1', styles : {color : '#ff0000'}},
			{title : 'Example 1', inline : 'span', classes : 'example1'},
			{title : 'Example 2', inline : 'span', classes : 'example2'},
			{title : 'Table styles'},
			{title : 'Table row 1', selector : 'tr', classes : 'tablerow1'}
		]
	});
	
	// Set button UI.
	$("#create-activity").button({
		icons: {
            primary: "ui-icon-plus"
        }
	});
	
	// Initialize datepicker.
	$("#publishTime").datepicker({ "dateFormat": "yy/mm/dd" });
}

/**
 * Add action listener.
 */
function actionListener() {
	
	// On list status changed.
	$("#list-status").change(function() { window.location.href = $(this).val(); });
	
	// Delete target activity.
	$(".delete").click( deleteButtonClickActionPerformed );
	
	// Modify activity.
	$(".modify").click( modifyButtonClickActionPerformed );
	
	// Show editor dialog.
	$("#create-activity").click( createButtonClickActionPerformed );
	
	// Cancel button action.
	$("#cancel").click( dialogCancelButtonClickActionPerformed );
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
			"取消": function() {
				$( this ).dialog( "close" );
			},
			"删除": function() {
				window.location.href = "/activity/admin/delete.html?id=" + delete_id;
				$( this ).dialog( "close" );
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
	
	$.ajax({
		url:		"/activity/admin/load.html",
		data:		"id=" + $(this).parents("tr").attr("id"),
		type:		"get",
		cache:		false,
		dataType:	"json",
		success:	function(activity) {
			
			// Put data.
			$("#id").val(activity.id);
			$("#title").val(activity.title);
			$("#content").val(activity.content);
			$("#priority").val(activity.priority);
			$("#status").val(activity.status);
			var date = new Date(activity.publishTime);
			$("#publishTime").val(date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate());
			
			// Show dialog.
			toggleDialog("show");
		}
	});
	
	// Change action url.
	$("#edit-activity-form").attr("action", "/activity/admin/update.html");
}

/**
 * Perform the create activity button action.
 */
function createButtonClickActionPerformed() {
	
	// Change action url and show the editor dialog.
	$("#edit-activity-form").attr("action", "/activity/admin/publish.html");

	// Show dialog.
	toggleDialog("show");
}

/**
 * Perform the cancel button action.
 */
function dialogCancelButtonClickActionPerformed() {
	
	// Hide the dialog.
	toggleDialog("hide");
}

/**
 * Show or hide the editor dialog.
 * @param operate "show" or "hide"
 */
function toggleDialog(operate) {
	
	if (operate == "show") {
		if ($("#edit-activity").is(":visible")) {
			$("#edit-activity").hide().css("left", ($(window).width() - 1000) / 2).css("top", ($(window).height() - 600) / 2);
		}
		$("#cover").fadeIn();
		$("#edit-activity").fadeIn();
	} else if (operate == "hide") {
		$("#cover").fadeOut();
		$("#edit-activity").fadeOut();
	}
}