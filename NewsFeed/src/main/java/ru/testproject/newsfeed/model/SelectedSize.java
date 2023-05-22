package ru.testproject.newsfeed.model;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
public class SelectedSize {

    private int pageSize = 20;

    @ModelAttribute(value = "selectedSize")
    public SelectedSize newSelectedSize()
    {
        return new SelectedSize();
    }

}
