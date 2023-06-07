package com.kafka.test.service;

import com.kafka.test.kafka.Producer;
import com.kafka.test.model.GetDataRequestModel;
import com.kafka.test.model.GetDataResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {

    private final Producer producer;

    public GetDataResponseModel getData (GetDataRequestModel requestModel){
        GetDataResponseModel responseModel = new GetDataResponseModel();

        responseModel.setNickName(this.producer.sendMessage(requestModel.getName()).getNickName());

        return responseModel;
    }
}
