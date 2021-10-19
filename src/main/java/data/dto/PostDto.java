package data.dto;

import data.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PostDto {
    private String userId;
    private String text;
    private String content;


    public PostDto(String userId, String text, String content){
        this.userId = userId;
        this.text = text;
        this.content = content;
    }

    public PostDto(String text, String content){
        this.text = text;
        this.content = content;
    }


    public static Post unpackDto(PostDto postDto){
        return new Post(postDto.getText(), postDto.getContent(), postDto.getUserId());
    }
}
