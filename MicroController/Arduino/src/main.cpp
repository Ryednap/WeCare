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

void setupNodeMCU() {
    Serial.begin(9600);
    NodeMcuMaster.begin(9600);
}

void setup() {
    setupNodeMCU();
    dispatcher.init();
}

void loop() {

    String msg = NodeMcuMaster.readStringUntil('\r');
    if (msg.length() == 0) return;
    Serial.println("Received Message from Node server: " + msg);

    DynamicJsonBuffer buffer;
    JsonObject & json = buffer.parseObject(msg);
    if (json.success()) {
        String name = json.get<String>("name");
        String dosage = json.get<String>("dosage");
        String description = json.get<String>("description");
        String type = json.get<String>("type");

        Serial.println("name = " + name + "\n" + "dosage = " + dosage + "\n" + "desc = " + description + "\n" +
                    "type = " + type + "\n") ;

        MedicineDispatcher::displayMessage(name + "(" + dosage + ")", description);
        if (type.equals("AntiBacterial")) {
            dispatcher.move(0);
        } else dispatcher.move(1);
    }
}