package ru.testproject.newsfeed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testproject.newsfeed.model.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, String> {
}
