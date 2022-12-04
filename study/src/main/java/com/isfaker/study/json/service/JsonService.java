package com.isfaker.study.json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isfaker.study.json.domain.Hobby;
import com.isfaker.study.json.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonService {

    public Hobby convertPerson(JsonNode personString) {
        log.info("=====convertPerson==start=====");
        ObjectMapper mapper = new ObjectMapper();
        Hobby hobby = null;
        try {
            Person person = mapper.treeToValue(mapper.valueToTree(personString), Person.class);
            JsonNode personOther = person.getOther();
             hobby = mapper.treeToValue(personOther, Hobby.class);
            log.info("=====the ikun hobby is {}=====", hobby);
            log.info("=====convertPerson==end=====");
        } catch (JsonProcessingException e) {
            log.error("Object [{}] convert is error",personString);
            log.error(e.getMessage());
        }
        return hobby;
    }
}
