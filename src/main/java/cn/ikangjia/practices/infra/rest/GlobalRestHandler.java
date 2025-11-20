package cn.ikangjia.practices.infra.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/11/20 10:23
 */
@RestControllerAdvice
public class GlobalRestHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        // 1. 若返回值本身就是 ResultVO，不拦截
        if (returnType.getParameterType() == ResultVO.class) {
            return false;
        }

        // 2. 带 NoRest 注解，不拦截
        if (returnType.hasMethodAnnotation(NoRest.class)) {
            return false;
        }

        // 3. 可添加其他拦截逻辑

        // 其它均拦截
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        // String 类型需额外处理，直接返回会导致序列化异常，需手动转为 JSON
        if (body instanceof String) {

            // 此处可替换为 Fastjson 实现
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(ResultVO.success(body));
            } catch (JsonProcessingException e) {
                throw new RuntimeException("String 响应格式转换失败", e);
            }
        }

        return ResultVO.success(body);
    }
}
