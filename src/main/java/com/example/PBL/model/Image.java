package com.example.PBL.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Post_Images")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
