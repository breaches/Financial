package com.breach.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Questionnaire {
    private int consumer_id;
    private String age;    //年龄
    private String income;  //可支配收入
    private String layout;      //收入可用于投资的比例
    private String experience;  //投资经验
    private String target;      //投资的目标
    private String timeLimit;   //偏好的投资期限
    private String mood;        //投资出现什么问题，会感到焦虑

}
