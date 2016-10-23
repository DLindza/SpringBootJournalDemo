package lindsay.devon.spring.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller; // allows you to say this is the Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lindsay.devon.spring.domain.Journal;
import lindsay.devon.spring.repository.JournalRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by devon on 10/20/16.
 */
@Controller // part of the Spring MVC
/// this will send back all of the journal entries
public class JournalController {

    @Autowired /// instantiates the JournalRepository
    JournalRepository repo;

    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody List<Journal> getJournal() {
        return repo.findAll();
    }

    @RequestMapping("/") /// makes this method the handler for every request in the default route /
    public String index(Model model) { // this is where the MODEL part of MVC
        model.addAttribute("journal", repo.findAll());
        return "index";


    }

}
//Model is given an attribute named journal
// the journal attribute has a value that is the result of calling the repo findAll()
// the findAll() is built in as a result of extending the JpaRepository interface
// findAll() returns all the entries from the database
// the return will be the name of the page "index" - which tells the MVC
// to look for the index.html in the templates folder