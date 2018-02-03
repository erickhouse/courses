
var emitter =  require('./emitter');

var eventService = new emitter();

eventService.on('greet', function(){
    console.log('event Happended');
});

eventService.emit('greet');