package com.iot.backend.services.controller;

import com.iot.backend.services.model.DataModel;
import com.iot.backend.services.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/health")
@RestController
public class MainController {

    private final DataService dataService;

    @Autowired
    public MainController(DataService dataService) {
        this.dataService = dataService;
    }


    @GetMapping
    public ResponseEntity<?> getData() {
        DataModel model = dataService.getRecentDataModel();
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON)
                .body(model);
    }

    @PostMapping
    public ResponseEntity<?> postData(@RequestBody DataModel dataModel){
        dataService.putRecentDataModel(dataModel);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
