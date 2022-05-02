const readLine = require('readline');
const rl = readLine.createInterface({input : process.stdin, output: process.stdout});


const promise = new Promise((resolve, reject) => {
    rl.question('What is your name? ', (answer) => {
        if (answer.length > 0) resolve(answer);
        else reject(new Error("Name not entered"));
    })
});

promise.then((answer) => {
    console.log(`Hello world ${answer}`);
}).catch(err => console.log(err.message));
