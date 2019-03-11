package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Family;

public class FamilyCard {
    @Expose
    private String id;
    @Expose
    private String address;
    @Expose
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public FamilyCard(Family card) {
        this.id = card.getId();
        this.address = card.getAddress();
        this.content = card.getContent();
    }
}
