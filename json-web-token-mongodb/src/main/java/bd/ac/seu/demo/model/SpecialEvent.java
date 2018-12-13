package bd.ac.seu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "SpecialEvent")
public class SpecialEvent {
    private String id;
    private String eventName;
    private String eventAddress;
    private String eventDescription;
    private String url;
    private String organizerName;
    private String eventDate;
    private String country;
    private String category;
    private Set<SubEvent> subEvents = new HashSet<>();

    public SpecialEvent(String eventName, String eventAddress, String eventDescription, String url, String organizerName, String eventDate, String country, String category, Set<SubEvent> subEvents) {
        this.eventName = eventName;
        this.eventAddress = eventAddress;
        this.eventDescription = eventDescription;
        this.url = url;
        this.organizerName = organizerName;
        this.eventDate = eventDate;
        this.country = country;
        this.category = category;
        this.subEvents = subEvents;
    }
}
