package fr.dz.maconnerie.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "prestations")
public class PrestationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String prestationType;
    private String title;
    @Column(length = 50000)
    private String content;
    private int position;
    private String align_text;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

}
