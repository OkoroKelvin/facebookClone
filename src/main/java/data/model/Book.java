package data.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class Book {
    private String id;
    private String title;
    private String authorId;
    private String content;
    private String description;
    private LocalDate publishedOn;
    private LocalDate startedReadingOn;
    private LocalDate finishedReadingOn;

    public Book(String title, String authorId, String description, String content, LocalDate publishedOn){
        this(title, authorId, publishedOn);
        this.content = content;
        this.description = description;
    }

    public Book(String title, String authorId, LocalDate publishedOn) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.authorId = authorId;
        this.publishedOn = publishedOn;
    }


}
