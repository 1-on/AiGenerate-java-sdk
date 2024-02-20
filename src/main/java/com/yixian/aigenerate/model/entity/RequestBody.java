package com.yixian.aigenerate.model.entity;

import lombok.Data;

import java.util.List;

@Data
public class RequestBody {
    private List<Message> messages;

}
