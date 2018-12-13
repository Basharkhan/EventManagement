package bd.ac.seu.demo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "GeneralEvent")
public class GeneralEvent {
    private String id;
    private String name;
    private String description;
    private String date;
    private String url;

    public GeneralEvent(String name, String description, String date, String url) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.url = url;
    }
}
