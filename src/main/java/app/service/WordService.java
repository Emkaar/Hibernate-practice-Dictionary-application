package app.service;

import models.Word;

import java.util.List;

public interface WordService {
    void save(Word word);

    void delete(Word word);

    List<Word> getAll();

    Word getById(Integer id);

}
