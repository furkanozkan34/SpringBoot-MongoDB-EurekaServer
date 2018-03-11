package bilyoner.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Data
@AllArgsConstructor
@Document(collection = "bilyoner")
public class Bilyoner {

    @Id
    private Long id;

    private Date insertDate;




}
