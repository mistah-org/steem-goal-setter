package org.mistah.steemgoalsetter.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FollowersController {

    final Logger logger = LoggerFactory.getLogger(FollowersController.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // true passed to CustomDateEditor constructor means convert empty String to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new MultiDateFormat(), true));
    }

    /**
     * Retrieve the book with the specified id.
     */
    @RequestMapping(value = "/{username}/followers", method = RequestMethod.GET)
    public String show(
    		@PathVariable("username") String username,
    		Model model) {
        return "account/followers";
    }

    /**
     * Retrieve the book with the specified id.
     */
    @RequestMapping(value = "/{username}/followers", method = RequestMethod.POST)
    public String update(
    		@PathVariable("username") String username,
    		@RequestParam(value="startDate", required=false) Date fromDate,
    		@RequestParam(value="endDate", required=false) Date toDate,
    		Model model) {
        logger.info("from: " + fromDate);
        logger.info("to: " + toDate);

        return "account/followers";
    }


}
