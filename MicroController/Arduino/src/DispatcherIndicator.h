//
// Created by adleon on 25/04/22.
//

#ifndef ARDUINO_DISPATCHERINDICATOR_H
#define ARDUINO_DISPATCHERINDICATOR_H

#include <Arduino.h>

class DispatcherIndicator {
private:
    uint8_t pin;
public:
    explicit DispatcherIndicator(uint8_t pin = -1);
    void init() const;
    void blinkDot() const;
    void blinkFade() const;
    void changePin(uint8_t pin);
    String toString() const;
};


#endif //ARDUINO_DISPATCHERINDICATOR_H
