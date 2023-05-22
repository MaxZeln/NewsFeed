package ru.testproject.newsfeed.model;

import javax.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq_news")
    @SequenceGenerator(name = "global_seq_news", sequenceName = "global_seq_news", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private LocalDateTime date;

    @OneToOne(cascade = {CascadeType.ALL})
    private Image image;

}
