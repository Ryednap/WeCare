//
// Created by adleon on 01/04/22.
//

#include "MedicineDispatcher.h"

LiquidCrystal lcdDisplay = LiquidCrystal(9, 8, 5, 4, 3, 2);

MedicineDispatcher::MedicineDispatcher(const Vector<uint8_t>  &servoPins, const Vector<uint8_t>  &indicatorPins)
        : servoPins(servoPins), indicatorPins(indicatorPins) {

    dispatcherServos = new Servo[servoPins.size()];
    dispatcherIndicators = new DispatcherIndicator[indicatorPins.size()];
}

void MedicineDispatcher::init() const {
    lcdDisplay.begin(16, 2);
    for (size_t i = 0; i < servoPins.size(); ++i) {
        dispatcherServos[i].attach(servoPins[i]);
    }
    for (size_t i = 0; i < indicatorPins.size(); ++i) {
        dispatcherIndicators[i].changePin(indicatorPins[i]);
        dispatcherIndicators[i].init();
    }
}

void MedicineDispatcher::displayMessage(const String & message1, const String & message2) {
    lcdDisplay.setCursor(0, 0);
    lcdDisplay.print(message1);
    lcdDisplay.setCursor(0, 1);
    lcdDisplay.print(message2);
}

void MedicineDispatcher::move(int servoId) const {
    int count = (int)2e6;
    while (count > 0) {
        dispatcherServos[servoId].write(0);
        delay(1000);
        dispatcherServos[servoId].write(90);
        dispatcherIndicators[servoId].blinkDot();
        delay(2500);
        --count;
    }

}

