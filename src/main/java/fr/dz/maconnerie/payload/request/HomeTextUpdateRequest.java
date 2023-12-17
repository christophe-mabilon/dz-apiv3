package fr.dz.maconnerie.payload.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class HomeTextUpdateRequest {
    private Long id;
    private String title;
    private String content;
    private Integer position;
    private String alignText;
    private MultipartFile imageData;
}