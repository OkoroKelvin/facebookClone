package data.model;

import data.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Post {
    private String postId = UUID.randomUUID().toString();
    @NotNull
    private String text;
    @NotNull
    private String content;
    @NotNull
    private String userEmail;
    private LocalDateTime createdOn =  LocalDateTime.now();
    private LocalDateTime updatedOn=  LocalDateTime.now();
}
