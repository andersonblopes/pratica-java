package com.digitalis.wsterceiro.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalis.wsterceiro.rest.model.EventResult;
import com.digitalis.wsterceiro.rest.repository.EventResultRepository;

@RestController
@RequestMapping("/")
public class TerceiroController {

    private static final Logger LOG = LoggerFactory.getLogger(TerceiroController.class);

    @Autowired
    private EventResultRepository repository;

    @GetMapping("/test")
    public EventResult response()
    {
        EventResult resposta = repository.response();
        LOG.info(resposta.toString());

        return resposta;
    }

}
