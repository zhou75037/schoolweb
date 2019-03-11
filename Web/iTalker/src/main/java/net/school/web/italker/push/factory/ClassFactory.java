package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.api.classes.ClassesModel;
import net.school.web.italker.push.bean.db.Classes;
import net.school.web.italker.push.service.BaseService;
import net.school.web.italker.push.utils.Hib;


public class ClassFactory extends BaseService {
    public static Classes create(ClassesModel model) {
        return Hib.query(session -> {
            Classes classes = new Classes(model);
            session.save(classes);
            return classes;
        });
    }
    public static Classes findByclassNo(String classNo) {
        return Hib.query(session -> (Classes) session
                .createQuery("from Classes where classNo=:classNo")
                .setParameter("classNo",classNo )
                .uniqueResult());
    }
}
