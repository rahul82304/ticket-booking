package ua.epam.mishchenko.ticketbooking.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.epam.mishchenko.ticketbooking.document.EventDoc;
import ua.epam.mishchenko.ticketbooking.document.TicketDoc;
import ua.epam.mishchenko.ticketbooking.document.UserAccountDoc;
import ua.epam.mishchenko.ticketbooking.document.UserDoc;
import ua.epam.mishchenko.ticketbooking.model.*;
import ua.epam.mishchenko.ticketbooking.repository.TicketDocRepository;
import ua.epam.mishchenko.ticketbooking.repository.TicketRepository;

import javax.annotation.PostConstruct;
import javax.jws.soap.SOAPBinding;
import java.util.List;
import java.util.Map;

@Component
public class DataMigration {


    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketDocRepository ticketDocRepository;

    @PostConstruct
    public void migrateData() {

        List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();

        for (Ticket ticket : tickets) {

            String ticketId = ticket.getId().toString();
            Event event = ticket.getEvent();
            User user = ticket.getUser();
            Category category = ticket.getCategory();
            Integer place = ticket.getPlace();

            EventDoc eventDoc = convertEventToEventDoc(event);
            UserDoc userDoc = convertUserToUserDoc(user);

            TicketDoc ticketDoc = new TicketDoc();
            ticketDoc.setId(ticketId);
            ticketDoc.setCategory(category);
            ticketDoc.setUser(userDoc);
            ticketDoc.setEvent(eventDoc);
            ticketDoc.setPlace(place);

            ticketDocRepository.save(ticketDoc);
        }
    }

    private EventDoc convertEventToEventDoc(Event event){
        EventDoc eventDoc = new EventDoc();
        eventDoc.setEventId(event.getId().toString());
        eventDoc.setTitle(event.getTitle());
        eventDoc.setDate(event.getDate());
        eventDoc.setTicketPrice(event.getTicketPrice());

        return eventDoc;
    }

    private UserDoc convertUserToUserDoc(User user){
        UserDoc userDoc = new UserDoc();
        userDoc.setUserId(user.getId().toString());
        userDoc.setEmail(user.getEmail());
        userDoc.setName(user.getName());
        userDoc.setUserAccountDoc(convertUserAccountToUserAccountDoc(user.getUserAccount()));

        return userDoc;
    }

    private UserAccountDoc convertUserAccountToUserAccountDoc(UserAccount userAccount){

        UserAccountDoc userAccountDoc = new UserAccountDoc();
        userAccountDoc.setUserAccountId(userAccount.getId().toString());
        userAccountDoc.setMoney(userAccount.getMoney());

        return userAccountDoc;
    }
}
