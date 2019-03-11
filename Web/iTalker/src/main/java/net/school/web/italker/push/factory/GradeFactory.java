package net.school.web.italker.push.factory;

import com.google.common.base.Strings;
import net.school.web.italker.push.bean.api.grade.GradeModel;
import net.school.web.italker.push.bean.db.Grade;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.utils.Hib;

import java.util.List;


public class GradeFactory {
    /**
     * 创建成绩
     * @return
     */
    public static Grade createGrade(GradeModel model, String studentid) {
        Student student= StudentFactory.findById(studentid);
        if (student==null)
            return null;
        Grade grade = new Grade();
        grade.setContent(model.getContent());
        grade.setGrade(model.getGrade());
        grade.setPorject(model.getPorject());
        grade.setStudentgradeId(studentid);
        grade.setStudent(student);
        // 数据库存储
        return Hib.query(session -> {
            session.save(grade);
            return grade;
        });
    }

    // 根据学生id获取学生成绩
    public static List<Grade> getGrades(String studentGradeId) {
        if (Strings.isNullOrEmpty(studentGradeId))
            studentGradeId = ""; // 保证不能为null的情况，减少后面的一下判断和额外的错误
        final String id = studentGradeId;
        return Hib.query(session -> {
            // 查询的条件：name忽略大小写，并且使用like（模糊）查询；
            // 头像和描述必须完善才能查询到
            return (List<Grade>) session.createQuery("from Grade where studentgradeId=:id")
                    .setParameter("id", id)
                    .setMaxResults(20) // 至多20条
                    .list();
        });
    }

    public static List<Grade> findGrades(String studentid) {

        return Hib.query(session -> {
            return (List<Grade>) session.createQuery("from Grade where studentgradeId  =:studentid order by content")
                    .setParameter("studentid", studentid)
                    .setMaxResults(20) // 至多20条
                    .list();
        });
    }
}