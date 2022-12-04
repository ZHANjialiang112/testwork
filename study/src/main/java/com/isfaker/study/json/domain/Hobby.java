package com.isfaker.study.json.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hobby {
//    唱歌
    private String song;
//    跳舞
    private String dance;
//    rap
    private String rap;
//    篮球
    private String basketBall;
}
