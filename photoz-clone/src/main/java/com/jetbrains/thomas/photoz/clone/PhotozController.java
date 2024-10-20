package com.jetbrains.thomas.photoz.clone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhotozController {

    List<Photo> photoList = List.of( new Photo("1", "photo1.jpg"));
    @GetMapping("/")
    public String HelloWorld()
    {
        return "Hello World";
    }

    @GetMapping("/photolist")
    public List Photos()
    {
        return photoList;
    }
}
