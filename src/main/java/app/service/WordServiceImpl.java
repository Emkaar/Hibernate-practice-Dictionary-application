package app.service;


import app.repo.WordRepositoryImpl;
import models.Word;

import java.util.List;

public class WordServiceImpl implements WordService{
    WordRepositoryImpl wordRepository;

    public WordServiceImpl(WordRepositoryImpl wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void save(Word word) {
        if(word!=null) {
            List<Word> words = wordRepository.getAll();
            if(!words.isEmpty()) {
                Word lastWord = words.get(words.size() - 1);
                word.setId(lastWord.getId()+1);
                wordRepository.save(word);
            }
        }
    }

    @Override
    public void delete(Word word) {
        if(word!=null) {
            wordRepository.delete(word);
        }
    }

    @Override
    public List<Word> getAll() {
        return wordRepository.getAll();
    }

    @Override
    public Word getById(Integer id) {
        if(id!=null) {
            return wordRepository.getById(id);
        }
        return null;
    }
}
