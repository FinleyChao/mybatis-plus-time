package com.foolish.swaggerdemo.service;

import com.foolish.swaggerdemo.entity.Film;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2020-01-10
 */
public interface IFilmService extends IService<Film> {

    List<Film> getFilmsByName(String fileName);
}
