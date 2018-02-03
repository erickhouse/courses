
var EventEmitter = require('events');
var util = require('util');

function Greeter(){
    this.value = 'Cool';
}

util.inherits(Greeter, EventEmitter);

Greeter.prototype.greet = function(){
    console.log(this.value);
    this.emit('cool');
}

var greeter1 = new Greeter();

greeter1.on('cool', function(){
    console.log('Something cool happend');
});

greeter1.greet();