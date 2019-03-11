package net.school.web.italker.push.bean.api.classes;

import com.google.common.base.Strings;
import com.google.gson.annotations.Expose;

public class ClassesModel {
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

    public static boolean check(ClassesModel model) {
        return !(Strings.isNullOrEmpty(model.className)
                || Strings.isNullOrEmpty(model.classNo)
                || Strings.isNullOrEmpty(model.school));
    }


}
