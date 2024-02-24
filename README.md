# AiGenerate Java SDK

基于 Spring Boot Starter 开发，封装百度智能云-千帆大模型 API 调用。

> 目前只支持 ERNIE-BOT 模型

## 快速开始

#### 0、引入 sdk

```xml
<dependency>
    <groupId>cn.yixianweb</groupId>
    <artifactId>AiGenerate</artifactId>
    <version>0.0.1</version>
</dependency>
```

#### 1、在 [千帆大模型平台](https://console.bce.baidu.com/tools/?_=1692863460488#/api?product=AI&project=%E5%8D%83%E5%B8%86%E5%A4%A7%E6%A8%A1%E5%9E%8B%E5%B9%B3%E5%8F%B0&parent=%E9%89%B4%E6%9D%83%E8%AE%A4%E8%AF%81%E6%9C%BA%E5%88%B6&api=oauth/2.0/token&method=post) 按照要求获取access key 并**开通 ERNIE-Bot 大模型公有云在线调用服务**

![](https://github.com/1-on/AiGenerate-java-sdk/blob/master/doc/imgs/getkey.png)

#### 2、初始化 AiGenerateClient 对象

方法 1：自主 new 对象

```java
String accessToken = "your accessToken";
AiGenerateClient client = new AiGenerateClient(accessToken);
```

方法 2：通过配置注入对象

修改配置：

```yaml
ai:
   client:
      access-token: your access-token
```

使用客户端对象：

```java
@Resource
private AiGenerateClient aiGenerateClient;
```

#### 3、构造请求参数

```java
AiGenerateRequest request = new AiGenerateRequest();
request.setMessage("你好");
```

#### 4、获取响应结果

```java
ChatCompletion chatCompletion = client.doChat(request);
String result = chatCompletion.getResult();
System.out.println(result);
```


## API 文档

### AI 对话

方法名：doChat

请求参数：

- message：要发送的消息，不能超过8000 个字符，且不能超过2048 tokens

响应结果：

- ChatCompletion 对象
  - result: 对话返回结果

其余参数请查阅 API 文档 [千帆大模型 API 响应说明](https://cloud.baidu.com/doc/WENXINWORKSHOP/s/jlil56u11#%E5%93%8D%E5%BA%94%E8%AF%B4%E6%98%8E)

示例代码：

```java
// 构造请求
AiGenerateRequest request = new AiGenerateRequest();
request.setMessage("你好");
// 获取响应
ChatCompletion chatCompletion = client.doChat(request);
System.out.println(chatCompletion.getResult());
```
