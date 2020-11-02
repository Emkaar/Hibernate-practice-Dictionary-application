package app.service;

import app.repo.RepositoryI;
import org.springframework.stereotype.Component;

@Component
public class DictionaryServiceImpl{

    RepositoryI repository;

//    @Autowired
//    public DictionaryServiceImpl(Repository repository) {
//        this.repository = repository;
//    }
//
//    @Override
//    public void save(Dictionary dictionary) {
//        if(dictionary!=null) {
//            List<Dictionary> users = repository.getAll();
//            if(!users.isEmpty()) {
//                Dictionary lastDictionary = users.get(users.size() - 1);
//                dictionary.setId(lastDictionary.getId()+1);
//                repository.save(dictionary);
//            }
//        }
//    }
//
//    @Override
//    public void delete(Dictionary dictionary) {
//        if(dictionary!=null) {
//            repository.delete(dictionary);
//        }
//    }
//
//    @Override
//    public List<Dictionary> getAll() {
//        return repository.getAll();
//    }
//
//    @Override
//    public Dictionary getById(Integer id) {
//        return repository.getById(id);
//    }
//
//    @Override
//    public void addWord(Word word, int id) {
//        repository.addWord(word, id);
//    }
//
//    @Override
//    public List<Word> getAllWords(int id) {
//        return repository.getById(id).getWordList();
//    }
}
