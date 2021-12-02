$(document).ready( function(){
    $('#execution-id-url').hide();
    let parameter = $('#execution-id-url').text();

    const apiExecution = async (param) => {
        data = await fetch("/api/TrainingExecutionMaster/" + param);
        parsed = await data.json();
        console.log(parsed);
        return parsed;
    }
    
    const apiCallOne = async (parameter) => {
		
        retrievedData = await fetch("/api/TrainingRequirements/" + parameter);
        data = await retrievedData.json();
        $("#id-api").text(data.requirementID);
        $("#date-api").text(data.requirementReceivedDate);
        $("#user-api").text(data.requirementUser);
        $("#vertical-api").text(data.requirementUserVertical);
        $("#total-api").text(data.totalCandidates);
        $("#days-api").text(data.totalDurationDays);
        $("#area-api").text(data.trainingArea);
        $("#description-api").text(data.trainingDescription);
        $("#timezone-api").text(data.trainingTimeZone);
        
        return data;
    }

    async function OneToRule() {
            let data = await apiExecution(parameter);
            apiCallOne(data.requirementID);
    }

    OneToRule();
})