//
// Created by Ryednap(Ujjwal) on 01/04/22.
//

#include "MedicineDispatcherModule.h"

MedicineDispatcherModule::MedicineDispatcherModule(const LiquidCrystal &lcd, const Vector<uint8_t> &dispatcherServoPins,
                                                   const Vector<uint8_t> &indicatorPins) : lcd(lcd),
                                                                                                dispatcherServoPins(
                                                                                                        dispatcherServoPins),
                                                                                                indicatorPins(
                                                                                                        indicatorPins){

    dispatcherServos = new Servo[dispatcherServoPins.size()];
    indicators = new DispatcherIndicator[indicatorPins.size()];
}

void MedicineDispatcherModule::init() const {
     lcd.begin(16, 2); // breaking Change in the LiquidCrystal.h (Make function begin() constant)

     for (size_t i = 0; i < dispatcherServoPins.size(); ++i) {
         dispatcherServos[i].attach(dispatcherServoPins[i]);
     }
     for (size_t i =0; i < indicatorPins.size(); ++i) {
        indicators[i] = DispatcherIndicator(indicatorPins[i]);
        indicators[i].init();
     }
}

void MedicineDispatcherModule::display(String message) const {
    lcd.clear();
    lcd.setCursor(0, 0);
    lcd.print(message.substring(0, 16));
}
