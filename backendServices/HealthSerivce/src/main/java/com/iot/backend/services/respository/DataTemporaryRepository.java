package com.iot.backend.services.respository;

import com.iot.backend.services.model.DataModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayDeque;
import java.util.Queue;

@Repository
public class DataTemporaryRepository {
    private final Queue<DataModel> dataModelQueue;

    public DataTemporaryRepository() {
        this.dataModelQueue = new ArrayDeque<>();
    }

    public void enQueueData(DataModel dataModel) {
        int maxLength = 10;
        if (dataModelQueue.size() == maxLength) {
            dataModelQueue.poll();
        }
        dataModelQueue.add(dataModel);
    }

    public DataModel deQueueData() {
        if (dataModelQueue.isEmpty()) return null;
        return dataModelQueue.poll();
    }
}
