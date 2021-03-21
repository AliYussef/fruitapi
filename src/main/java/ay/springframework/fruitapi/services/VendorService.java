package ay.springframework.fruitapi.services;

import ay.springframework.fruitapi.dtos.VendorDto;

import java.util.List;

/**
 * Created by aliyussef on 21/03/2021
 */
public interface VendorService {
    VendorDto getVendorById(Long id);

    List<VendorDto> getAllVendors();

    VendorDto createNewVendor(VendorDto vendorDto);

    VendorDto updateVendor(Long id, VendorDto vendorDto);

    void deleteVendorById(Long id);
}
