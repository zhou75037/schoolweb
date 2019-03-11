package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;

public class FamilyFollowCard {
    @Expose
    private String parentId;
    @Expose
    private String alias;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
