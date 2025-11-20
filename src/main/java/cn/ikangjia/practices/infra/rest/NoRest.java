package cn.ikangjia.practices.infra.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2025/11/20 10:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NoRest {
}
