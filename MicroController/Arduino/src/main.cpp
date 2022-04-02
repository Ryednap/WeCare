#include <Arduino.h>
#include <LiquidCrystal.h>
#include <SoftwareSerial.h>
#include <Vector.h>

#include "MedicineDispatcher.h"

uint8_t servoPins[2] = {13, 12};
uint8_t indicatorPins[2] = {A0, A1};

__attribute__((unused)) MedicineDispatcher dispatcher(Vector<uint8_t>(servoPins, sizeof(servoPins)),
                                                       Vector<uint8_t>(indicatorPins, sizeof(indicatorPins)));


void setupNodeMCU(void) {
    Serial.begin(115200);

}

void setup() {
    dispatcher.init();
}

void loop() {

}