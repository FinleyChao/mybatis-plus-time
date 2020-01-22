package com.foolish.swaggerdemo;

import com.alibaba.fastjson.JSON;
import com.foolish.swaggerdemo.entity.Film;
import com.foolish.swaggerdemo.service.IFilmService;
import com.foolish.swaggerdemo.util.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SwaggerDemoApplicationTests {

    @Autowired
    private IFilmService filmService;

    @Autowired
    private RedisService redisService;

    @Test
    void contextLoads() {
       /* Film byId = filmService.getById(100L);
        System.out.println(byId);*/
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
    }

    @Test
    void test1() {
        List<Film> films = filmService.lambdaQuery().eq(Film::getFilmName, "天禧").list();
        for (Film film : films) {
            System.out.println(film.getFilmName());
        }
        System.out.println(films);
    }

    @Test
    void test2() {
        //boolean set = redisService.set("name", "张三");
        Film byId = filmService.getById(5);
        boolean fileName = redisService.set("fileName", byId);
        Object obj = redisService.get("fileName");
        String s = JSON.toJSONString(obj);
        Film film = JSON.parseObject(s, Film.class);
        System.out.println(film);
    }

}
