package ru.testproject.newsfeed.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import ru.testproject.newsfeed.dto.NewsDto;
import ru.testproject.newsfeed.model.News;

@Mapper(componentModel = "spring")
public interface NewsMapper {

    NewsMapper NEWS_MAPPER = Mappers.getMapper((NewsMapper.class));

    News mapFromDto(NewsDto dto);

    NewsDto mapToDto(News entity);

    void updateFromDto(NewsDto dto, @MappingTarget News entity);


}
