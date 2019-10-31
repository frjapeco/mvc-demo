package fjpc.mvcdemo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Document
public class Customer {

    @Id
    private String id;

    private String firstName;

    private String secondName;

    private Integer age;

}
