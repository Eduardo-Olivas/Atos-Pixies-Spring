const apiCallOne = async (param) => {
	retrievedData = await fetch("/api/proposals/"+ param);
	data = await retrievedData.json();
	console.log(data);
	return data;
}

const apiCallOneRequirement = async (param) => {
	retrievedData = await fetch("/api/TrainingRequirements/"+ param);
	data = await retrievedData.json();
	console.log(data);
	return data;
}

$(document).ready(function () {
	$("#proposalID").hide()
	$('.container-details-yes').hide()
	
	$('.container-details-yes').hide()
	$("#execution-id-for-form").hide()
	$("#date-id-for-form").hide()
	$("#proposed-id-for-form").hide()
	$("#trainer-id-for-form").hide()
	$("#totalhrs-id-for-form").hide()
	$("#proposalstatus-id-for-form").hide()
	$("#total-allowed").hide()

	let id = $("#proposalID").val()
	console.log(id)

	async function bringInfoApi(id) {
		resources = await apiCallOne(id);
		console.log(resources.requirementID);
		resourcesTraining = await apiCallOneRequirement(resources.requirementID);
		$("#requirement-id-form").text(resourcesTraining.requirementID)
		$("#requirement-redate-form").text(resourcesTraining.requirementReceivedDate)
		$("#requirement-user-form").text(resourcesTraining.requirementUser)

		$("#requirement-vertical-form").text(resourcesTraining.requirementUserVertical)
		$("#requirement-training-form").text(resourcesTraining.trainingArea)
		$("#requirement-description-form").text(resourcesTraining.trainingDescription)

		$("#requirement-trainingdate-form").text(resourcesTraining.requestedTrainingStartDate)
		$("#requirement-total-form").text(resourcesTraining.totalCandidates)
		$("#requirement-timezone-form").text(resourcesTraining.trainingTimeZone)
		$("#requirement-duration-form").text(resourcesTraining.totalDurationDays)
	}
	
	
    $('#switch-for-trainer').click(
        function(){
            if($(this).is(':checked')){

                $("#trainer-response-id").hide();
				
                $("#execution-id-for-form").show();
				$("#date-id-for-form").show();
				$("#proposed-id-for-form").show();
				$("#trainer-id-field").val("Input your ID")
				$("#trainer-id-for-form").show();
				$("#totalhrs-id-for-form").show();
				$("#status-id-field").val("Not Confirmed")
				$("#proposalstatus-id-for-form").show();
				$("#total-allowed").show();
				
            } else {
                $("#trainer-response-id").show();
                $('.container-details-yes').hide();
				$("#execution-id-for-form").hide();
				$("#date-id-for-form").hide();
				$("#proposed-id-for-form").hide();
				$("#trainer-id-field").val("MEM01")
				$("#trainer-id-for-form").hide();
				$("#totalhrs-id-for-form").hide();
				$("#proposalstatus-id-for-form").hide();
				$("#total-allowed").hide();
            }
        }
    )

	bringInfoApi(id)
	})