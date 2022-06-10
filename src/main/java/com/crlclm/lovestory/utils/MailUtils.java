package com.crlclm.lovestory.utils;

import com.crlclm.lovestory.pojo.Mail;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * MailUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
@Component("mailutil")
public class MailUtils {
    @Value("${path.resource}")
    private String RESOURCE_PATH;


    @Value("${mail.username}")
    private String from;

    private static final Logger LOGGER = LoggerFactory.getLogger(MailUtils.class);

    @Resource
    private JavaMailSender javaMailSender;

    public void sendMail(Mail mail) {
        LOGGER.info("mail message : {}", mail.toString());

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), true);



            if (!mail.getFilePath().isEmpty()) {
                for (String filePath : mail.getFilePath()) {
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = file.getFilename();
                    if (!Strings.isBlank(fileName)) {
                        //添加附件，可多次调用该方法添加多个附件
                        helper.addAttachment(fileName, file);
                    }
                }
            }

            if (!mail.getRscPath().isEmpty()) {
                for (int rscId = 0; rscId < mail.getRscPath().size(); rscId++) {
                    FileSystemResource res = new FileSystemResource(new File(mail.getRscPath().get(rscId)));
                    //重复使用添加多个图片
                    helper.addInline(String.valueOf(rscId), res);
                }
            }

            javaMailSender.send(message);
            LOGGER.info("send success");
        } catch (MessagingException e) {
            LOGGER.error("send massage error", e);
        }
    }

    public void sendRandomCodeMail(Mail mail){
        String randomCode = VerifyUtils.randomCode();
        StringBuffer sb = new StringBuffer();
        sb.append("<h1>春日赖床联盟验证码</h1>")
                .append("<p style='color:#F00'>randomCode</p>");
//                .append("<p style='text-align:right'>右对齐</p>");
        mail.setContent(sb.toString());
        sendMail(mail);
    }

}