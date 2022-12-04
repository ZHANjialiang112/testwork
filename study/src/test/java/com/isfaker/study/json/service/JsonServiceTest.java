package com.isfaker.study.json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isfaker.study.json.domain.Gander;
import com.isfaker.study.json.domain.Hobby;
import com.isfaker.study.json.domain.Person;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@RequiredArgsConstructor
@SpringBootTest
public class JsonServiceTest {

    @NotNull
    private final JsonService jsonService = new JsonService();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private JsonNode person;

    @BeforeEach
    void setUp() {
       person =  buildPerson();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void convertPerson() {
        Hobby hobby = jsonService.convertPerson(person);
        log.info("=====the ikun hobby is {}=====", hobby);
    }

    public JsonNode buildPerson(){
        Person person = Person.builder()
                .name("ikun")
                .age(18)
                .gander(Gander.getDefault())
                .other(buildHObby())
                .build();
        return objectMapper.valueToTree(person);
    }

    private JsonNode buildHObby(){
        Hobby hobby = Hobby.builder()
                .song("唱歌")
                .dance("跳舞")
                .rap("rap")
                .basketBall("篮球")
                .build();
        return objectMapper.valueToTree(hobby);
    }
}