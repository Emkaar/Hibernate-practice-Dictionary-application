package app.service;

import app.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordServiceImpl {
//    WordRepository wordRepository;
//    @Autowired
//    public WordServiceImpl(WordRepository wordRepository) {
//        this.wordRepository = wordRepository;
//    }
//
//    @Override
//    public void save(Word word) {
//        if(word!=null) {
//            List<Word> words = wordRepository.getAll();
//            if(!words.isEmpty()) {
//                Word lastWord = words.get(words.size() - 1);
//                word.setId(lastWord.getId()+1);
//                wordRepository.save(word);
//            }
//        }
//    }
//
//    @Override
//    public void delete(Word word) {
//        if(word!=null) {
//            wordRepository.delete(word);
//        }
//    }
//
//    @Override
//    public List<Word> getAll() {
//        return wordRepository.getAll();
//    }
//
//    @Override
//    public Word getById(Integer id) {
//        if(id!=null) {
//            return wordRepository.getById(id);
//        }
//        return null;
//    }
}
