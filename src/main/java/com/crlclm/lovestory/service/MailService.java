package com.crlclm.lovestory.service;

import com.crlclm.lovestory.bean.Mail;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * MailService
 *
 * @author CharonCat
 * @date 2022/6/10
 */
public interface MailService {
    boolean sendMail(Mail mail);

    boolean sendMailWithFile(Mail mail, ArrayList<MultipartFile> files);
}
