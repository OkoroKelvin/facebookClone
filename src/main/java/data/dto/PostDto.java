package data.dto;

import data.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    private String title;
    private String content;


    public static Post unpackDto(PostDto postDto){
        return new Post(postDto.getTitle(), postDto.getContent());
    }
}
