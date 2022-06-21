package com.crlclm.lovestory.controller;

import com.crlclm.lovestory.bean.Mail;
import com.crlclm.lovestory.config.ResourceConfig;
import com.crlclm.lovestory.service.MailService;
import com.crlclm.lovestory.utils.CommonsUtils;
import com.crlclm.lovestory.utils.FileUploadUtils;
import com.crlclm.lovestory.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * MailController
 *
 * @author CharonCat
 * @date 2022/6/10
 */
@RestController("/mail")
public class MailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);

    @Resource
    private MailService mailService;

    @PostMapping("/send")
    public String sendMail(Mail mail) {
        LOGGER.info("send mail: {}", mail);

        if (!mailService.sendMail(mail)) {
            return ResultUtils.success("send mail success").toString();
        }

        return ResultUtils.fail("", "").toString();
    }

    @PostMapping("/sendfile")
    public String sendMailWithFile(Mail mail, @RequestParam("uploadFile") ArrayList<MultipartFile> files) {
        LOGGER.info("send mail: {}", mail);

        if (!mailService.sendMailWithFile(mail, files)) {
            return ResultUtils.success("send mail success").toString();
        }

        return ResultUtils.fail("", "").toString();
    }
}
