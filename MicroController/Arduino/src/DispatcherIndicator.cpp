//
// Created by adleon on 25/04/22.
//

#include "DispatcherIndicator.h"

DispatcherIndicator::DispatcherIndicator(uint8_t pin) : pin(pin) {}


void DispatcherIndicator::init() const {
    // Todo Write to Error report
    if ((int)pin == -1) return;
    pinMode(pin, OUTPUT);
    digitalWrite(pin, LOW);
}

void DispatcherIndicator::blinkDot() const {
    // Todo Write to Error report
    if ((int)pin == -1) return;
    for (uint8_t i = 0; i < 3; ++i) {
        digitalWrite(pin, HIGH);
        delay(10);
        digitalWrite(pin, LOW);
        delay(10);
    }

    digitalWrite(pin, HIGH);
    delay(50);
    digitalWrite(pin, LOW);
    delay(50);
    digitalWrite(pin,HIGH);
    delay(50);
    digitalWrite(pin, LOW);
}

void DispatcherIndicator::blinkFade() const {
    // TODO Write to Error report
    if ((int)pin == -1) return;
    for (uint8_t brightness = 0; brightness <= 255; brightness += 3) {
        analogWrite(pin, brightness);
        delay(30);
    }
    for (uint8_t brightness = 255; brightness >= 0; brightness -= 3) {
        analogWrite(pin, brightness);
        delay(30);
    }
    analogWrite(pin, 0);
}

String DispatcherIndicator::toString() const {
    return {&"The pin of the LED indicator: " [ pin]};
}

void DispatcherIndicator::changePin(uint8_t inputPin) {
    pin = inputPin;
}