package fr.dz.maconnerie.entities;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @Size(max = 1000)
    private String text;

    private int position;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;
}