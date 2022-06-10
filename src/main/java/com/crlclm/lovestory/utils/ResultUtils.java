package com.crlclm.lovestory.utils;

import com.crlclm.lovestory.enums.ResultCodeEnum;
import lombok.Data;


/**
 * ResultUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
@Data
public class ResultUtils {
    private String code;

    private String msg;

    private Object data;

    public static ResultUtils success(Object data) {
        return resultData(ResultCodeEnum.SUCCESS.val(), ResultCodeEnum.SUCCESS.msg(), data);
    }

    public static ResultUtils success(Object data, String msg) {
        return resultData(ResultCodeEnum.SUCCESS.val(), msg, data);
    }

    public static ResultUtils fail(String code, String msg) {
        return resultData(code, msg, null);
    }

    public static ResultUtils fail(String code, String msg, Object data) {
        return resultData(code, msg, data);
    }

    private static ResultUtils resultData(String code, String msg, Object data) {
        ResultUtils resultData = new ResultUtils();
        resultData.setCode(code);
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
}
