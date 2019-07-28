package br.edu.ifma.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifma.bookstore.controller.response.ResponseMessage;
import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.service.TagService;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseMessage<Page<Tag>> paginate(
            @RequestParam(defaultValue = "0") Integer page) {
        final PageRequest pageReq = PageRequest.of(page, 10, Sort.Direction.valueOf("ASC"), "tag");

        final Page<Tag> tags = tagService.paginate(pageReq);

        return ResponseMessage.ofContent(tags);
    }

}
