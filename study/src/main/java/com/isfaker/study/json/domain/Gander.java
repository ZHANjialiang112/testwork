package com.isfaker.study.json.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gander {

    MAN("男"),
    WOMAN("女");

    private String name;

    public Gander getName(String name) {
        for (Gander value : Gander.values()) {
            if (value.name.equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static Gander getDefault(){
        return MAN;
    }

}
