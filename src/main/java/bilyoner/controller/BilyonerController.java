package bilyoner.controller;

import bilyoner.document.Bilyoner;
import bilyoner.service.BilyonerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BilyonerController {

    private final BilyonerService bilyonerService;

    @Autowired
    public BilyonerController(BilyonerService bilyonerService) {
        this.bilyonerService = bilyonerService;
    }

    @RequestMapping(value = "/save/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> save(@PathVariable Long id) {
        return ResponseEntity.ok(bilyonerService.save(id));
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(bilyonerService.getById(id));
    }

    @RequestMapping(value = "/getMax", method = RequestMethod.GET)
    public ResponseEntity<?> getMax() {
        return ResponseEntity.ok(bilyonerService.getMax());
    }

    @RequestMapping(value = "/getMin", method = RequestMethod.GET)
    public ResponseEntity<?> getMin() {
        return ResponseEntity.ok(bilyonerService.getMin());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(bilyonerService.delete(id));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(bilyonerService.getAll(true));
    }

    @RequestMapping(value = "/getAll/{type}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllWithOrderParameter(@PathVariable Boolean type) {
        return ResponseEntity.ok(bilyonerService.getAll(type));
    }
}
