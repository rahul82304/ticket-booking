package ua.epam.mishchenko.ticketbooking.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Document
public class EventDoc {

    @Id
    private String eventId;
    private String title;
    private Date date;
    private BigDecimal ticketPrice;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDoc eventDoc = (EventDoc) o;
        return Objects.equals(eventId, eventDoc.eventId) && Objects.equals(title, eventDoc.title) && Objects.equals(date, eventDoc.date) && Objects.equals(ticketPrice, eventDoc.ticketPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, title, date, ticketPrice);
    }

    @Override
    public String toString() {
        return "EventDoc{" +
                "eventId='" + eventId + '\'' +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
