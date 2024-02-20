package com.yixian.aigenerate.model.entity;

import lombok.Data;

@Data
public class ChatCompletion {
    private String id;
    private String object;
    private long created;
    private int sentence_id;

    private boolean isEnd;
    private boolean isTruncated;
    private String finishReason;

    private String result;

    private boolean needClearHistory;
    private int flag;

    private int banRound;
    private Usage usage;
}
