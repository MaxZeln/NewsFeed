package ru.testproject.newsfeed.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.testproject.newsfeed.model.News;


public interface NewsPageRepository extends JpaRepository<News, Long> {
    Page<News> findAll(Pageable pageable);
}
