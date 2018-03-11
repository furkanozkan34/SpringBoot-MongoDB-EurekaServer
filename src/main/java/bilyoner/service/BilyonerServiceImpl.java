package bilyoner.service;

import bilyoner.base.ServiceExceptions;
import bilyoner.document.Bilyoner;
import bilyoner.repository.BilyonerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BilyonerServiceImpl implements BilyonerService {

    private final BilyonerRepository bilyonerRepository;

    @Autowired
    public BilyonerServiceImpl(BilyonerRepository bilyonerRepository) {
        this.bilyonerRepository = bilyonerRepository;
    }

    @Override
    public Bilyoner save(Long id) {
        log.debug("Saving id : " + id);
        Optional<Bilyoner> optionalBilyoner = bilyonerRepository.findById(id);
        optionalBilyoner.ifPresent(u -> {
            throw new ServiceExceptions("This id already exist.");
        });
        return bilyonerRepository.save(new Bilyoner(id, new Date()));
    }

    @Override
    public Bilyoner getById(Long id) {
        log.debug("Request id : " + id);
        Bilyoner bilyoner = bilyonerRepository.findById(id)
                .orElseThrow(() -> new ServiceExceptions("Data not found"));
        return bilyoner;
    }

    @Override
    public Bilyoner getMax() {
        return bilyonerRepository.findFirstByOrderByIdDesc();
    }

    @Override
    public Bilyoner getMin() {
        return bilyonerRepository.findFirstByOrderById();
    }

    @Override
    public String delete(Long id) {
        log.debug("Delete request id : " + id);
        Bilyoner bilyoner = bilyonerRepository.findById(id)
                .orElseThrow(() -> new ServiceExceptions("Data not found"));
        bilyonerRepository.delete(bilyoner);
        return "Deleting success";
    }

    @Override
    public List<Bilyoner> getAll(Boolean orderType) {
        log.debug("Order Parameter : " + orderType);
        if (orderType)
            return bilyonerRepository.findAllByOrderById();
        else
            return bilyonerRepository.findAllByOrderByIdDesc();
    }
}
