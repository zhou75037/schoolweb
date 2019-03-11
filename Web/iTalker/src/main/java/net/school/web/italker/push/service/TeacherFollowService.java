package net.school.web.italker.push.service;

import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.classes.ClassesModel;
import net.school.web.italker.push.bean.card.ClassesCard;
import net.school.web.italker.push.bean.db.Classes;
import net.school.web.italker.push.bean.db.Teacher;
import net.school.web.italker.push.bean.db.TeacherFollow;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.factory.ClassFactory;
import net.school.web.italker.push.factory.TeacherFactory;
import net.school.web.italker.push.factory.TeacherFollowFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// 127.0.0.1/api/account/...
@Path("/teacherfollow")
public class TeacherFollowService extends BaseService {
    // 创建班级
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<ClassesCard> create(ClassesModel classesModel) {

        User self = getSelf();
        if (self.getType()!=0){
            return ResponseModel.buildTypeError();
        }
        Teacher teacher = TeacherFactory.findByteacherid(self.getId());
        if (teacher == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundTeacherError(null);
        }
        if (!ClassesModel.check(classesModel)) {
            return ResponseModel.buildParameterError();
        }
        Classes classes = ClassFactory.findByclassNo(classesModel.getClassNo());
        TeacherFollow teacherFollow = TeacherFollowFactory.create(teacher,classes);
            if (teacherFollow == null) {
                // 没找到，返回没找到用户
                return ResponseModel.buildCreateTeacherFollowError();
            }
        return ResponseModel.buildOk(new ClassesCard(classes));
    }
}
