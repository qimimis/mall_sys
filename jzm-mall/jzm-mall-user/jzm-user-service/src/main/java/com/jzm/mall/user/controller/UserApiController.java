package com.jzm.mall.user.controller;

import com.jzm.mall.user.converter.UserAddressConverter;
import com.jzm.mall.user.dto.UserAddressDTO;
import com.jzm.mall.user.model.UserAddress;
import com.jzm.mall.user.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @Autowired
    private UserAddressService userAddressService;

    @Autowired
    UserAddressConverter userAddressConverter;

    /**
     * 获取用户地址
     * @param userId
     * @return
     */
    @GetMapping("inner/findUserAddressListByUserId/{userId}")
    public List<UserAddressDTO> findUserAddressListByUserId(@PathVariable("userId") String userId){
        List<UserAddress> userAddressListByUserId = userAddressService.findUserAddressListByUserId(userId);
        return userAddressConverter.userAddressPOs2DTOs(userAddressListByUserId);
    }

}
