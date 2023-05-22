package ru.testproject.newsfeed.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;
import ru.testproject.newsfeed.dto.ImageDto;
import ru.testproject.newsfeed.model.Image;

import java.io.IOException;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageMapper IMAGE_MAPPER = Mappers.getMapper(ImageMapper.class);

    Image toImageEntity(MultipartFile file) throws IOException;

    Image mapToEntity(ImageDto dto);

    ImageDto mapToDto(Image entity);

}
