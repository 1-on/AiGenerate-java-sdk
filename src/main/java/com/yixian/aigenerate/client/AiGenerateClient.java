package com.yixian.aigenerate.client;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yixian.aigenerate.common.Result;
import com.yixian.aigenerate.model.AiGenerateRequest;
import com.yixian.aigenerate.model.AiGenerateResponse;

import java.util.HashMap;
import java.util.Map;

public class AiGenerateClient {
    public static final String URL = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";

    private final String access_token;


    public AiGenerateClient(String accessToken) {
        access_token = accessToken;
    }

    public Result<AiGenerateResponse> doChat(AiGenerateRequest aiGenerateRequest) {
        String message = aiGenerateRequest.getMessage();
        // 创建 JSON 对象
        cn.hutool.json.JSONObject jsonObject = new cn.hutool.json.JSONObject();
        // 创建包含在 "messages" 键下的 JSON 数组
        JSONArray messagesArray = new JSONArray();
        // 创建 JSON 对象，表示数组中的第一个元素
        cn.hutool.json.JSONObject messageObject = new cn.hutool.json.JSONObject();
        messageObject.set("role", "user");
        messageObject.set("content", message);
        messagesArray.set(messageObject);
        jsonObject.set("messages", messagesArray);
        String jsonObjectString = jsonObject.toString();


        String url = URL + "?access_token=" + access_token;
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        String jsonStr = JSONUtil.toJsonStr(jsonObjectString);
        String result = HttpRequest.post(url).addHeaders(headerMap).body(jsonStr).execute().body();
        JSON json = JSONUtil.parse(result);
        JSONObject jsonObject1 = new JSONObject(json);
        Object result1 = jsonObject1.get("result");
        String string = result1.toString();
        System.err.println(string);
        AiGenerateResponse aiGenerateResponse = new AiGenerateResponse();
        aiGenerateResponse.setContent(string);
        return Result.success(aiGenerateResponse);
    }

    public static void main(String[] args) {

    }
}
