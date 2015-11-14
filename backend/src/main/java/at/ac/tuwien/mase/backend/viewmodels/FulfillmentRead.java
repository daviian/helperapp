package at.ac.tuwien.mase.backend.viewmodels;

import at.ac.tuwien.mase.backend.models.Fulfillment;

import java.util.Date;

/**
 * Created by lobmaier on 14.11.2015.
 */
public class FulfillmentRead {
    private long id;
    private Date until;
    private int amount;
    private RequestRead request;

    public FulfillmentRead(Fulfillment fulfillment) {
        this.id = fulfillment.getId();
        this.until = fulfillment.getUntil();
        this.amount = fulfillment.getAmount();
    }

    public FulfillmentRead(Fulfillment fulfillment, boolean deep) {
        this(fulfillment);
        if (deep) {
            this.request = new RequestRead(fulfillment.getRequest());
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getUntil() {
        return until;
    }

    public void setUntil(Date until) {
        this.until = until;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public RequestRead getRequest() {
        return request;
    }

    public void setRequest(RequestRead request) {
        this.request = request;
    }
}