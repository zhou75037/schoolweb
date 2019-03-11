package net.school.web.italker.push.service;

import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.teacher.TeacherModel;
import net.school.web.italker.push.bean.card.TeacherCard;
import net.school.web.italker.push.bean.db.Teacher;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.factory.TeacherFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 老师信息处理的Service
 * @version 1.0.0
 */
// 127.0.0.1/api/teacher/...
@Path("/teacher")
public class TeacherService  extends BaseService {
    // 创建老师身份
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<TeacherCard> register(TeacherModel model) {
        if (!TeacherModel.check(model)) {
            return ResponseModel.buildParameterError();
        }
        User self = getSelf();
        if (self.getType()!=0){
            return ResponseModel.buildTypeError();
        }
        Teacher teacher = TeacherFactory.create(model,self);
        return ResponseModel.buildOk(new TeacherCard(teacher));
    }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<TeacherCard>> getTeacher() {
        User self = getSelf();

        List<Teacher> teachers = TeacherFactory.findByteacherides(self.getId());
        if (teachers == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundTeacherError(null);
        }
        // 如果我们直接有关注的记录，则我已关注需要查询信息的用户

        final List<TeacherCard> teacherCards = teachers.stream()
                .map(teacher -> {
                    return new TeacherCard(teacher);
                }).collect(Collectors.toList());
        // 返回
        return ResponseModel.buildOk(teacherCards);

    }
}
