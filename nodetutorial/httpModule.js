const http = require('http');
const fs = require('fs');

const server = http.createServer((req, res) => {
    console.log('Server caught request');
    const readStream = fs.createReadStream('./static/index.html');
    if (readStream.readable) {
        res.writeHead(200, {'Content-Type' : 'text/html'});
        readStream.pipe(res);
    } else {
        res.writeHead(400, {'Content-Type' : 'text/plain; charset=utf-8'});
        res.write("Internal Server Error getting your file");
        res.send();
    }
}).listen(3000);
