package com.cv4j.netdiscovery.core.domain;

import lombok.Data;

/**
 * Created by tony on 2018/1/15.
 */
@Data
public class SpiderEntity {

    private String spiderName;
    private int spiderStatus;
    private int leftRequestSize;     // 剩余的请求数
    private int totalRequestSize;    // 总共的请求数
    private int consumedRequestSize; // 已消费的请求数
    private String queueType;
    private String downloaderType;
}
