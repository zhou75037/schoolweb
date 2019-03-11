package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.api.family.FamilyModel;
import net.school.web.italker.push.bean.db.Family;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.utils.Hib;

import java.util.List;

public class FamilyFactory {
    public static Family create(FamilyModel model, User creator) {

        return Hib.query(session -> {
            Family family = new Family(model,creator);
            session.save(family);
            return family;
        });
    }
    public static Family findByteacherid(String id) {
        return Hib.query(session -> (Family) session
                .createQuery("from Family where id=:id")
                .setParameter("id",id )
                .uniqueResult());
    }

    public static List<Family> findfamliyides(String familyId) {

        return Hib.query(session -> {
            return (List<Family>) session.createQuery("from Family where familyId  =:familyId")
                    .setParameter("familyId", familyId)
                    .setMaxResults(20) // 至多20条
                    .list();

        });
    }

}
