package net.school.web.italker.push.bean.card;

import com.google.gson.annotations.Expose;
import net.school.web.italker.push.bean.db.TeacherFollow;

public class TeacherFollowCard {
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

    public TeacherFollowCard(TeacherFollow teacherFollow) {
        ClassTeacherNo = teacherFollow.getClassTeacherNo();
        this.teacherClassNo = teacherFollow.getTeacherClassNo();
    }
    public TeacherFollowCard(){}
}
