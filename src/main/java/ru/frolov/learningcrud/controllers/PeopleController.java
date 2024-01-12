package ru.frolov.learningcrud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.frolov.learningcrud.dao.PersonDAO;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model){
        // Получим всех людей из DAO и передадим в представление

        // под ключем "people" будет лежать список людей
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        // Получим 1 человека по id из DAO и передадим в представление

        // Под ключем "person" ляжет конкретный человек, которого мы нашли по id
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}
