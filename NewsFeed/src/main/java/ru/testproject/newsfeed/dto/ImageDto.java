package ru.testproject.newsfeed.dto;

import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {

    private String id;

    private String name;

    private String originalFileName;

    private String contentType;

    private Long size;

    private byte[] bytes;

    @Override
    public String toString() {
        return "ImageDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
//                ", bytes=" + Arrays.toString(bytes) +
                '}';
    }

}
