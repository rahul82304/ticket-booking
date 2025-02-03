package ua.epam.mishchenko.ticketbooking.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ua.epam.mishchenko.ticketbooking.model.UserAccount;

import java.util.Objects;

@Document
public class UserDoc {

    @Id
    private String userId;
    private String name;
    private String email;
    private UserAccountDoc userAccountDoc;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAccountDoc getUserAccountDoc() {
        return userAccountDoc;
    }

    public void setUserAccountDoc(UserAccountDoc userAccountDoc) {
        this.userAccountDoc = userAccountDoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDoc userDoc = (UserDoc) o;
        return Objects.equals(userId, userDoc.userId) && Objects.equals(name, userDoc.name) && Objects.equals(email, userDoc.email) && Objects.equals(userAccountDoc, userDoc.userAccountDoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, userAccountDoc);
    }

    @Override
    public String toString() {
        return "UserDoc{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userAccountDoc=" + userAccountDoc +
                '}';
    }
}
