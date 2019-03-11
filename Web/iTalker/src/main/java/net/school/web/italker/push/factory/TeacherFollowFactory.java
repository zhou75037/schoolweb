package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.db.Classes;
import net.school.web.italker.push.bean.db.Teacher;
import net.school.web.italker.push.bean.db.TeacherFollow;
import net.school.web.italker.push.utils.Hib;

public class TeacherFollowFactory {
    public static TeacherFollow create(Teacher teacher, Classes classes) {
        TeacherFollow teacherFollow = new TeacherFollow(teacher.getId(),classes.getId());
        teacherFollow.setClasses(classes);
        teacherFollow.setTeacher(teacher);
        return Hib.query(session -> {
            session.save(teacherFollow);
            return teacherFollow;
        });
    }
}
