package com.crlclm.lovestory.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Mail
 *
 * @author CharonCat
 * @date 2022/6/9
 */
@Data
public class Mail {
    private String to;
    private String subject;
    private String content;
    private List<String> filePath;
    private List<String> rscPath;

    {
        this.to = "";
        this.subject = "";
        this.content = "";
        this.filePath = new ArrayList<>();
        this.rscPath = new ArrayList<>();
    }

}
