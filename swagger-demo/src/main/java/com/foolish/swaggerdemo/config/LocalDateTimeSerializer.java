package com.foolish.swaggerdemo.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @description: LocalDateTime日期格式化为时间戳
 * @author：chaoxianfei
 * @date：2019/9/10 14:41
 */
@Configuration
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Timestamp timestamp= Timestamp.valueOf(localDateTime);
        jsonGenerator.writeNumber(timestamp.getTime());
    }

}
