package ua.epam.mishchenko.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;
import ua.epam.mishchenko.ticketbooking.utils.EventSummary;

import java.util.List;

@Service
public class TicketDocAggregationService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<EventSummary> getEventSummary() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group("eventDoc.title")
                        .count().as("totalTickets")
                        .sum("ticketPrice").as("totalRevenue")
        );

        AggregationResults<EventSummary> results = mongoTemplate.aggregate(aggregation, "ticketDoc", EventSummary.class);
        return results.getMappedResults();
    }


}
