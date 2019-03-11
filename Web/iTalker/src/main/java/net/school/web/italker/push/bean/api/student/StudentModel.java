package net.school.web.italker.push.bean.api.student;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Student;

public class StudentModel {
    @Expose
    private String name;
    @Expose
    private int sex ;
    @Expose
    private String  identity;
    @Expose
    private String  portrait;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public StudentModel(Student student) {
        this.name = student.getName();
        this.sex = student.getSex();
        this.identity=student.getIdentity();
        this.portrait=student.getPortrait();

    }
}
