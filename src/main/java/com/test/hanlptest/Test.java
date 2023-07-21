package com.test.hanlptest;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class Test {

    @PostConstruct
    public void init() {
        //        HanLP.parseDependency("我是中国人民的儿子");

        List<Term> list = HanLP.newSegment().seg("汤姆江西省南昌市红谷滩新区111号电话12023232323");
        System.out.println(list);

        //        Segment result = HanLP.newSegment("汤姆江西省南昌市红谷滩新区111号电话12023232323");
        //        System.out.println(result);

        List<String> result2 = HanLP.extractSummary("7月19日，《中共中央 国务院关于促进民营经济发展壮大的意见》对外公布，提出了一系列重大举措，对民营经济定位有新表述。一些新提法，新举措，释放了重要的信号。",
            5);

        for (String item : result2) {
            System.out.println(item);
        }

        NLPTokenizer.ANALYZER.enableCustomDictionary(false);
        System.out.println(NLPTokenizer.segment("在我国，春季田间管理的重点是夏季粮油作物，主要是冬小麦和油菜，产量超过全年粮食产量的五分之一。"));
        NLPTokenizer.ANALYZER.enableCustomDictionary(true); // 使用用词典分词。
        System.out.println(NLPTokenizer.segment("在我国，春季田间管理的重点是夏季粮油作物，主要是冬小麦和油菜，产量超过全年粮食产量的五分之一。"));
        System.out.println(NLPTokenizer.analyze("我救的不是他，是多年前一个寒夜里，在篝火与烈酒中，想仗剑江湖的少年。").translateLabels());
    }
}
