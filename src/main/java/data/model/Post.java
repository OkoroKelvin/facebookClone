package data.model;

import data.dto.UserDto;
import data.repository.Storable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Post implements Storable {
    private String postId = UUID.randomUUID().toString();
    @NotNull
    private String title;
    @NotNull
    private String content;
    private String userId;
    private LocalDateTime createdOn =  LocalDateTime.now();
    private LocalDateTime updatedOn=  LocalDateTime.now();

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getId() {
        return postId;
    }
}
