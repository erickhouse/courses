
var http = require('http');
var fs = require('fs');

// http.createServer(function(request, response){

//     response.writeHead(200, {'Content-Type' : 'text/html'} );
//     var html = fs.readFileSync( __dirname + '/index.html', 'utf8');
    
//     var message = 'HelloCool';
//     html = html.replace('{Message}', message);

//     response.end(html);

// }).listen(1337, '127.0.0.1');

// http.createServer(function(request, response){

//     response.writeHead(200, {'Content-Type' : 'application/json'} );

//     var objLiteral = {
//         firstname: "Erick",
//         lastname:"House"
//     }
//     response.end(JSON.stringify(objLiteral));

// }).listen(1337, '127.0.0.1');

http.createServer(function(request, response){

    if(request.url === '/api'){

    }
    response.writeHead(200, {'Content-Type' : 'application/json'} );

    var objLiteral = {
        firstname: "Erick",
        lastname:"House"
    }
    response.end(JSON.stringify(objLiteral));

}).listen(1337, '127.0.0.1');