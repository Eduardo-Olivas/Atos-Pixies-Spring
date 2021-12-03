let resource;
const apiCall = async () => {
	retrievedData = await fetch("/api/TrainingRequirements");
	data = await retrievedData.json();
	console.log(data);
	return data;
}

const apiCallOne = async (param) => {
	retrievedData = await fetch("/api/TrainingRequirements/"+ param);
	data = await retrievedData.json();
	console.log(data);
	return data;
}

const apiCallProposals = async (param) => {
	retrievedData = await fetch("/api/proposals/foreign-key/"+ param);
	data = await retrievedData.json();
	console.log(data);
	return data;
}

async function convertion(){
	let contents;
	let datas = await apiCall("");
	
	$(document).ready(function(){

		let cards = Array.from( document.querySelectorAll("#div-card-conatiner") )
		console.log($("#div-card-conatiner"));
		console.log(cards);
		alert("JOSELITO");

		cards.forEach( (card) => {
			card.addEventListener("click", async function(e){
				let title = document.querySelector("#injecting-title");
				let content1 = document.querySelector("#injecting-contents-1");
				let content2 = document.querySelector("#injecting-contents-2");
				let content3 = document.querySelector("#injecting-contents-3");
				let content4 = document.querySelector("#injecting-contents-4");
				let content5 = document.querySelector("#injecting-contents-5");
				console.log(card.firstElementChild.innerText);

				let infoApi = await apiCallOne(card.firstElementChild.innerText).catch( e => console.log(e) )
				console.log(infoApi);
				
				title.innerText = infoApi.trainingArea
				content1.innerText = "Starting Date: " + infoApi.requestedTrainingStartDate
				content2.innerText = "From: " + infoApi.requirementUser
				content3.innerText = "Total Candidates: " + infoApi.totalCandidates
				content4.innerText = "Duration: " + infoApi.totalDurationDays
				content5.innerText = "Description: " + infoApi.trainingDescription
				console.log(card.firstElementChild.nextElementSibling.nextElementSibling.innerText)
				let infoApiProposals = await apiCallProposals(card.firstElementChild.nextElementSibling.nextElementSibling.innerText);
				let list = document.querySelector("#list-for-proposals");
				list.replaceChildren("")
				infoApiProposals.forEach( e => {
					if(card.firstElementChild.nextElementSibling.nextElementSibling.innerText == e.executionID  ){
						listItem = document.createElement("li");
						listItem.innerText = e.proporsalID
						list.appendChild(listItem)
					}
				})

				let iconx = document.querySelector("#icon-x");
				iconx.addEventListener("click", function(){
					blackbox.classList.remove("black-box-display-on");
					blackbox.classList.add("black-box-display-off");
				})

				let blackbox = document.querySelector("#black-box");
				if(blackbox.classList.contains("black-box-display-off")){
					blackbox.classList.add("black-box-display-on");
					blackbox.classList.remove("black-box-display-off")
				}
			})
		})

		contents = document.querySelectorAll("#requirement-id")
		parsedArray = Array.from(contents);
		parsedArray.forEach(element => {
			console.log(element.innerText )
			for(i=0; i < datas.length; i++){
				console.log(datas[i].requirementID)
				if( element.innerText == datas[i].requirementID ){
						console.log($("#requirement-title"))
						element.innerHTML = datas[i].trainingArea
				}
			}
		});
	})
	
}

async function blackbox() {
	
}

blackbox();
convertion();