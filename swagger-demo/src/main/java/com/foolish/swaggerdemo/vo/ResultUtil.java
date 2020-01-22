package com.foolish.swaggerdemo.vo;

/**
 * @Description:
 * @Author DaiYang
 * @Date 2019/1/7 17:25
 */
public class ResultUtil {

    public static ResultVO success(String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg(message);
        resultVO.setData(null);
        return resultVO;
    }

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
    public static ResultVO success(String message,Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg(message);
        resultVO.setData(object);
        return resultVO;
    }

    public static <T> ResultVO success(Object object, long totalCount){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }





    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ResultEnum.FAIL.getCode());
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO enumParam(CommonEnum commonEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(commonEnum.getCode());
        resultVO.setMsg(commonEnum.getMessage());
        return resultVO;
    }

    public static ResultVO enumParam(CommonEnum commonEnum,String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(commonEnum.getCode());
        resultVO.setMsg(message);
        return resultVO;
    }



    public static ResultVO enumParam(CommonEnum commonEnum,Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(commonEnum.getCode());
        resultVO.setMsg(commonEnum.getMessage());
        resultVO.setData(object);
        return resultVO;
    }

}
