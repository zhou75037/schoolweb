package net.school.web.italker.push.bean.api.teacher;

import com.google.common.base.Strings;
import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.TeacherFollow;

public class TeacherFollowModel {
    @Expose
    private String ClassTeacherNo;
    @Expose
    private String teacherClassNo;

    public String getClassTeacherNo() {
        return ClassTeacherNo;
    }

    public void setClassTeacherNo(String classTeacherNo) {
        ClassTeacherNo = classTeacherNo;
    }

    public String getTeacherClassNo() {
        return teacherClassNo;
    }

    public void setTeacherClassNo(String teacherClassNo) {
        this.teacherClassNo = teacherClassNo;
    }

    public TeacherFollowModel(TeacherFollow teacherFollow) {
        ClassTeacherNo = teacherFollow.getClassTeacherNo();
        this.teacherClassNo = teacherFollow.getTeacherClassNo();
    }
    public static boolean check(TeacherFollowModel model) {
        // Model 不允许为null，
        // 并且只需要具有一个及其以上的参数即可
        return model != null
                && (!Strings.isNullOrEmpty(model.ClassTeacherNo) ||
                !Strings.isNullOrEmpty(model.teacherClassNo));
    }
}
