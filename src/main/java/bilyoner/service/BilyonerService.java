package bilyoner.service;


import bilyoner.document.Bilyoner;

import java.util.List;

public interface BilyonerService {

    Bilyoner save(Long id);

    Bilyoner getById(Long id);

    Bilyoner getMax();

    Bilyoner getMin();

    String delete(Long id);

    List<Bilyoner> getAll(Boolean orderType);

}
