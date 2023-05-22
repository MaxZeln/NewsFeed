package ru.testproject.newsfeed.mapper;

import java.io.IOException;
import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.testproject.newsfeed.dto.ImageDto;
import ru.testproject.newsfeed.model.Image;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T03:43:23+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public Image toImageEntity(MultipartFile file) throws IOException {
        if ( file == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.name( file.getName() );
        image.contentType( file.getContentType() );
        image.size( file.getSize() );
        byte[] bytes = file.getBytes();
        if ( bytes != null ) {
            image.bytes( Arrays.copyOf( bytes, bytes.length ) );
        }

        return image.build();
    }

    @Override
    public Image mapToEntity(ImageDto dto) {
        if ( dto == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.id( dto.getId() );
        image.name( dto.getName() );
        image.originalFileName( dto.getOriginalFileName() );
        image.contentType( dto.getContentType() );
        image.size( dto.getSize() );
        byte[] bytes = dto.getBytes();
        if ( bytes != null ) {
            image.bytes( Arrays.copyOf( bytes, bytes.length ) );
        }

        return image.build();
    }

    @Override
    public ImageDto mapToDto(Image entity) {
        if ( entity == null ) {
            return null;
        }

        ImageDto.ImageDtoBuilder imageDto = ImageDto.builder();

        imageDto.id( entity.getId() );
        imageDto.name( entity.getName() );
        imageDto.originalFileName( entity.getOriginalFileName() );
        imageDto.contentType( entity.getContentType() );
        imageDto.size( entity.getSize() );
        byte[] bytes = entity.getBytes();
        if ( bytes != null ) {
            imageDto.bytes( Arrays.copyOf( bytes, bytes.length ) );
        }

        return imageDto.build();
    }
}
