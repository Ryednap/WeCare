#include <Arduino.h>
#include <LiquidCrystal.h>
#include <SoftwareSerial.h>
#include <Vector.h>
#include <ArduinoJson.h>

#include "MedicineDispatcher.h"

uint8_t servoPins[2] = {13, 12};
uint8_t indicatorPins[2] = {A0, A1};

__attribute__((unused)) MedicineDispatcher dispatcher(Vector<uint8_t>(servoPins, sizeof(servoPins)),
                                                       Vector<uint8_t>(indicatorPins, sizeof(indicatorPins)));

__attribute__((unused)) SoftwareSerial NodeMcuMaster(0, 1);

void setupNodeMCU(void) {
    Serial.begin(9600);
    NodeMcuMaster.begin(115200);
}

void setup() {
    setupNodeMCU();
    dispatcher.init();
}

void loop() {
    String msg = NodeMcuMaster.readStringUntil('\r');
    if (msg.length() == 0) return;
    Serial.println("Recieved Message from Node server: " + msg);

    DynamicJsonBuffer buffer;
    JsonObject & json = buffer.parseObject(msg);
    if (json.success()) {
        Serial.println(json.get<String>("message"));
    }
}