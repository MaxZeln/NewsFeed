package ru.testproject.newsfeed.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.testproject.newsfeed.Service.ImageService;
import ru.testproject.newsfeed.Service.NewsService;
import ru.testproject.newsfeed.dto.ImageDto;
import ru.testproject.newsfeed.dto.NewsDto;
import ru.testproject.newsfeed.model.SelectedSize;
import java.util.Optional;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsFeedController {

    private final ImageService imageService;
    private final NewsService newsService;


    @Autowired
    public NewsFeedController(ImageService imageService,
                              NewsService newsService) {
        this.imageService = imageService;
        this.newsService = newsService;
    }

    @GetMapping("/all")
    public List<NewsDto> getNews() {
        return newsService.getAll();
    }
    @GetMapping("/{newsId}")
    public NewsDto getOneNews(@PathVariable(name = "newsId")  int newsId) {

        return newsService.findById(newsId);
    }




    @GetMapping("/pagewithfixedsize")
    public ModelAndView getPages(@ModelAttribute("selectedSize") SelectedSize selectedSize) {

        Page<NewsDto> page = newsService.findAll(0, selectedSize.getPageSize());



        ModelAndView modelAndView = new ModelAndView("news/feed");
        modelAndView.addObject("page", page);
        return modelAndView;

    }

    @PostMapping("/pagewithfixedsize")
    public ModelAndView selectPages(@ModelAttribute("selectedSize") SelectedSize selectedSize) {

        System.out.println(selectedSize.getPageSize());

        Page<NewsDto> page = newsService.findAll(0, selectedSize.getPageSize());

        ModelAndView modelAndView = new ModelAndView("news/feed");
        modelAndView.addObject("page", page);
        return modelAndView;

    }

    @GetMapping("/newpost")
    public ModelAndView createNews(@ModelAttribute("newsDto") NewsDto newsDto) {
        ModelAndView modelAndView = new ModelAndView("/news/newpost");
        return modelAndView;
    }

    @PostMapping("/newpost")
    public ModelAndView createNews(@ModelAttribute("newsDto") NewsDto newsDto,
                                   @RequestParam MultipartFile file) throws IOException {

        ImageDto imageDto = new ImageDto();

        if (file.getSize() != 0) {
            imageDto.setName(file.getName());
            imageDto.setOriginalFileName(file.getOriginalFilename());
            imageDto.setContentType(file.getContentType());
            imageDto.setSize(file.getSize());
            imageDto.setBytes(file.getBytes());
        }

        System.out.println(imageDto);

        newsDto.setDate(LocalDateTime.now());

        newsDto.setImage(imageDto);

        System.out.println(newsDto);

        newsService.create(newsDto);

        ModelAndView success = new ModelAndView("/news/success");
        return success;

    }

    @PutMapping(value = "/update/{newsId}")
    public NewsDto updateNews(@PathVariable(value = "newsId") int userId,
                              @RequestBody NewsDto newsDto) {
        return newsService.update(newsDto);
    }

    @DeleteMapping("/{newsId}")
    public void delete(@PathVariable(name = "newsId") int newsId) {
        newsService.delete(newsId);
    }

}
