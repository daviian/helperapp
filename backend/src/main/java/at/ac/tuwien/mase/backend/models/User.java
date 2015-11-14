package at.ac.tuwien.mase.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by xvinci on 11/14/15.
 */
@Document
public class User {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;
    private String logo;
    private boolean verified;
    private String phone;
    private String password;
    private boolean creator;

    @DBRef
    private List<Request> requests;

    @DBRef
    private List<Fullfillment> fullfillments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public List<Fullfillment> getFullfillments() {
        return fullfillments;
    }

    public void setFullfillments(List<Fullfillment> fullfillments) {
        this.fullfillments = fullfillments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }
}