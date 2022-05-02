package com.iot.backend.services.service;

import com.iot.backend.services.model.DataModel;
import com.iot.backend.services.respository.DataTemporaryRepository;
import org.springframework.stereotype.Service;

@Service
public record DataService(DataTemporaryRepository dataRepository) {

    public DataModel getRecentDataModel() {
        return dataRepository.deQueueData();
    }

    public void putRecentDataModel(DataModel model) {
        dataRepository.enQueueData(model);
    }
}
