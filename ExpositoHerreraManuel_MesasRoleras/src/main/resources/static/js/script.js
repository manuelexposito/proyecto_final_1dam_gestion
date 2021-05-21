/**
 * 
 */
 /**
 * 
 */



//CHECKING BOOLEAN DATA

//let premiumTrue = document.querySelector("#premiumTrue");
//let premiumFalse = document.querySelector("#premiumFalse");

// let opValue = document.querySelectorAll("input[name=isPremium]").checked;
//let selectedValue;


 function rowClicked(id) {
        location.href = "/" + id;
    }

function premiumChecked(){
	
	let checkbox = document.querySelector("#filterByPremium");
	
	if(checkbox.checked){
	return true;
	} else return false;
}

 //FUNCTION FOR MAX VALUE = TODAY

let today = new Date();
let dd = today.getDate();
let mm = today.getMonth() + 1; //January is 0!
let yyyy = today.getFullYear();

if (dd < 10) {
    dd = '0' + dd
}
if (mm < 10) {
    mm = '0' + mm
}

today = yyyy + '-' + mm + '-' + dd;
document.getElementById("birthdate").setAttribute("max", today);



// SAVING ARRAY

let players = document.querySelectorAll(".playerInput")

let playersArray = [];

players.forEach(function (input) {
  if(input.type === 'checkbox' && input.checked) {
    playersArray.push(input.value);
  }
})



//FUNCTION FOR SEARCHING
const searchButton = document.getElementById('search-button');
const searchInput = document.getElementById('search-input');
searchButton.addEventListener('click', () => {
    const inputValue = searchInput.value;
    alert(inputValue);
});

