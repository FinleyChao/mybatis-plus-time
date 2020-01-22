package com.foolish.swaggerdemo.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.foolish.swaggerdemo.BaseControllerTest;
import com.foolish.swaggerdemo.entity.Film;
import com.foolish.swaggerdemo.util.ParamUtils;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/1/13 10:22
 */
class FilmControllerTest extends BaseControllerTest {


    @Test
    void addFilm() throws Exception {
        Film film = Film.builder().filmName("战狼").score(8).publishTime(LocalDateTime.now()).creatorId(1L).build();
        String param = JSON.toJSONString(film);
        String result  = mockMvc.perform(post("/film/addFilm").accept(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON).content(param))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString();
        //单个断言
        System.out.println(result);
    }

    @Test
    void getFilmsByName() {

    }

    @Test
    public void test1(){
        //Film film = ParamUtils.setValue(Film::getFilmName, Film::getScore, Film::getPublishTime);
        //Film object = ParamUtils.getInstance(Film.class).setValue(Film::getFilmName, "天下无贼").setValue(Film::getPublishTime, LocalDateTime.now()).getObject();
        Map<SFunction<Film, ?>, Object> map = ParamUtils.getMap(Film.class);
        map.put(Film::getFilmName, "功夫");
        map.put(Film::getPublishTime, LocalDateTime.now());
        Film film = ParamUtils.setValue(map);
        System.out.println(film);
    }

}