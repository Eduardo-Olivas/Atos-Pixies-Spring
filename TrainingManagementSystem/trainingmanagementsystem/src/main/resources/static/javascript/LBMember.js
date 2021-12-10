const apiCalllist = async (id) => {
	retrievedData = await fetch("api/LDMember/"+id);
	data = await retrievedData.json();
    alert("Prueba")
	console.log(data);
	return data;
}
$(document).ready(async function(){
    
    tempdata =await apiCalllist("0001")
    $("#member-api").text(tempdata.memberName)
 })
    