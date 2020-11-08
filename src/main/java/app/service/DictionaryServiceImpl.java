package app.service;

import app.repo.RepositoryI;
import models.Dictionary;
import models.Word;

import java.util.List;


public class DictionaryServiceImpl implements DictionaryService{

    RepositoryI repository;


    public DictionaryServiceImpl(RepositoryI repository) {
        this.repository = repository;
    }

    @Override
    public void save(Dictionary dictionary) {
        if(dictionary!=null) {
            List<Dictionary> users = repository.getAll();
            if(!users.isEmpty()) {
                Dictionary lastDictionary = users.get(users.size() - 1);
                dictionary.setId(lastDictionary.getId()+1);
                repository.save(dictionary);
            }
        }
    }

    @Override
    public void delete(Dictionary dictionary) {
        if(dictionary!=null) {
            repository.delete(dictionary);
        }
    }

    @Override
    public List<Dictionary> getAll() {
        return repository.getAll();
    }

    @Override
    public Dictionary getById(Integer id) {
        return (Dictionary) repository.getById(id);
    }
}
