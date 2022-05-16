package com.example.shopservice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ShopController {
    ShopDelegateService shopServiceDelegate;

    @RequestMapping(value = "/getshopdetails/{shopName}", method = RequestMethod.GET)
    public String getProducts(@PathVariable("shopName") String shopName) {
        return shopServiceDelegate.getDataFromProductService(shopName);
    }
}
