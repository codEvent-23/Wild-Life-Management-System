package entity;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity("animal")
public class Animal {

    @Id
    private ObjectId id;
    private String species;
    private String common_name;
    private String scientific_name;
    private String gender;
    private Integer average_life_time;
    private Double average_weight;
    private String region;
    private String conservation_status;
    private String reproduction;
    private String color;
    private String markings;
    private String habitat;
    private String behavior;
    private String dietary_preferences;
    private String location;
    private String additional_details;
    private List<byte[]> images;

}
