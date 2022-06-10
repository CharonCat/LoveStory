package com.crlclm.lovestory.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * FileUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
public class FileUtils {
    @Value("${path.resource}")
    public String RESOURCE_PATH;
}
