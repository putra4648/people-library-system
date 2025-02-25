package id.putra.peoplelibrarysystem.service;

import id.putra.peoplelibrarysystem.exception.UserException;
import io.quarkus.panache.common.Sort;

import java.util.List;

public interface BaseCrudService<Dto> {
    void save(Dto Dto) throws UserException;

    void update(Dto Dto);

    void delete(Dto Dto);

    Dto findOne(String query, Sort sort, Dto Dto);

    List<Dto> findAll(String query, Sort sort, Dto Dto);
}
