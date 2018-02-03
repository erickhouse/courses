
'use strict';

class Person{
    constructor(firstname,lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    greet(){
        console.log(this.firstname);
    }
}

var str0 = 'cool'
var str1 = `Hello ${ str0 }`

//console.log(str1);

var p = new Person('e', 'house');
p.greet();