package br.edu.ifma.dcomp.lpweb.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifma.dcomp.lpweb.bookstore.controller.response.ResponseMessage;
import br.edu.ifma.dcomp.lpweb.bookstore.model.Tag;
import br.edu.ifma.dcomp.lpweb.bookstore.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseMessage<List<Tag>> getAll() {
        var tags = tagService.findAll();

        final ResponseMessage<List<Tag>> response = new ResponseMessage<>();
        response.setContent(tags);

        return response;
    }

}
