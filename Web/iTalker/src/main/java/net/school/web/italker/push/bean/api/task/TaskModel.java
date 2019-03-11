package net.school.web.italker.push.bean.api.task;

import com.google.gson.annotations.Expose;

public class TaskModel {

    @Expose
    private String content;
    //1:作业，0：考试
    @Expose
    private int type;
    @Expose
    private String studentTaskId;
    @Expose
    private int grade;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStudentTaskId() {
        return studentTaskId;
    }

    public void setStudentTaskId(String studentTaskId) {
        this.studentTaskId = studentTaskId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
