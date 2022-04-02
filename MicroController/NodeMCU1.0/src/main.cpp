#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>


String server = "http://dummy.restapiexample.com/api/v1/employees";
String SSID = "Redmi Note 10S";
String password = "ujhas8balls";

HTTPClient http;

void setup() {
    Serial.begin(115200);
    delay(10);
    Serial.println("\n");

    WiFi.begin(SSID.c_str(), password.c_str());
    Serial.print("Connecting to..");

    int i = 0;
    while (WiFi.status() != WL_CONNECTED) {
        delay(1000);
        Serial.print(++i); Serial.print(' ');
    }
    Serial.println('\n');
    Serial.println("Connection established!");
    Serial.print("IP address:\t");
    Serial.println(WiFi.localIP());
}

void loop() {
    WiFiClient client;
    http.begin(client, server);

    int responseCode = http.GET();
    String payload = http.getString();
    Serial.println("payload = " + payload);
    delay(2000);
}