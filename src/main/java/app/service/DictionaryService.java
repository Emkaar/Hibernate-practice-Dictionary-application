package app.service;

import models.Dictionary;
import models.Word;

import java.util.List;

public interface DictionaryService {
    void save(Dictionary dictionary);

    void delete(Dictionary dictionary);

    List<Dictionary> getAll();

    Dictionary getById(Integer id);
}
