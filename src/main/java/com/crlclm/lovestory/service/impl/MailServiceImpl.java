package com.crlclm.lovestory.service.impl;

import com.crlclm.lovestory.bean.Mail;
import com.crlclm.lovestory.enums.FileCategoryEnum;
import com.crlclm.lovestory.service.MailService;
import com.crlclm.lovestory.utils.FileUploadUtils;
import com.crlclm.lovestory.utils.MailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MailServiceImpl
 *
 * @author CharonCat
 * @date 2022/6/10
 */
@Service
public class MailServiceImpl implements MailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MailServiceImpl.class);

    @Value("${spring.mail.username}")
    private String senderMailAddress;

    @Value("${path.resource}")
    private String RESOURCE_PATH;

    @Resource
    private MailUtils mailUtils;

    @Override
    public boolean sendMail(Mail mail) {
        mail.setFrom(senderMailAddress);
        return mailUtils.sendMail(mail, true);
    }

    @Override
    public boolean sendMailWithFile(Mail mail, ArrayList<MultipartFile> files) {
        HashMap<FileCategoryEnum, ArrayList<String>> fileCategoryMap = FileUploadUtils.uploadFiles(RESOURCE_PATH, files);
        mail.setFrom(senderMailAddress);

        mail.setFilePath(fileCategoryMap.get(FileCategoryEnum.FILE));
        mail.setRscPath(fileCategoryMap.get(FileCategoryEnum.IMG));
        return mailUtils.sendMail(mail, true);
    }
}
