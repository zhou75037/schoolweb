package net.school.web.italker.push.bean.api.grade;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Grade;

public class GradeModel {
    @Expose
    private int grade;
    @Expose
    private String porject;
    @Expose
    private String content;

    public GradeModel(Grade grade) {
        this.grade = grade.getGrade();
        this.porject = grade.getPorject();
        this.content = grade.getContent();

    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPorject() {
        return porject;
    }

    public void setPorject(String porject) {
        this.porject = porject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
