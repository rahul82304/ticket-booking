package ua.epam.mishchenko.ticketbooking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.epam.mishchenko.ticketbooking.document.TicketDoc;

@Repository
public interface TicketDocRepository extends MongoRepository<TicketDoc, String> {
}
