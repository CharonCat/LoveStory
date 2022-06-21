package com.crlclm.lovestory.enums;

/**
 * FileCategoryEnum
 *
 * @author CharonCat
 * @date 2022/6/11
 */
public enum FileCategoryEnum {
    //image: .jpg, .png; audio: .mp3, .acc; video: .mp4; file: other category
    FILE("file"), IMG("image"), AUDIO("audio"), VIDEO("video");

    private final String name;
    private FileCategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
