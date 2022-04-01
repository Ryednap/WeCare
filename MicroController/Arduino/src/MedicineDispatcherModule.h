//
// Created by adleon on 01/04/22.
//

#ifndef ARDUINO_MEDICINEDISPATCHERMODULE_H
#define ARDUINO_MEDICINEDISPATCHERMODULE_H

// MicroController Libraries
#include <Arduino.h>
#include <LiquidCrystal.h>
#include <Servo.h>
#include <SoftwareSerial.h>
#include <Vector.h>

// User Libraries
#include "DispatcherIndicator.h"
#include "../lib/pair/src/Pair.h"


class MedicineDispatcherModule {
private:
    // Actuator Fields
    LiquidCrystal lcd;
    Servo * dispatcherServos;
    DispatcherIndicator * indicators;

    // Pin Configuration Fields
    Vector<uint8_t> dispatcherServoPins;
    Vector<uint8_t>indicatorPins;


public:
    MedicineDispatcherModule(const LiquidCrystal &lcd, const Vector<uint8_t> &dispatcherServoPins,
                             const Vector<uint8_t> &indicatorPins;

    void init() const;
    void display(String message) const;
    void rotateDispatcher(size_t which, uint16_t degree) const;
    void indicatorBlink(size_t which) const;
};


#endif //ARDUINO_MEDICINEDISPATCHERMODULE_H
