//
// Created by Ryednap(Ujjwal) on 05/04/22.
//

#ifndef NODEMCU1_0_SERVERCONTROLLER_H
#define NODEMCU1_0_SERVERCONTROLLER_H

#include <ESP8266WiFi.h>
#include <ESPAsyncTCP.h>
#include <ESPAsyncWebServer.h>
#include <ArduinoJson.h>


class ServerController {
private:
    inline static const String defaultMessage = "<html>"
                                   "<body>"
                                   "<h1 style='color:blue;'"
                                   "Hello World from NodeMCU </h1>"
                                   "<h3 style='color:red;'> Author : Ryednap(Ujjwal Pandey) </h3>"
                                   "</body></html";
private:
    static bool deserialize(const String &);
    static bool deserialize(const char *);
    static bool deserialize(JsonObject &);
public:
    static void init() ;
    static void serverPostRequest(AsyncWebServerRequest *,  uint8_t*, size_t, size_t, size_t);
};


#endif //NODEMCU1_0_SERVERCONTROLLER_H
