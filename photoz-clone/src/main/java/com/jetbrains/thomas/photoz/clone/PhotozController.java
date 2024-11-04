package com.jetbrains.thomas.photoz.clone;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class PhotozController {

    HashMap<String, Photo> photoMap = new HashMap<>(){{put("1", new Photo("1", "photo1.jpg"));}};
    @GetMapping("/")
    public String HelloWorld()
    {
        return "Hello World";
    }

    @GetMapping("/photolist")
    public Collection<Photo> get()
    {
        return photoMap.values();
    }

    @GetMapping("/photolist/{id}")
    public Photo get(@PathVariable String id)
    {
        Photo photo = photoMap.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photolist/{id}")
    public void removePhoto(@PathVariable String id)
    {
        Photo photo = photoMap.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        photoMap.remove(id);
    }
}
