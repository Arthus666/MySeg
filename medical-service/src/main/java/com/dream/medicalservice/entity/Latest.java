package com.dream.medicalservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Latest {

    private String function;

    private File latestFile;

    public Latest() {

    }
}
