package com.crlclm.lovestory.utils;

import com.crlclm.lovestory.bean.Mail;
import com.crlclm.lovestory.enums.RandomCodeUsageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * MailUtilsTest
 *
 * @author CharonCat
 * @date 2022/6/21
 */
@SpringBootTest
public class MailUtilsTest {
    @Resource
    private MailUtils mailUtils;

    @Value("${spring.mail.username}")
    private String senderMailAddress;

    @Test
    public void sendRandomCodeMailTest() {
        Mail mail = new Mail();
        mail.setFrom(senderMailAddress);
        mail.setTo("charoncat@163.com");
        mail.setSubject("春日赖床联盟");
        Assertions.assertTrue(mailUtils.sendRandomCodeMail(mail, RandomCodeUsageEnum.SIGN_UP));
    }
}
