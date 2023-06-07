package com.kafka.test.controller;

import com.kafka.test.model.GetDataRequestModel;
import com.kafka.test.model.GetDataResponseModel;
import com.kafka.test.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/kafka")
public class KafkaController {

    private final KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping(path = "/getData", produces = {MediaType.APPLICATION_JSON_VALUE})
    public GetDataResponseModel addNewPeople(@RequestBody GetDataRequestModel DataRequestModel){
        return this.kafkaService.getData(DataRequestModel);
    }
}
