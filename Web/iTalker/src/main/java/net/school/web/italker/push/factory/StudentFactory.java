package net.school.web.italker.push.factory;

import com.google.common.base.Strings;
import net.school.web.italker.push.bean.db.Classes;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.utils.Hib;

import java.util.List;

public class StudentFactory {
    public static Student createStudent(int sex, String name, String identity, String portrait, String classNo) {
        Student student = new Student();

        student.setName(name);
        student.setSex(sex);
        student.setIdentity(identity);
        student.setPortrait(portrait);
        student.setClassNo(classNo);
        Classes classes = ClassFactory.findByclassNo(classNo);
        student.setClasses(classes);
//        if (Strings.isNullOrEmpty(classNo)) {
//            Classes classes = ClassFactory.findByclassNo(classNo);
//            if (classes != null) {
//                student.setClassNo(classes.getClassNo());
//                student.setClasses(classes);
//            }
//        }

        // 数据库存储
        return Hib.query(session -> {
            session.save(student);
            return student;
        });
    }

    public static Student findById(String id) {
        // 通过Id查询，更方便
        return Hib.query(session -> session.get(Student.class, id));
    }

    public static List<Student> search(String name) {
        // 通过Id查询，更方便

        if (Strings.isNullOrEmpty(name))
            name = ""; // 保证不能为null的情况，减少后面的一下判断和额外的错误
        final String searchName = "%" + name + "%"; // 模糊匹配
        System.out.println("searchName:" + searchName);

        return Hib.query(session -> (List<Student>) session
                .createQuery("from Student where name like :name")
                .setParameter("name", searchName)
                .setMaxResults(20) // 至多20条
                .list());
    }
}
