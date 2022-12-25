package ru.qwonix.rentucha.api.entity;


import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private byte[]  attachment;

    @Column
    private String fileName;

    @Column(nullable = false)
    private String  mimeType;
}

