package net.school.web.italker.push.bean.api.teacher;

import com.google.common.base.Strings;
import com.google.gson.annotations.Expose;

public class TeacherModel {
    // 科目
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
    public static boolean check(TeacherModel model) {
        return !(Strings.isNullOrEmpty(model.level)
                || Strings.isNullOrEmpty(model.project));
    }
}
