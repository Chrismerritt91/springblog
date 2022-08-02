package com.example.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String image;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    public PostImage() {
    }

    public PostImage(long id, String image, Post post) {
        this.id = id;
        this.image = image;
        this.post = post;
    }

    public PostImage(String image, Post post) {
        this.image = image;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
