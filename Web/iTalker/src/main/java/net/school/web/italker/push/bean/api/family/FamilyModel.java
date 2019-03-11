package net.school.web.italker.push.bean.api.family;

import com.google.gson.annotations.Expose;

public class FamilyModel {

    // 住址可为空
    @Expose
    private String address ;
    @Expose
    private String content ;

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
}
