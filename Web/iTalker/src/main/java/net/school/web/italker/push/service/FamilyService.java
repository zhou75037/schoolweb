package net.school.web.italker.push.service;

import net.school.web.italker.push.bean.api.family.FamilyModel;
import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.card.FamilyCard;
import net.school.web.italker.push.bean.db.Family;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.factory.FamilyFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 老师信息处理的Service
 * @version 1.0.0
 */
// 127.0.0.1/api/teacher/...
@Path("/family")
public class FamilyService  extends BaseService {
    // 创建老师身份
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<FamilyCard> register(FamilyModel model) {
        User self = getSelf();
        if (self.getType()!=0){
            return ResponseModel.buildTypeError();
        }
        Family family = FamilyFactory.create(model,self);
        return ResponseModel.buildOk(new FamilyCard(family));
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<FamilyCard>> getTeacher() {
        User self = getSelf();

        List<Family> familys =FamilyFactory.findfamliyides(self.getId());
        if (familys == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundTeacherError(null);
        }
        // 如果我们直接有关注的记录，则我已关注需要查询信息的用户

        final List<FamilyCard> familyCards = familys.stream()
                .map(family -> {
                    return new FamilyCard(family);
                }).collect(Collectors.toList());
        // 返回
        return ResponseModel.buildOk(familyCards);

    }
}
