package com.foolish.swaggerdemo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/1/10 13:43
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createAt")) {
            Object createDate = this.getFieldValByName("createAt", metaObject);
            if (Objects.isNull(createDate)) {
                setInsertFieldValByName("createAt", LocalDateTime.now(), metaObject);
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject.hasSetter("updateAt")) {
            Object updateAt = getFieldValByName("updateAt", metaObject);
            if (Objects.isNull(updateAt)) {
                setUpdateFieldValByName("updateAt", LocalDateTime.now(), metaObject);
            }
        }
    }
}
