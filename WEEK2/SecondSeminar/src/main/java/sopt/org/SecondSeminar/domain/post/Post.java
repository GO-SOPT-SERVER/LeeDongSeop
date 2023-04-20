package sopt.org.SecondSeminar.domain.post;

import lombok.Getter;

@Getter
public class Post {

    private Long id;

    private String title;

    private String writing;

    private int like;

    private int dislike;


    public Post(String title, String writing, int like, int dislike) {
        this.title = title;
        this.writing = writing;
        this.like = like;
        this.dislike = dislike;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + this.id + "\n" +
                "title: " + this.title + "\n" +
                "writing: " + this.writing + "\n" +
                "like: " + this.like + "\n" +
                "dislike: " + this.dislike;
    }
}
