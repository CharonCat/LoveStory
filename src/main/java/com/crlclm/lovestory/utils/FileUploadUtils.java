package com.crlclm.lovestory.utils;

import com.crlclm.lovestory.enums.FileCategoryEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.metadata.HttpHeaders;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.metadata.TikaMetadataKeys;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * FileUtils
 *
 * @author CharonCat
 * @date 2022/6/9
 */
public class FileUploadUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadUtils.class);

    public static HashMap<FileCategoryEnum, ArrayList<String>> uploadFiles(String resourcePath, ArrayList<MultipartFile> files) {
        LOGGER.info("resource:{}, file num:{}", resourcePath, files.size());
        int fail = 0;
        ArrayList<String> otherFiles = new ArrayList<>();
        ArrayList<String> imgFiles = new ArrayList<>();
        for (MultipartFile file : files) {
            String fileType = getMimeType(file);
            try {
                if (fileType.matches("image/.*")) {
                    imgFiles.add(upload(file, resourcePath, FileCategoryEnum.IMG));
                } else if (fileType.matches("video/.*")) {
                    otherFiles.add(upload(file, resourcePath, FileCategoryEnum.VIDEO));
                } else if (fileType.matches("audio/.*")) {
                    otherFiles.add(upload(file, resourcePath, FileCategoryEnum.AUDIO));
                } else {
                    otherFiles.add(upload(file, resourcePath, FileCategoryEnum.FILE));
                }
            } catch (IOException e) {
                LOGGER.error("upload error", e);
                fail++;
            }
        }

        LOGGER.info("upload file num: {}, success: {}, fail: {}", files.size(), files.size() - fail, fail);
        HashMap<FileCategoryEnum, ArrayList<String>> fileCategoryMap = new HashMap<>(13);
        fileCategoryMap.put(FileCategoryEnum.FILE, otherFiles);
        fileCategoryMap.put(FileCategoryEnum.IMG, imgFiles);
        return fileCategoryMap;
    }

    private static String upload(MultipartFile file, String resourcePath, FileCategoryEnum fileCategoryEnum) throws IOException {
        File fileDir = new File(resourcePath, fileCategoryEnum.getName());

        if (!fileDir.exists() && !fileDir.mkdirs()) {
            LOGGER.error("mkdir fail, path: {}", fileDir.getPath());
        }

        String originalFilename = file.getOriginalFilename();

        String fileSuffix = "." + fileCategoryEnum.getName();
        if (!StringUtils.isBlank(originalFilename)) {
            fileSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String fileName = CommonsUtils.getUUID() + fileSuffix;
        File files = new File(fileDir, fileName);
        LOGGER.info("upload file name: {},  target: {}", fileName, fileDir);
        //上传
        file.transferTo(files);
        return fileName;
    }

    public static String getMimeType(MultipartFile file) {
        AutoDetectParser parser = new AutoDetectParser();
        parser.setParsers(new HashMap<>());
        Metadata metadata = new Metadata();
        metadata.add(TikaMetadataKeys.RESOURCE_NAME_KEY, file.getName());
        try (InputStream stream = file.getInputStream()) {
            parser.parse(stream, new DefaultHandler(), metadata, new ParseContext());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        String mimeType = metadata.get(HttpHeaders.CONTENT_TYPE);
        LOGGER.info("file: {},  mime type: {}", file.getOriginalFilename(), mimeType);
        return mimeType;
    }
}
