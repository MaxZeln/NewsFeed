package ru.testproject.newsfeed.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewsDto {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime date;

    private ImageDto image;

    @Override
    public String toString() {
        return "NewsDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", image=" + image +
                '}';
    }

}
