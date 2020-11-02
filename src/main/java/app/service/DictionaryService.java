package app.service;

import app.models.Dictionary;
import app.models.User;
import app.models.Word;

import java.util.List;

public interface DictionaryService {
    void save(Dictionary dictionary);

    void delete(Dictionary dictionary);

    List<Dictionary> getAll();

    Dictionary getById(Integer id);

    void addWord(Word word, int id);

    List<Word> getAllWords(int id);
}
