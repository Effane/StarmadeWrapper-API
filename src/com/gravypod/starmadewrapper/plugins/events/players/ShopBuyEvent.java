package com.gravypod.starmadewrapper.plugins.events.players;

import com.gravypod.starmadewrapper.User;
import com.gravypod.starmadewrapper.plugins.events.Event;

public class ShopBuyEvent extends Event {

    private final int quantity;
    private final String item;
    private final User buyer;

    public ShopBuyEvent(int quantity, String item, User buyer) {
        this.quantity = quantity;
        this.item = item;
        this.buyer = buyer;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItem() {
        return item;
    }

    public User getBuyer() {
        return buyer;
    }
}
