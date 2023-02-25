package work.group.Call.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.Layout;
import work.group.Call.center.entity.Subscriber;
import work.group.Call.center.repository.LayoutRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api1/layout")
@CrossOrigin
public class LayoutController {

    @Autowired
    LayoutRepository layoutRepository;

    @GetMapping
    public List<Layout> getall(){
       List<Layout> resposne= layoutRepository.findAll();
    return resposne;
    }


    @PutMapping("/{chiave}")
    public Layout update(@RequestBody Layout layout, @PathVariable String chiave){
        Optional<Layout> result= Optional.ofNullable(layoutRepository.findByChiaveEqualsIgnoreCase(chiave));
        if (result.isPresent()) {
            layout.setChiave(chiave);
         Layout newLayout= result.get();
            newLayout.setValore(layout.getValore());
            return layoutRepository.save(newLayout);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE) ;
        }
    }
}



