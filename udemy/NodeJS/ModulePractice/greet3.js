

function Greeter(){
    this.greeting = 'Example3';
    this.greet = function(){
        console.log(this.greeting);
    }
}

module.exports = new Greeter();