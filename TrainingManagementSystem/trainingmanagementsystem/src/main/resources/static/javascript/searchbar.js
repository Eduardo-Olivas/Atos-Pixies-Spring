$(document).ready(
  function(){
    let search = document.querySelector("#input-search-bar")
    let divs = document.querySelectorAll("#div-card-conatiner")
    search.addEventListener('input', function(e){
        console.log(e.target.value)
        divs.forEach( card => {
            if(card.firstElementChild.nextElementSibling.nextElementSibling.innerText.includes(e.target.value) || e.target.value == "" )
            {    
                card.style.display = "block"
            } else {
                card.style.display = "none"
            }
        } )
    })
  }
)