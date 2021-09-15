package data.dto;

import data.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class PostDto {
    private String userId;
    private String text;
    private String content;


    public static Post unpackDto(PostDto postDto){
        return new Post(postDto.getText(), postDto.getContent(), postDto.getUserId());
    }
}
