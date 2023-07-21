package com.test.hanlptest.tagging;

import ch.qos.logback.core.net.server.Client;
import com.hankcs.hanlp.restful.HanLPClient;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @projectName: HanlpTest
 * @package: com.test.hanlptest.tagging
 * @className: PartOfSpeechTagging
 * @author: 马成
 * @description: TODO
 * @date: 2023/7/21 15:42
 * @version: 1.0
 */

@Component
public class PartOfSpeechTagging {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        HanLPClient client = new HanLPClient("https://hanlp.hankcs.com/api", null); // Replace null with your auth
        try {
            Map<String, List> parse = client.parse("你好啊我是小马");
            String summarization = client.abstractiveSummarization("你好啊我是小马");
            System.out.println(summarization);
            System.out.println(parse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
