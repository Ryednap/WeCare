#include <Arduino.h>
#include <LiquidCrystal.h>
#include <SoftwareSerial.h>
#include <ArduinoJson.h>
#include <Servo.h>
#include "DispatcherIndicator.h"

// --------------------------------- CONSTANTS --------------------------------------------

uint8_t const indicatorPins[3] = {A0, A1, A2};
uint8_t const servoPins[2] = {13, 8};

Servo servo_1;
Servo servo_2;

// -------------------------- SENSORS AND ACTUATORS ---------------------------------------

__attribute__((unused)) SoftwareSerial NodeMcuMaster(0, 1);
__attribute__((unused)) DispatcherIndicator indicators [3] = {
        DispatcherIndicator(indicatorPins[0]),
        DispatcherIndicator(indicatorPins[1]),
        DispatcherIndicator(indicatorPins[2])
};

__attribute__((unused)) String upcomingMedicine[4];


LiquidCrystal lcd(2,3,4,5,6,7);


// ----------------------------- FUNCTION DEFINITION ----------------------------------------

void performAction(int indicatorIndex, int servoIndex, const String& lcdMessage1, const String& lcdMessage2);
void setupNodeMCU();

void setup() {
    Serial.begin(9600);
    for (auto indicator : indicators) {
        indicator.init();
    }

    servo_1.attach(12);
    setupNodeMCU();
}


void loop() {
    Serial.println("Hello World");
    String msg = NodeMcuMaster.readStringUntil('\r');
    if (msg.length() == 0) {
        lcd.clear();
        lcd.setCursor(0, 0);
        lcd.print("No Medication @");
        lcd.setCursor(0, 1);
        lcd.print ("Enjoy :)");
        return;
    }
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

        String lcdMessage1 = name + " " + dosage;
        if (type == "AB") {
            performAction(0, 0, lcdMessage1, description);
        } else if (type == "AV") {
            performAction(1, 1, lcdMessage1, description);
        }
    }
}

void setupNodeMCU() {
    Serial.begin(9600);
    NodeMcuMaster.begin(9600);
    lcd.begin(16, 2);

}


void performAction(int indicatorIndex, int servoIndex, const String& lcdMessage1, const String& lcdMessage2) {

    uint32_t times = 5;
    for( uint32_t tStart = 0; tStart  < times; ++times){
        // lcd display
        Serial.println(&"tStart = " [ tStart]);
        lcd.clear();
        lcd.setCursor(0, 0); lcd.print(lcdMessage1);
        lcd.setCursor(0, 1); lcd.print(lcdMessage2);
        indicators[indicatorIndex].blinkFade();
        delay(1000);
    }
    lcd.clear();
}
