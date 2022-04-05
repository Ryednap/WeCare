#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>
#include <ArduinoJson.h>

// Server configuration
const String server = "http://localhost:8080/";
const String path = "/api/v1/medicine";

[[maybe_unused]] const IPAddress ipAddress(10,42,0,1);
[[maybe_unused]] const int httpPort = 3000;

// Wifi configuration
const String SSID = "h2smedia";
const String password = "helloWorld";

// Machine Configuration
HTTPClient http;
WiFiClient client;


void printBanner() {
    Serial.println("  _  _            _         __  __    ___   _   _     __  __               _\n"
                   " | \\| |  ___   __| |  ___  |  \\/  |  / __| | | | |   |  \\/  |  __ _   ___ | |_   ___   _ _\n"
                   " | .` | / _ \\ / _` | / -_) | |\\/| | | (__  | |_| |   | |\\/| | / _` | (_-< |  _| / -_) | '_|\n"
                   " |_|\\_| \\___/ \\__,_| \\___| |_|  |_|  \\___|  \\___/    |_|  |_| \\__,_| /__/  \\__| \\___| |_|\n"
                   );
}

int attempt = 0;

void setup() {
    Serial.begin(115200);
    delay(500);
    Serial.println("\n");
    printBanner();
    Serial.println("Connecting to .. ");
    Serial.println(SSID);

    WiFi.begin(SSID, password);
    while (WiFi.status() != WL_CONNECTED) {
        delay(500);
        Serial.print(".");
    }

    Serial.println("");
    Serial.println("Wifi Connected");
    Serial.println("IP Address..");
    Serial.println(WiFi.localIP());
}

void loop() {
    delay(5000);

    // use WiFiClient to create TCP connection to create a transport layer
    // to transport the HTTP content

    if (!client.connect(ipAddress, httpPort)) {
        Serial.printf("Attempt %d: Connection Failed....\n", attempt);
        ++attempt;
        return;
    } else {
        Serial.println("Connection Established to the server....\n");
        attempt = 0;
    }

    http.begin(client, server + path);
    delay(10);
    int responseCode = http.GET();
    delay(10);
    Serial.printf("Response Code received From server... : %d\n", responseCode);
    String payload = http.getString();


    // JSON serialization
    ArduinoJson6193_F1::StaticJsonDocument<200> doc;
    ArduinoJson6193_F1::DeserializationError deserializationError = ArduinoJson6193_F1::deserializeJson(doc, payload);
    delay(100);

    if (deserializationError) {
        Serial.print(F("deserializeJson() Failed: "));
        Serial.println(deserializationError.f_str());
        return;
    }

    Serial.println("\n\n Message Payload");
    ArduinoJson6193_F1::serializeJsonPretty(doc, Serial);
}