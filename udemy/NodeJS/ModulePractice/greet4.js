


//revealing module pattern
var greeting = '4th example'; // greeting is a private var 

function greet(){
    console.log(greeting);
}

//exposing what we want to the outside module
module.exports = {
    greet: greet
}

var util = require('util');
