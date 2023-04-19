package com.dream.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsageCount {

    private int user_display;

    private int user_segment;

    private int user_analyse;

    private int user_contrast;

}
