package com.fatmakara.services.impl;

import com.fatmakara.entities.Photo;
import com.fatmakara.repository.PhotoRepository;
import com.fatmakara.services.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
//IPhotoService içinde tanımlanmış olan soyut (abstract) metodları burada somut hale getirecek
public class PhotoServiceImpl  implements IPhotoService {

    //repositıry ye erişmemiz gerekiyor
    @Autowired
    private PhotoRepository photoRepository;




    @Override
    public Photo savePhoto(Photo photo) {
       return photoRepository.save(photo);

    }
    //IPhotoService (Interface) → Sözleşme gibi çalışır. Ne yapılacağını belirtir (örneğin: savePhoto(), deletePhoto() gibi).
    //
    //PhotoServiceImpl (Implementation) → Bu arayüzde belirtilen işlemleri nasıl yapacağını içerir. Yani işin gerçek kodu buraya yazılır.
}
