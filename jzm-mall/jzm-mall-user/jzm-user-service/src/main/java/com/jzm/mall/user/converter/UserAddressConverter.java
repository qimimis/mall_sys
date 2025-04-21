package com.jzm.mall.user.converter;


import com.jzm.mall.user.dto.UserAddressDTO;
import com.jzm.mall.user.model.UserAddress;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserAddressConverter {
    UserAddressDTO userAddressPO2DTO(UserAddress userAddress);
    List<UserAddressDTO> userAddressPOs2DTOs(List<UserAddress> userAddresses);

}
