package ru.testproject.newsfeed.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.newsfeed.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    Page<News> findAll(Pageable pageable);
}
