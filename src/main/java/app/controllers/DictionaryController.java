package app.controllers;

import app.models.Dictionary;
import app.models.Word;
import app.service.DictionaryServiceImpl;
import app.service.WordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DictionaryController {
//    DictionaryServiceImpl dictionaryService;
//    WordServiceImpl wordService;
//    @Autowired
//    public DictionaryController(DictionaryServiceImpl dictionaryService, WordServiceImpl wordService) {
//        this.dictionaryService = dictionaryService;
//        this.wordService = wordService;
//    }
//
//
//    @GetMapping(path = "/dictionaries")
//    public String getDictionaries(Model model){
//        model.addAttribute("dictionaryList", dictionaryService.getAll());
//        return "dictionaries";
//    }
//
//    @PostMapping(path = "/dictionaries/add")
//    public String addNewDictionary(@RequestParam(name = "learning_language") String language){
//        dictionaryService.save(new Dictionary(language));
//        return "redirect:/dictionaries";
//    }
//
//    @GetMapping(path = "/wordlist")
//    public String getDictionary(@RequestParam(value ="id", required = false) int dictionaryId, Model model){
//        model.addAttribute("wordsList",dictionaryService.getAllWords(dictionaryId));
//        return "wordlist";
//    }
//
//    @PostMapping(path = "/wordlist/add")
//    public String addWord(@RequestParam(name = "original") String original,
//                          @RequestParam(name = "translate") String translate, RedirectAttributes attributes){
//        Word word = new Word(0, 0, original,translate, 0);
//        dictionaryService.addWord(word, 0);
//        attributes.addAttribute("id", 0);
//        return "redirect:/wordlist";
//    }
}
