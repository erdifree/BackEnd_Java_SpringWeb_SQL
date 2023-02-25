package work.group.Call.center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.Subscriber;
import work.group.Call.center.repository.PhoneCallRepository;
import work.group.Call.center.repository.SubscriberRepository;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/subscribers")

public class SubscriberController {
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private PhoneCallRepository phoneCallRepository;



    @DeleteMapping("/delite/{id}")
    public List<Subscriber> delite(@PathVariable Integer id){

        Optional<Subscriber> result= subscriberRepository.findById(id);
        if (!result.isEmpty()) {
            System.out.println(result.get());
            subscriberRepository.delete( result.get());

        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return subscriberRepository.findAll();
    }

    @GetMapping
    public List<Subscriber> getall(){
        return subscriberRepository.findAll();
    }
    @GetMapping("/{id}")
    public Subscriber getByID(@PathVariable Integer id){
        Optional<Subscriber> result= subscriberRepository.findById(id);
        if (result.isPresent()) {
            return  result.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/sub")
    public Subscriber getBY(@RequestParam(name = "nome", required = false) String nome) {
     Subscriber subscriber= subscriberRepository.findByFirstnameEqualsIgnoreCase(nome);
    return subscriber;
    }

    @PostMapping
    public Subscriber createe(@RequestBody Subscriber sub){
        return subscriberRepository.save(sub);

    }

    /*endpoint create and update*/
    @PutMapping("/{id}")
    public Subscriber update(@RequestBody Subscriber sub,@PathVariable Integer id){
        Optional<Subscriber> result= subscriberRepository.findById(id);

        if (result.isPresent()) {

              sub.setId(id);
            Subscriber newSub=result.get();
            newSub.setCretid(sub.getCretid());
            return subscriberRepository.save(newSub);
        }else{
           throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE) ;
        }
    }

    /*endpoint create and update*/


    @GetMapping("/subcall/{id}")
    public Subscriber getByIDsubcall(@PathVariable Integer id){
      Optional<Subscriber>  result= subscriberRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND );
        }
    }
   @PostMapping("/subcall")
    public Subscriber create(@RequestBody Subscriber sub){
    /* Set<PhoneCall> phoneCallSet= sub.getPhoneCallSet();
     for(PhoneCall p: phoneCallSet){
         p.setId_sub(sub);

     }*/
       Subscriber subscriber= subscriberRepository.save(sub);
      return subscriber;
   }


/*@PutMapping("/{id}") // STO ASSUMENDO CHE NEL CORPO DELLA RICHIESTA CI SIANO DELLE CALL
public Subscriber update2( @RequestBody Subscriber sub, @PathVariable Integer id) {
    Optional<Subscriber> subOpt = subscriberRepository.findById(id);
    if (subOpt.isPresent()) {
        Subscriber subscriber = subOpt.get();
        subscriber.setCretid(sub.getCretid());
        subscriber.setFirstname(sub.getFirstname());
        subscriber.setLastname(sub.getLastname());
        subscriber.setCityofbirth(sub.getCityofbirth());
        subscriber.setDob(sub.getDob());
        for (PhoneCall call : sub.getPhoneCallSet()) {
            if (call.getId() != 0) { // SE NON CI SONO CALL QUI LANCIA NULLPOINTER
                Optional<PhoneCall> callOpt = phoneCallRepository.findById(call.getId());
                if (callOpt.isPresent()) {
                    PhoneCall phoneCall = callOpt.get();
                    phoneCall.setStart(call.getStart());
                    phoneCall.setEnd(call.getEnd());
                    phoneCall.setRate(call.getRate());
                }
            } else {
                call.setId_sub(subscriber);
                subscriber.getPhoneCallSet().add(call);
            }
        }
        return subscriberRepository.save(subscriber);
    } else {
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED);
    }
}*/
@DeleteMapping("/subcall/{id}")
    public boolean deliteSubscriber(@PathVariable Integer id){
        Optional<Subscriber> result= subscriberRepository.findById(id);
    if( result.isEmpty()) {
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Subscriber with id: "+id+"NOT FOUND");

    }  else{
        Subscriber subscriber=result.get();
       subscriberRepository.delete( subscriber);
       return true;
    }

}

}


