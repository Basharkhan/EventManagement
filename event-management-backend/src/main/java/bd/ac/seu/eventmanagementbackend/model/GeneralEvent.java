package bd.ac.seu.eventmanagementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "GeneralEvent")
public class GeneralEvent {
    private String name;
    private String description;
    private String date;
}
