package net.school.web.italker.push.bean.api.family;

import com.google.gson.annotations.Expose;

public class StudentFollowModel {
    @Expose
    private String parentId;
    @Expose
    private String alias;
    @Expose
    private String studentid;

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

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public StudentFollowModel(){}
}
