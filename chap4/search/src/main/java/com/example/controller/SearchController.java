package com.example.controller;

import com.example.entity.Flight;
import com.example.model.SearchQuery;
import com.example.service.SearchService.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query) {
        return searchService.search(query);
    }
}
