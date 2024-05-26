package org.leeinwon.studylink.config;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //해당 클래스가 스플이 빈에 대한 설정을하는 클래스임을 명시
public class ModelMapperConfig {

    @Bean   //이 메소드의 실행결과 반환된 객체를 스프링의 빈으로 등록 시킨다
    public ModelMapper getMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper;

    }
}
