#include <ESP8266WiFi.h>
#include <WiFiClient.h>
#include <ArduinoJson.h>
#include "api/ServerController.h"



// Wifi configuration
const String SSID = "hello";
const String password = "helloworld";


// Light configuration
const int serverStatusLightPin = D0;


void printBanner() {
    Serial.println("  _  _            _         __  __    ___   _   _     __  __               _\n"
                   " | \\| |  ___   __| |  ___  |  \\/  |  / __| | | | |   |  \\/  |  __ _   ___ | |_   ___   _ _\n"
                   " | .` | / _ \\ / _` | / -_) | |\\/| | | (__  | |_| |   | |\\/| | / _` | (_-< |  _| / -_) | '_|\n"
                   " |_|\\_| \\___/ \\__,_| \\___| |_|  |_|  \\___|  \\___/    |_|  |_| \\__,_| /__/  \\__| \\___| |_|\n"
                   );
}


void setup() {
    Serial.begin(115200);
    delay(5000);
    Serial.println("\n");
    printBanner();

    Serial.println("Connecting to .. ");
    Serial.println(SSID);

    WiFi.mode(WIFI_STA);
    WiFi.begin(SSID, password);
    delay(500);
    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.printf("Waiting status: %u\n", WiFi.status());

    }

    Serial.println("");
    Serial.println("Wifi Connected");
    Serial.println("IP Address..");
    Serial.println(WiFi.localIP());

    ServerController::init();
    pinMode(serverStatusLightPin, OUTPUT);
}

void loop() {
    for (int i = 0; i < 5; ++i) {
        digitalWrite(serverStatusLightPin, 1);
        delay(30);
        digitalWrite(serverStatusLightPin, 0);
    }
    delay(2500);
}