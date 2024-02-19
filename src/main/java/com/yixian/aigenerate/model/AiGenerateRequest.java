package com.yixian.aigenerate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiGenerateRequest implements Serializable {

    /**
     * 消息
     */
    private String message;

    private static final long serialVersionUID = 1L;
}
