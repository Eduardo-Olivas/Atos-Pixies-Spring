const apiCall = async (id) => {
	retrievedData = await fetch("/apiTrainingRequirementMaster/"+id);
	data = await retrievedData.json();
    alert("Prueba")
	console.log(data);
	return data;
}

$(document).ready(async function(){
    
    tempdata =await apiCall("TRM001")
    $("#id-api").text(tempdata.requirementID)
	$("#date-api").text(tempdata.requirementReceivedDate)
	$("#user-api").text(tempdata.requirementrequirementUser)
	$("#vertical-api").text(tempdata.requirementUserVertical)
	$("#total-api").text(tempdata.totalCandidates)
	$("#days-api").text(tempdata.totalDurationDays)
	$("#area-api").text(tempdata.trainingArea)
	$("#description-api").text(tempdata.trainingDescription)
	$("#timezone-api").text(tempdata.trainingTimeZone)
})
