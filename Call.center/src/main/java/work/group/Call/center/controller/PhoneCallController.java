package work.group.Call.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.PhoneCall;
import work.group.Call.center.entity.Subscriber;
import work.group.Call.center.repository.PhoneCallRepository;
import work.group.Call.center.repository.SubscriberRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/phonecalls")
@CrossOrigin
public class PhoneCallController {
    @Autowired
    private PhoneCallRepository phoneCallRepository;
    @Autowired
    private SubscriberRepository subscriberRepository;

    @GetMapping
    public List<PhoneCall> getAll(){

        return phoneCallRepository.findAll();
    }

    @GetMapping("/{id}")
    public PhoneCall getById(@PathVariable Integer id){
        Optional<PhoneCall> result= phoneCallRepository.findById(id);
        if (result.isPresent()) {
            return  result.get();

        }else{
            return null;
        }
    }

    @PostMapping("/{id}")
    public PhoneCall create(@RequestBody PhoneCall pc, @PathVariable Integer id) {
        Optional<Subscriber> result = subscriberRepository.findById(id);
        if (result.isPresent()) {
            pc.setId_sub(result.get());
            return phoneCallRepository.save(pc);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,("subscriber not found")) ;
        }
    }
}
