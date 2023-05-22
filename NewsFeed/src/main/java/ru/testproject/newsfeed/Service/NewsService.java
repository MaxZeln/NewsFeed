package ru.testproject.newsfeed.Service;

import javax.transaction.Transactional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import ru.testproject.newsfeed.dto.NewsDto;
import ru.testproject.newsfeed.mapper.NewsMapper;
import ru.testproject.newsfeed.model.News;
import ru.testproject.newsfeed.repository.NewsPageRepository;
import ru.testproject.newsfeed.repository.NewsRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class NewsService {

    private final NewsRepository newsRepository;


    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<NewsDto> getAll() {
        return newsRepository.findAll().stream()
                .map(NewsMapper.NEWS_MAPPER::mapToDto)
                .collect(Collectors.toList());
    }

    public NewsDto findById(long id) {
        return NewsMapper.NEWS_MAPPER.mapToDto(newsRepository.getReferenceById(id));
    }

    public Page<NewsDto> findAll(int page, int size) {

        Page<News> entities = newsRepository.findAll(PageRequest.of(page, size));
        Page<NewsDto> dtos = entities.map(new Function<News, NewsDto>() {
                                              @Override
                                              public NewsDto apply(News news) {
                                                  NewsDto newsDto = NewsMapper.NEWS_MAPPER.mapToDto(news);
                                                  return newsDto;
                                              }
                                          });
        return dtos;

    }

    @Transactional
    public NewsDto create(NewsDto newsDto) {
        News entity = NewsMapper.NEWS_MAPPER.mapFromDto(newsDto);
        newsRepository.save(entity);
        return NewsMapper.NEWS_MAPPER.mapToDto(entity);
    }

    @Transactional
    public NewsDto update(NewsDto newsDto) {
        News entity = NewsMapper.NEWS_MAPPER.mapFromDto(newsDto);
        NewsMapper.NEWS_MAPPER.updateFromDto(newsDto, entity);
        return NewsMapper.NEWS_MAPPER.mapToDto(newsRepository.save(entity));
    }

    public void delete(long id) {
        News entity = newsRepository.getReferenceById(id);
        newsRepository.delete(entity);
    }

}

