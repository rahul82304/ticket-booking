package ua.epam.mishchenko.ticketbooking.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Objects;

@Document
public class UserAccountDoc {

    @Id
    private String userAccountId;
    private BigDecimal money;

    public String getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(String userAccountId) {
        this.userAccountId = userAccountId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccountDoc that = (UserAccountDoc) o;
        return Objects.equals(userAccountId, that.userAccountId) && Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAccountId, money);
    }

    @Override
    public String toString() {
        return "UserAccountDoc{" +
                "userAccountId='" + userAccountId + '\'' +
                ", money=" + money +
                '}';
    }
}
