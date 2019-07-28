package br.edu.ifma.bookstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifma.bookstore.model.Tag;
import br.edu.ifma.bookstore.repository.TagRepository;

@Service
public class TagService {

    private final TagRepository tagRepository;

    private final CrudService<Tag, Integer> crudService;

    public TagService(TagRepository repository) {
        this.tagRepository = repository;
        this.crudService = new CrudService<>(repository);
    }

    public Page<Tag> paginate(Pageable page) {
        return crudService.paginate(page);
    }

    public Tag findBy(Integer id) {
        return crudService.findBy(id);
    }

    public List<Tag> findAllBy(List<Integer> tagIds) {
        return tagRepository.findAllById(tagIds);
    }

}
