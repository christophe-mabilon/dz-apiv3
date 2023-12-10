package fr.dz.maconnerie.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String b64Image;
    @ManyToOne
    @JoinColumn(name = "home_text_id")
    private HomeTextEntity homeText;
    @ManyToOne
    @JoinColumn(name = "prestation_id")
    private HomeTextEntity prestation;
    @ManyToOne
    @JoinColumn(name = "realisation_id")
    private HomeTextEntity realisation;

}
