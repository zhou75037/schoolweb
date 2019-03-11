package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.Teacher;

public class TeacherCard {
    // 科目
    @Expose
    private String id;
    @Expose
    private String  project;

    // 级别
    @Expose
    private String  level;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public TeacherCard(Teacher teacher){
        this.level=teacher.getLevel();
        this.project=teacher.getProject();
        this.id=teacher.getId();
    }
}
