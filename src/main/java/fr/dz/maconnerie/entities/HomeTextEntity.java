package fr.dz.maconnerie.entities;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "homeText")
public class HomeTextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;
    private String content;
    private String footer;


    private int position;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

}