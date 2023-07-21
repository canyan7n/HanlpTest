package com.test.hanlptest;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.document.sentence.Sentence;
import com.hankcs.hanlp.model.perceptron.Main;
import com.hankcs.hanlp.restful.HanLPClient;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @projectName: HanlpTest
 * @package: com.test.hanlptest
 * @className: Demo
 * @author: 马成
 * @description: TODO
 * @date: 2023/7/21 11:16
 * @version: 1.0
 */

@Component
public class Demo {
    public static void main(String[] args) {
        //test01();
        test02();
    }

    private static void test02() {
        HanLPClient client = new HanLPClient("https://hanlp.hankcs.com/api", null); // Replace null with your auth
        try {
            Map<String, List> parse = client.parse("2021年HanLPv2.1为生产环境带来次世代最先进的多语种NLP技术。晓美焰来到北京立方庭参观自然语义科技公司。");
//            System.out.println(parse.containsKey("tok/fine"));
            List list = parse.get("tok/fine");
            System.out.println(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void test01() {
        List<Term> terms = HanLP.newSegment().seg("你好我是小马");
        for (Term term : terms){
            System.out.println(term);
        }
        String summary = HanLP.getSummary("你好我是小", 5);
        System.out.println(summary);
        List<String> extractSummary = HanLP.extractSummary("你好我是小马", 1);
        for (String s : extractSummary){
            System.out.println(s);
        }
        NLPTokenizer.ANALYZER.enableCustomDictionary(true);
        Sentence analyze = NLPTokenizer.analyze("你好我是小马");
        System.out.println(analyze);
    }
}
