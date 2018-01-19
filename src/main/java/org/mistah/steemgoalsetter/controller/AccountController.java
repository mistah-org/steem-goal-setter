package org.mistah.steemgoalsetter.controller;

import javax.inject.Inject;

import org.mistah.steemgoalsetter.domain.Book;
import org.mistah.steemgoalsetter.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {

    final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Inject
    private BookService bookService;

    @Inject
    private MessageSource messageSource;

    /**
     * Retrieve the book with the specified id.
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String show(@PathVariable("username") String username, Model model) {
        logger.info("Username: " + username);

        Book book = bookService.findById(id);
        model.addAttribute("book", book);

        return "books/show";
    }

}
