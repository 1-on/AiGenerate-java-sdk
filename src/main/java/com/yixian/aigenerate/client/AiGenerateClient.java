package com.yixian.aigenerate.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.yixian.aigenerate.model.AiGenerateRequest;
import com.yixian.aigenerate.model.entity.ChatCompletion;
import com.yixian.aigenerate.model.entity.Message;
import com.yixian.aigenerate.model.entity.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AiGenerateClient {
    public static final String URL = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/completions";

    private final String access_token;


    public AiGenerateClient(String accessToken) {
        access_token = accessToken;
    }

    public ChatCompletion doChat(AiGenerateRequest aiGenerateRequest) {
        // 构造请求url
        String url = URL + "?access_token=" + access_token;
        // 构造请求头
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("Content-Type", "application/json");
        // 构造请求体
        RequestBody requestBody = new RequestBody();
        Message message = new Message();
        List<Message> list = new ArrayList<>();
        message.setRole("user");
        message.setContent(aiGenerateRequest.getMessage());
        list.add(message);
        requestBody.setMessages(list);
        // 发送请求
        String result = HttpRequest.post(url).addHeaders(headerMap).body(JSONUtil.toJsonStr(requestBody)).execute().body();
        // 将 JSON 字符串转换为 JSONObject 对象
        ChatCompletion chatCompletion = JSONUtil.parseObj(result).toBean(ChatCompletion.class);
        return chatCompletion;
    }

    public static void main(String[] args) {
        String accessToken = "your accessToken";
        AiGenerateClient client = new AiGenerateClient(accessToken);
        AiGenerateRequest request = new AiGenerateRequest();
        request.setMessage("你好");
        ChatCompletion chatCompletion = client.doChat(request);
        System.out.println(chatCompletion.getResult());

    }
}
