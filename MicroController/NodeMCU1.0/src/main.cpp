#include <Arduino.h>
#include <SoftwareSerial.h>

SoftwareSerial arduinoSerial (D1, D2);

void setup() {
    Serial.begin(115200);
    arduinoSerial.begin(9600);
}

void loop() {
    String message = arduinoSerial.readStringUntil('\r');
    Serial.println(message);
    Serial.println("Running Nodemcu Loop");
}