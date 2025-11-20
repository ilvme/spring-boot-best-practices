package cn.ikangjia.practices.infra.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/11/20 10:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final Integer SUCCESS = 0;
    public static final Integer ERROR = -1;

    private Integer code;
    private T data;
    private String msg;


    public static <T> ResultVO<T> error(String msg) {
        return error(ERROR, msg);
    }

    public static <T> ResultVO<T> error(Integer code, String msg) {
        return error(code, null, msg);
    }

    public static <T> ResultVO<T> error(Integer code, T data, String msg) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setData(data);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static <T> ResultVO<T> success(T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(SUCCESS);
        resultVO.setData(data);
        resultVO.setMsg("操作成功");
        return resultVO;
    }

    public static <T> ResultVO<T> success() {
        return success(null);
    }
}
