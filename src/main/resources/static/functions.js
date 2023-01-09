function saveOrUpdate(){
	var idincident = $("#idincident").val();

	if(idincident != null && idincident.trim() != ''){
		update();
	}
	else{
		save();
	}
}
function save(){
	var idincident = $("#idincident").val();
	var name = $("#name").val();
	var description = $("#description").val();
	var createdAt = $("#createdAt").val();
	var updateAt = $("#updateAt").val();
	var closeAt = $("#closeAt").val();	
	
	$.ajax({
		method: "POST",
		url : "save",
		data: JSON.stringify(
				  { idincident : idincident,
					name : name, 
					description : description,
					createdAt : createdAt, 
					updateAt : updateAt,
					closeAt : closeAt }),
	contentType: "application/json; charset-utf-8",
	success: function (response){
		alert("Saved successfully")
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error saving: "+xhr.responseText);
	});
}

function update(){
	var idincident = $("#idincident").val();
	var name = $("#name").val();
	var description = $("#description").val();
	var createdAt = $("#createdAt").val();
	var updateAt = $("#updateAt").val();
	var closeAt = $("#closeAt").val();	
	
	$.ajax({
		method: "PUT",
		url : "update",
		data: JSON.stringify(
				  { idincident : idincident,
					name : name, 
					description : description,
					createdAt : createdAt, 
					updateAt : updateAt,
					closeAt : closeAt }),
	contentType: "application/json; charset-utf-8",
	success: function (response){
		alert("Update successfully")
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error update: "+xhr.responseText);
	});
}

function searchIncidents(){
	var searchIncidentId = $('#searchIncidentId').val();
	
	if(searchIncidentId != null && searchIncidentId.trim() != ''){
		
		$.ajax({
			method: "GET",
			url : "getById",
			data: "id="+  searchIncidentId,
		success: function (response){
			$('#tableIncidents > tbody > tr').remove();
			

				$('#tableIncidents > tbody').append('<tr><td>'+response.idincident+'</td><td>'+response.name+'</td><td>'+response.description+'</td><td>'+response.createdAt+'</td><td>'+response.updateAt+'</td><td>'+response.closeAt+'</td><td><button type="button" class="btn btn-primary" onclick="edit('+response.idincident+')">Edit</button></td><td><button type="button" class="btn btn-danger" onclick="deleteIncident('+response.idincident+')">Delete</button></td></tr>');

			
		}
		}).fail(function(xhr, status, errorThrown){
			alert("Error search: "+xhr.responseText);
		});
	}
}

function listAll(){
	$.ajax({
		method: "GET",
		url : "getAll",
	success: function (response){
		$('#tableIncidents > tbody > tr').remove();
		
			for(var i = 0; response.length; i++){
			$('#tableIncidents > tbody').append('<tr id="'+response[i].idincident+'"><td>'+response[i].idincident+'</td><td>'+response[i].name+'</td><td>'+response[i].description+'</td><td>'+response[i].createdAt+'</td><td>'+response[i].updateAt+'</td><td>'+response[i].closeAt+'</td><td><button type="button" class="btn btn-primary" onclick="edit('+response[i].idincident+')">Edit</button></td><td><button type="button" class="btn btn-danger" onclick="deleteIncident('+response[i].idincident+')">Delete</button></td></tr>');

			}
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error search: "+xhr.responseText);
	});
}

function edit(id){
	$.ajax({
		method: "GET",
		url : "getById",
		data: "id="+  id,
	success: function (response){
		 $("#idincident").val(response.idincident);
		 $("#name").val(response.name);
		 $("#description").val(response.description);
		 $("#createdAt").val(response.createdAt);
		 $("#updateAt").val(response.updateAt);
		 $("#closeAt").val(response.closeAt);	
		 
		 $("#modalSearchIncident").modal('hide');
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error search: "+xhr.responseText);
	});
}

function deleteIncident(id){
	$.ajax({
		method: "DELETE",
		url : "delete",
		data: "id="+  id,
	success: function (response){
		
		alert("Deleting successfully")
		$('#'+ id).remove();
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error deleting "+xhr.responseText);
	});
}

function listTop20(){
	
	$.ajax({
		method: "GET",
		url : "getTop20",
	success: function (response){
		$('#tableIncidents > tbody > tr').remove();
		
			for(var i = 0; response.length; i++){
			$('#tableIncidents > tbody').append('<tr id="'+response[i].idincident+'"><td>'+response[i].idincident+'</td><td>'+response[i].name+'</td><td>'+response[i].description+'</td><td>'+response[i].createdAt+'</td><td>'+response[i].updateAt+'</td><td>'+response[i].closeAt+'</td><td><button type="button" class="btn btn-primary" onclick="edit('+response[i].idincident+')">Edit</button></td><td><button type="button" class="btn btn-danger" onclick="deleteIncident('+response[i].idincident+')">Delete</button></td></tr>');

			}
	}
	}).fail(function(xhr, status, errorThrown){
		alert("Error search: "+xhr.responseText);
	});
}