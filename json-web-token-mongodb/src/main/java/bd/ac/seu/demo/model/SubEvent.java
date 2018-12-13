package bd.ac.seu.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubEvent {
    private String name;
    private String startTime;
    private String endTime;
    private boolean selected;
}
