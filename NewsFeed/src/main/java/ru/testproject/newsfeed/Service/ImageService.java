package ru.testproject.newsfeed.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.testproject.newsfeed.dto.ImageDto;
import ru.testproject.newsfeed.mapper.ImageMapper;
import ru.testproject.newsfeed.model.Image;
import ru.testproject.newsfeed.repository.ImageRepository;

import java.io.IOException;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void save(MultipartFile image) throws IOException {
        Image entity = ImageMapper.IMAGE_MAPPER.toImageEntity(image);
        imageRepository.save(entity);
    }

    public ImageDto getImage(String id) {
        return ImageMapper.IMAGE_MAPPER.mapToDto(imageRepository.findById(id).get());
    }

    public void delete(String id) {
        Image image = imageRepository.getReferenceById(id);
        imageRepository.delete(image);
    }

}

