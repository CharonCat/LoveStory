package com.crlclm.lovestory.utils;

import com.crlclm.lovestory.bean.Mail;
import com.crlclm.lovestory.enums.RandomCodeUsageEnum;
import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;

/**
 * MailUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
@Component("mailutil")
public class MailUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailUtils.class);

    @Resource
    private JavaMailSender javaMailSender;

    @Resource
    private TemplateEngine templateEngine;

    public boolean sendMail(Mail mail, boolean isHTML) {
        LOGGER.info("mail message : {}", mail.toString());

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mail.getFrom());
            helper.setTo(mail.getTo());
            helper.setSubject(mail.getSubject());
            helper.setText(mail.getContent(), isHTML);

            if (!mail.getFilePath().isEmpty()) {
                for (String filePath : mail.getFilePath()) {
                    FileSystemResource file = new FileSystemResource(new File(filePath));
                    String fileName = file.getFilename();
                    if (!Strings.isBlank(fileName)) {
                        // add files
                        helper.addAttachment(fileName, file);
                    }
                }
            }

            if (!mail.getRscPath().isEmpty()) {
                for (int rscId = 0; rscId < mail.getRscPath().size(); rscId++) {
                    FileSystemResource res = new FileSystemResource(new File(mail.getRscPath().get(rscId)));
                    // add images
                    helper.addInline(String.valueOf(rscId), res);
                }
            }

            javaMailSender.send(message);
            LOGGER.info("send success");
            return true;
        } catch (MessagingException e) {
            LOGGER.error("send massage error", e);
            return false;
        }
    }

    public boolean sendRandomCodeMail(Mail mail, RandomCodeUsageEnum usage){
        HashMap<String, Object> variableMap = new HashMap<>();
        String randomCode = VerifyUtils.randomCode();
        LOGGER.info("action: {}, random code: {}", usage.getName(), randomCode);
        variableMap.put("randomCode", randomCode);
        variableMap.put("actionName", usage.getName());

        Context context = new Context();
        context.setVariables(variableMap);

        String content = templateEngine.process("mail", context);
        mail.setContent(content);

        return sendMail(mail, true);
    }

}