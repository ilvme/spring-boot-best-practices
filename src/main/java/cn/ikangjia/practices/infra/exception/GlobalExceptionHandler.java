package cn.ikangjia.practices.infra.exception;

import cn.ikangjia.practices.infra.rest.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/11/20 11:16
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 可继续添加特定类型异常或自定义异常处理

    /**
     * 全局异常处理，承接 Exception.class，为兜底方案
     *
     * @param e 异常
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public ResultVO<Void> handleException(Exception e) {
        String message = e.getMessage();

        log.error("[GlobalExceptionHandler]：{}", message);

        return ResultVO.error(e.getMessage());
    }
}