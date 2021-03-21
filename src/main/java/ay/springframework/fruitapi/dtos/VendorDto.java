package ay.springframework.fruitapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by aliyussef on 21/03/2021
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendorDto {
    private String name;
    private String vendorUrl;
}
