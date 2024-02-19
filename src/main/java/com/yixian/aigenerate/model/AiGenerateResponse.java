package com.yixian.aigenerate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiGenerateResponse {

    /**
     * Ai生成内容
     */
    private String content;
}
