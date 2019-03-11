package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.api.teacher.TeacherModel;
import net.school.web.italker.push.bean.db.Teacher;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.utils.Hib;

import java.util.List;

public class TeacherFactory {
    public static Teacher create(TeacherModel model, User creator) {
        return Hib.query(session -> {
            Teacher teacher = new Teacher(model,creator);
            session.save(teacher);
            return teacher;
        });
    }
    public static Teacher findByteacherid(String teacherId) {
        return Hib.query(session -> (Teacher) session
                .createQuery("from Teacher where teacherId=:teacherId")
                .setParameter("teacherId",teacherId )
                .uniqueResult());


    }
    public static List<Teacher> findByteacherides(String teacherId) {

        return Hib.query(session -> {
            return (List<Teacher>) session.createQuery("from Teacher where teacherId  =:teacherId")
                    .setParameter("teacherId", teacherId)
                    .setMaxResults(20) // 至多20条
                    .list();

        });
    }

}
