package com.lopes.springcloudmysql.controller;

import com.lopes.springcloudmysql.model.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {

    @Autowired
    private ContactRepository repository;

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

}
