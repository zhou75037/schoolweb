package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Classes;

public class ClassesCard {
    @Expose
    private String id;
    @Expose
    private String classNo;
    @Expose
    private String className;
    @Expose
    private String school;

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public ClassesCard(Classes classes){
        this.classNo = classes.getClassNo();
        this.className = classes.getClassName();
        this.school = classes.getSchool();
        this.id=classes.getId();
    }

}
