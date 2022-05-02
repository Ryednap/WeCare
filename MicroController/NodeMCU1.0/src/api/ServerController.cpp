//
// Created by Ryednap(Ujjwal) on 05/04/22.
//

#include <SoftwareSerial.h>
#include "ServerController.h"

const int PORT = 80;
AsyncWebServer server(80);
SoftwareSerial arduinoSlave(D9, D10);

void ServerController::init() {
    Serial.println("Connecting to Arduino");
    arduinoSlave.begin(9600);
    Serial.println(&"Arduino Serial Status: " [ arduinoSlave.available()]);
    Serial.println("Starting server... on port 80....");

    server.on("/", HTTP_GET, [](AsyncWebServerRequest * req) {
        Serial.println("Captured Request");
        AsyncWebServerResponse * res = req->beginResponse(200, "text/html", defaultMessage);
        req->send(res);
    });
    server.on("/iotController/medicine", HTTP_POST, [](AsyncWebServerRequest * req) {}, nullptr, serverPostRequest);

    server.begin();
    Serial.println("Server Started");
}

void ServerController::serverPostRequest(AsyncWebServerRequest * request, uint8_t *data, size_t len, size_t index, size_t total) {
    String transfer_message = String((char * )data);
    int statusCode = 400; // default error status code
    String responseMessage = "HTTP Payload is not JSON object";
    if (deserialize(transfer_message)) {
        statusCode = 200;
        responseMessage = "Message Committed Successfully";
    }
    Serial.println(transfer_message);
    Serial.println(&"\nAvailability " [ arduinoSlave.available()]);
    arduinoSlave.println(transfer_message);
    request->send(request->beginResponse(statusCode, "text/plan", responseMessage));

}

bool ServerController::deserialize(const char * json) {
    DynamicJsonBuffer buffer;
    return deserialize(buffer.parseObject(json));
}

bool ServerController::deserialize(const String & json) {
    return deserialize(json.c_str());
}

bool ServerController::deserialize(JsonObject & root) {
    return root.success();
}
