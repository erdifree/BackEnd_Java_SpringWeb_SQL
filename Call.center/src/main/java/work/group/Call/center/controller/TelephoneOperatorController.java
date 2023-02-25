package work.group.Call.center.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.PhoneCall;
import work.group.Call.center.entity.Subscriber;
import work.group.Call.center.entity.TelephoneOperator;
import work.group.Call.center.repository.PhoneCallRepository;
import work.group.Call.center.repository.SubscriberRepository;
import work.group.Call.center.repository.TelephoneOperatorRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/v1/TelephoneOperator")
public class TelephoneOperatorController {

    @Autowired
    TelephoneOperatorRepository telephoneOperatorRepository;
    @Autowired
    SubscriberRepository subscriberRepository;
    @Autowired
    PhoneCallRepository phoneCallRepository;

    @Autowired
SubscriberController subscriberController;
    @GetMapping
    public List<TelephoneOperator> getallTelephoneOperator() {
        return telephoneOperatorRepository.findAll();
    }

    @GetMapping("/{id}")
    public TelephoneOperator getOperatorById(@PathVariable Integer id) {
        return telephoneOperatorRepository.findById(id).get();
    }

    @PostMapping
    public TelephoneOperator create(@RequestBody TelephoneOperator telephoneOperator) {
        return telephoneOperatorRepository.save(telephoneOperator);
    }

    /* caso 1   Operatore  non Esiste
     * caso 2 operatore esiste i subscriber no- Creo il subscriber*/

    @PostMapping("/{id}")
    public TelephoneOperator create2(@PathVariable Integer id, @RequestBody Subscriber sub) {
        Optional<TelephoneOperator> resultOperator = telephoneOperatorRepository.findById(id);
        //Caso 1
        if (resultOperator.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "L'operatore  con id: " + id + "None è Presente");

        } else {
            //CASO 2
            TelephoneOperator newOperator = resultOperator.get();
            Optional<Subscriber> resultSubscriber = subscriberRepository.findById(sub.getId());
            if (resultSubscriber.isEmpty()) {
              /*  //Creo il nuovo Subscriber
                Subscriber subscriber = new Subscriber(sub);
                //Metto in relazione le chiamate con questo subscriber
                for (PhoneCall call : subscriber.getPhoneCallSet()) {
                    if (call.getId() != 0) { // SE NON CI SONO CALL QUI LANCIA NULLPOINTER
                        Optional<PhoneCall> resultCalls = phoneCallRepository.findById(call.getId());
                        if (resultCalls.isPresent()) {
                            PhoneCall phoneCall = resultCalls.get();
                            phoneCall.setStart(call.getStart());
                            phoneCall.setEnd(call.getEnd());
                            phoneCall.setRate(call.getRate());

                        }
                    } else {
                        call.setId_sub(subscriber);
                        subscriber.getPhoneCallSet().add(call);
                    }
                }
                subscriber.setPhoneCallSet(subscriber.getPhoneCallSet());
                Set<Subscriber> subscriberSet = new HashSet<>();
                Set<TelephoneOperator>operatorSet=new HashSet<>();
                operatorSet.add(newOperator);
                subscriber.setOperators(operatorSet);

                subscriberSet.add(subscriber);
                newOperator.setSubscribers(subscriberSet);
                telephoneOperatorRepository.save(newOperator);*/

            }
            Subscriber subscriber = new Subscriber(resultSubscriber.get());
            Set<TelephoneOperator>operatorSet=new HashSet<>();
            operatorSet.add(newOperator);
            subscriber.setOperators(operatorSet);
            Set<Subscriber> subscriberSet = new HashSet<>();
            subscriberSet.add(subscriber);
            newOperator.setSubscribers(subscriberSet);
            telephoneOperatorRepository.save(newOperator);
            return newOperator;
        }


    }
}
