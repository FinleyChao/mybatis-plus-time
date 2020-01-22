package com.foolish.swaggerdemo.controller;

import com.foolish.swaggerdemo.entity.Film;
import com.foolish.swaggerdemo.service.IFilmService;
import com.foolish.swaggerdemo.vo.FilmVO;
import com.foolish.swaggerdemo.vo.ResultUtil;
import com.foolish.swaggerdemo.vo.ResultVO;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/1/10 10:41
 */
@RestController
@Api(value = "电影Controller", tags = { "电影访问接口" })
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    /**
     * 添加一个电影数据
     *
     * @param
     * @return
     */
    @ApiOperation(value = "添加一部电影")
    @PostMapping("/addFilm")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filmName", value = "电影名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "score", value = "电影id", dataType = "Short", paramType = "query"),
            @ApiImplicitParam(name = "publishTime", value = "发布时间", dataType = "Short", paramType = "query"),
            @ApiImplicitParam(name = "creatorId", value = "创建者id", dataType = "Short", paramType = "query")
    })
    @ApiResponses(value = { @ApiResponse(code = 200, response = FilmVO.class,message = "返回值明细") })
    public ResultVO addFilm(@RequestBody Film film) {
        Boolean result = filmService.save(film);
        if (result) {
            return ResultUtil.success(film);
        }
        return ResultUtil.error("添加失败！");
    }

    /**
     * 根据电影名字获取电影
     *
     * @param fileName
     * @return
     */
    @GetMapping("/getFilms")
    @ApiOperation(value = "根据名字获取电影")
    @ApiImplicitParam(name = "filmName", value = "电影名", dataType = "String", paramType = "query", required = true)
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public ResultVO getFilmsByName(@RequestParam("fileName") String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return ResultUtil.error("参数错误!");
        }
        List<Film> films = filmService.getFilmsByName(fileName);
        return ResultUtil.success(films);
    }

    /**
     * 根据电影名更新
     *
     * @return
     */
    @PostMapping("/updateScore")
    @ApiOperation(value = "根据电影名修改分数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filmName", value = "电影名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "score", value = "电影id", dataType = "Short", paramType = "query")
    })
    @ApiResponses(value = { @ApiResponse(code = 1000, message = "成功"), @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数") })
    public ResultVO updateFilmScore(@RequestParam("fileName") String fileName, @RequestParam("score") Short score) {
        if (StringUtils.isEmpty(fileName) || Objects.isNull(score)) {
            return ResultUtil.error("参数错误!");
        }
        return ResultUtil.success();
    }

    /**
     * 根据电影名删除电影
     *
     * @param request
     * @return
     */
    @PostMapping("/delFilm")
    @ApiOperation(value = "根据电影名删除电影")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "filmName", value = "电影名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "id", value = "电影id", dataType = "int", paramType = "query")
    })
    public ResultVO deleteFilmByNameOrId(HttpServletRequest request) {
        //电影名
        String filmName = request.getParameter("filmName");
        //电影id
        Long filmId = Long.parseLong(request.getParameter("id"));

        //filmService.deleteFilmOrId(filmName,filmId);


        return ResultUtil.success();
    }

    /**
     * 根据id获取电影
     *
     * @param id
     * @return
     */
    @PostMapping("/{id}")
    @ApiOperation("根据id获取电影")
    @ApiImplicitParam(name = "id", value = "电影id", dataType = "long", paramType = "path", required = true)
    public ResultVO getFilmById(@PathVariable Long id) {

        if (Objects.isNull(id)) {
            return ResultUtil.error("参数错误!");
        }
        //Film film = filmService.getFilmById(id);
        /*if (Objects.nonNull(film)) {
            return ResultUtil.error("空！");
        }*/
        return ResultUtil.success();
    }

    /**
     * 修改整个电影
     *
     * @param film
     * @return
     */
    @PostMapping("/insertFilm")
    @ApiOperation("插入一部电影")
    public ResultVO insertFilm(@ApiParam("电影实体对象") @RequestBody Film film) {
        if (Objects.isNull(film)) {
            return ResultUtil.error("参数错误!");
        }
        /*Boolean isSuccess = filmService.insertFilm(film);
        if (isSuccess) {
            return CommonConstants.getSuccessResultModel();
        }*/
        return ResultUtil.success();
    }

}
