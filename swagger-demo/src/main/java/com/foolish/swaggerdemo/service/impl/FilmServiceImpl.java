package com.foolish.swaggerdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foolish.swaggerdemo.entity.Film;
import com.foolish.swaggerdemo.mapper.FilmMapper;
import com.foolish.swaggerdemo.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2020-01-10
 */
@Service
@CacheConfig(cacheNames="film")
public class FilmServiceImpl extends ServiceImpl<FilmMapper, Film> implements IFilmService {

    @Autowired
    private IFilmService filmService;

    @Override
    @Cacheable(key = "#fileName")
    public List<Film> getFilmsByName(String fileName) {
        System.out.println("从数据库查询：" + fileName);
        return filmService.lambdaQuery().eq(Film::getFilmName, fileName).list();
    }
}
