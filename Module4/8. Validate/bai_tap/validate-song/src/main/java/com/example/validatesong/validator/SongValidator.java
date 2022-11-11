package com.example.validatesong.validator;

import com.example.validatesong.model.Song;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Song.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String name = song.getName();
        if(!name.matches("^[a-z0-9]*$")){
            errors.rejectValue("name", "name.matches");
        }
        String author = song.getAuthor();
        if(!author.matches("^[a-z0-9]*$")){
            errors.rejectValue("author", "author.matches");
        }
        String type = song.getType();
        if(!type.matches("^[a-z0-9//,]*$")){
            errors.rejectValue("type", "name.matches");
        }
    }
}
