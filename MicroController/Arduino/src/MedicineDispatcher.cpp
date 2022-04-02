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

void MedicineDispatcher::displayMessage(const String & message) {
    lcdDisplay.setCursor(0, 0);
    lcdDisplay.print(message);
}

void MedicineDispatcher::move() const {
}

