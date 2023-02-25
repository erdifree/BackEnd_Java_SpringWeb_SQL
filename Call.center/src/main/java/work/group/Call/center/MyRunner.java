package work.group.Call.center;




import org.aspectj.bridge.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import work.group.Call.center.entity.PhoneCall;
import work.group.Call.center.entity.Subscriber;
import work.group.Call.center.repository.PhoneCallRepository;
import work.group.Call.center.repository.SubscriberRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
public class MyRunner implements CommandLineRunner {

   // private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);
    @Autowired
    private SubscriberRepository subscriberRepository;
    @Autowired
    private PhoneCallRepository phoneCallRepository;

    public MyRunner(SubscriberRepository repository) {
        this.subscriberRepository = repository;
    }


    @Override
    public void run(String... args) throws Exception {

        /*boolean SELECTALL = false;
        boolean DELETE = false;
        boolean INSERT =true;
        boolean UPDATE=true;

        System.out.println("\n\n----------- Begin Log ------------");
        if (SELECTALL) {
            System.out.println("SELECT ALL\n");
            Iterable<Subscriber> listArtist = subscriberRepository.findAll();

            for (Iterator element = listArtist.iterator(); element.hasNext(); ) {
                Subscriber subscriber = (Subscriber) element.next();
                //logger.info("{}", artist);
                System.out.println(subscriber);
            }
        }
        /*EndPoint
        if (DELETE) {
            System.out.println("___________________________\n");
            System.out.println("DELETE BY ID\n");
            Scanner scanner = new Scanner(System.in);
            try {
                Optional<Subscriber> subscriber = subscriberRepository.findById(17);
                if (!subscriber.isEmpty()) {
                    Subscriber sub = subscriber.get();
                    subscriberRepository.delete(sub);
                } else {
                    throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "non trovato");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        /*EndPoint   Insert
        if (INSERT) {
            LocalDate dob= LocalDate.of(1998,12,20);
            Subscriber subscriber = new Subscriber("Lufy", "Rubber", dob, "Roma", 500.00);
            System.out.println(subscriberRepository.save(subscriber));
        }
         */

        /*EndPoint update
        if (UPDATE) {
            System.out.println("UPDATE BY ID\n");
            Optional <Subscriber> result = subscriberRepository.findById(4);
            if (result.isPresent()) {

                LocalDate dob= LocalDate.of(2000,12,20);

                Subscriber subscriber = new Subscriber("Lufy", "Rubber", dob, "Roma", 2200.00);
                subscriber.setId(4);
                Subscriber newSub=result.get();
                newSub.setCretid(subscriber.getCretid());
                subscriberRepository.save(newSub);
                subscriber.setId(4);
                System.out.println(subscriberRepository.save(subscriber));
            }else{
                throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE) ;
            }
        }
*/

        //////////////////////////////
   /*    Subscriber subscriber= new Subscriber();//Creo il subscriber da inserire

        subscriber.setFirstname("Givanni");
        subscriber.setLastname("Lantti");
        subscriber.setCityofbirth("Roma");
        subscriber.setDob(LocalDate.of(1985,02,20));
        subscriber.setCretid(200.00);
        Subscriber result = subscriberRepository.save(subscriber);//con subscriberRepository e il metodo save inserisco il subscriber  in DB
        System.out.println(result);

        PhoneCall phoneCalls = new PhoneCall();
        phoneCalls.setEnd(LocalDateTime.parse("2022-02-01T00:40:30"));
        phoneCalls.setStart(LocalDateTime.parse("2022-02-01T00:20:30"));
        phoneCalls.setRate(0.50);
        phoneCalls.setId_sub(subscriber);//assegno fk alla call che corrisponde al subscriber per la relazione manyToOne  phonecall-subscriber
        PhoneCall pc = phoneCallRepository.save(phoneCalls);
        System.out.println(pc);*/
/////////////////////////////////////////////////////////////////////
    }
}