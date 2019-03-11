package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.api.family.StudentFollowModel;
import net.school.web.italker.push.bean.db.Family;
import net.school.web.italker.push.bean.db.StudentFollow;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.utils.Hib;

public class FamilyFollowFactory {
    public static StudentFollow create(Family family, Student student, StudentFollowModel studentFollowModel) {
        StudentFollow studentFollow = new StudentFollow();
        studentFollow.setFamily(family);
        studentFollow.setStudent(student);
        studentFollow.setFamily(family);
        studentFollow.setAlias(studentFollowModel.getAlias());
        studentFollow.setParentId(studentFollowModel.getParentId());
        studentFollow.setStudentfollowId(studentFollowModel.getStudentid());
        return Hib.query(session -> {
            session.save(studentFollow);
            return studentFollow;
        });
    }
}
