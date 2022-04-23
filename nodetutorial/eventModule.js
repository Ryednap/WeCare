const EventEmitter = require('events');

const eventEmitter = new EventEmitter();

eventEmitter.on('hello', (params) => {
    console.log(`Hello world ${params}`);
});


setTimeout(() => {
    eventEmitter.emit('hello', 'from Ujjwal');
}, 1000);


class Person extends EventEmitter {
    constructor(name) {
        super();
        this._name = name;
    }

    get name() {return this._name;}
}

const pedro = new Person('Pedro');
pedro.on('sayHello', () => {
    console.log(`Hello From ${pedro.name}`);
});

setTimeout(() => {
    pedro.emit('sayHello');
}, 2000);

console.log("Main thread finished");
