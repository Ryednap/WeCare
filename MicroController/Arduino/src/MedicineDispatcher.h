//
// Created by adleon on 01/04/22.
//

#ifndef ARDUINO_MEDICINEDISPATCHER_H
#define ARDUINO_MEDICINEDISPATCHER_H


#include <Servo.h>
#include <LiquidCrystal.h>
#include <Vector.h>

#include "DispatcherIndicator.h"


class MedicineDispatcher {
private:

    Servo * dispatcherServos{};
    DispatcherIndicator * dispatcherIndicators{};


    Vector<uint8_t> servoPins;
    Vector<uint8_t> indicatorPins;

public:
    MedicineDispatcher() = default;
    MedicineDispatcher(const Vector<uint8_t> &servoPins, const Vector<uint8_t> &indicatorPins);
    void init() const;
    void move() const;
    static void displayMessage(const String& ) ;
};


#endif //ARDUINO_MEDICINEDISPATCHER_H
