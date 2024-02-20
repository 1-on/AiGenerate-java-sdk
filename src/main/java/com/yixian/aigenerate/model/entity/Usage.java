package com.yixian.aigenerate.model.entity;

import lombok.Data;

@Data
public class Usage {
    /**
     * 问题tokens数
     */
    private int prompt_tokens;
    /**
     * 回答tokens数
     */
    private int completion_tokens;
    /**
     * 	tokens总数
     */
    private int total_tokens;

}
