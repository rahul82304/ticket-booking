package ua.epam.mishchenko.ticketbooking.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import ua.epam.mishchenko.ticketbooking.model.Category;
import java.util.Objects;

/**
 * The type Ticket.
 */
@Document
public class TicketDoc {

    @Id
    private String id;
    private EventDoc event;
    private UserDoc user;
    private Integer place;
    @Field("category")
    private Category category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EventDoc getEvent() {
        return event;
    }

    public void setEvent(EventDoc event) {
        this.event = event;
    }

    public UserDoc getUser() {
        return user;
    }

    public void setUser(UserDoc user) {
        this.user = user;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDoc ticketDoc = (TicketDoc) o;
        return Objects.equals(id, ticketDoc.id) && Objects.equals(event, ticketDoc.event) && Objects.equals(user, ticketDoc.user) && Objects.equals(place, ticketDoc.place) && category == ticketDoc.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, event, user, place, category);
    }

    @Override
    public String toString() {
        return "TicketDoc{" +
                "id='" + id + '\'' +
                ", event=" + event +
                ", user=" + user +
                ", place=" + place +
                ", category=" + category +
                '}';
    }
}
