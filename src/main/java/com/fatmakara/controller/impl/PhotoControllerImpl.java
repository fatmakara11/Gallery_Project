package com.fatmakara.controller.impl;

import com.fatmakara.controller.IPhotoController;
import com.fatmakara.entities.Photo;
import com.fatmakara.services.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest/api/photo")
public class PhotoControllerImpl implements IPhotoController {

    @Autowired
    private IPhotoService photoService;  //senin serviceye ihtiyacın var


    @PostMapping(path="/save")
    @Override
    public Photo savePhoto(@RequestBody Photo photo) {
        return photoService.savePhoto(photo) ;
    }
}
