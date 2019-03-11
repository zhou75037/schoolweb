package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Task;

public class TaskCard {
    @Expose
    private String id;
    @Expose
    private String content;
    //1:作业，0：考试
    @Expose
    private int type;
    @Expose
    private String studentTaskId;
    @Expose
    private int grade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public TaskCard(Task task) {
        this.id = task.getId();
        this.content = task.getContent();
        this.type = task.getType();
        this.studentTaskId = task.getStudentTaskId();
        this.grade = task.getGrade();
    }
}
