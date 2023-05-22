package ru.testproject.newsfeed.mapper;

import java.util.Arrays;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.testproject.newsfeed.dto.ImageDto;
import ru.testproject.newsfeed.dto.NewsDto;
import ru.testproject.newsfeed.model.Image;
import ru.testproject.newsfeed.model.News;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-23T05:32:48+0700",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News mapFromDto(NewsDto dto) {
        if ( dto == null ) {
            return null;
        }

        News.NewsBuilder news = News.builder();

        news.id( dto.getId() );
        news.title( dto.getTitle() );
        news.content( dto.getContent() );
        news.date( dto.getDate() );
        news.image( imageDtoToImage( dto.getImage() ) );

        return news.build();
    }

    @Override
    public NewsDto mapToDto(News entity) {
        if ( entity == null ) {
            return null;
        }

        NewsDto.NewsDtoBuilder newsDto = NewsDto.builder();

        newsDto.id( entity.getId() );
        newsDto.title( entity.getTitle() );
        newsDto.content( entity.getContent() );
        newsDto.date( entity.getDate() );
        newsDto.image( imageToImageDto( entity.getImage() ) );

        return newsDto.build();
    }

    @Override
    public void updateFromDto(NewsDto dto, News entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setTitle( dto.getTitle() );
        entity.setContent( dto.getContent() );
        entity.setDate( dto.getDate() );
        if ( dto.getImage() != null ) {
            if ( entity.getImage() == null ) {
                entity.setImage( Image.builder().build() );
            }
            imageDtoToImage1( dto.getImage(), entity.getImage() );
        }
        else {
            entity.setImage( null );
        }
    }

    protected Image imageDtoToImage(ImageDto imageDto) {
        if ( imageDto == null ) {
            return null;
        }

        Image.ImageBuilder image = Image.builder();

        image.id( imageDto.getId() );
        image.name( imageDto.getName() );
        image.originalFileName( imageDto.getOriginalFileName() );
        image.contentType( imageDto.getContentType() );
        image.size( imageDto.getSize() );
        byte[] bytes = imageDto.getBytes();
        if ( bytes != null ) {
            image.bytes( Arrays.copyOf( bytes, bytes.length ) );
        }

        return image.build();
    }

    protected ImageDto imageToImageDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDto.ImageDtoBuilder imageDto = ImageDto.builder();

        imageDto.id( image.getId() );
        imageDto.name( image.getName() );
        imageDto.originalFileName( image.getOriginalFileName() );
        imageDto.contentType( image.getContentType() );
        imageDto.size( image.getSize() );
        byte[] bytes = image.getBytes();
        if ( bytes != null ) {
            imageDto.bytes( Arrays.copyOf( bytes, bytes.length ) );
        }

        return imageDto.build();
    }

    protected void imageDtoToImage1(ImageDto imageDto, Image mappingTarget) {
        if ( imageDto == null ) {
            return;
        }

        mappingTarget.setId( imageDto.getId() );
        mappingTarget.setName( imageDto.getName() );
        mappingTarget.setOriginalFileName( imageDto.getOriginalFileName() );
        mappingTarget.setContentType( imageDto.getContentType() );
        mappingTarget.setSize( imageDto.getSize() );
        byte[] bytes = imageDto.getBytes();
        if ( bytes != null ) {
            mappingTarget.setBytes( Arrays.copyOf( bytes, bytes.length ) );
        }
        else {
            mappingTarget.setBytes( null );
        }
    }
}
