package com.example.PBL.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Post_Images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36)
    private String id;

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for url
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // Getter and Setter for post
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
