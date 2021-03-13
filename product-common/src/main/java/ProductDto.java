import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long Id;
    private String name;
    private String description;
    private Long groupId;
    private String groupName;
}
