
//Module Patterns


var greet = require('./greet1');
greet();

//Get the specific function from the module
var greet2 = require('./greet2').greet;
greet2();

//returns our own object from the greet3 Module
//greet3 caches the object so the next require of greet3 returns the same object
var greet3 = require('./greet3');
greet3.greet();
greet3.greeting = 'Changed hello world'; //changed the module object

//Shockingly, the greet3b is the new changed hello world
var greet3b = require('./greet3');
greet3b.greet();

//require can be used as a singleton