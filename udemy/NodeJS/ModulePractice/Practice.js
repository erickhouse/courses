
var mod = require("./module");

mod();

//object literal syntax
var person = {
    first : "John",
    last : "Doe",
    greet : function(){
        console.log("HelloWorld");
    }
}

var str = "cool";
var http = require('http');

//access properties
person.greet();
console.log(person['first']);

function Person(firstName, lastName){
    this.first = firstName;
    this.last = lastName;
}
var me = new Person("Erick", "House");

//a function that is intpreted and invoked immediately
//function expression
//this adds lexical scoping of variables
(function(){
    //private value
    var myvar = "test";
}());