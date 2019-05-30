package br.edu.ifma.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional(readOnly = true)
    public Page<Tag> paginate(Pageable pageReq) {
        return tagRepository.findAll(pageReq);
    }

    @Transactional(readOnly = true)
    public Tag findBy(Integer id) {
        return tagRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllBy(List<Integer> tagIds) {
        return tagRepository.findAllById(tagIds);
    }

}
