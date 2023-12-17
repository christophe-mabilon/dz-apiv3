package fr.dz.maconnerie.entities;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "homeText")
public class HomeTextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String title;
    @Column(length = 50000)
    private String content;
    private int position;
    private String align_text;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;


}