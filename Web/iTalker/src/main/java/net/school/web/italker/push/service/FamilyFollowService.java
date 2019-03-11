package net.school.web.italker.push.service;

import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.family.StudentFollowModel;
import net.school.web.italker.push.bean.card.ClassesCard;
import net.school.web.italker.push.bean.db.Family;
import net.school.web.italker.push.bean.db.StudentFollow;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.factory.FamilyFactory;
import net.school.web.italker.push.factory.FamilyFollowFactory;
import net.school.web.italker.push.factory.StudentFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 老师信息处理的Service
 * @version 1.0.0
 */
@Path("familyfollow")
public class FamilyFollowService extends BaseService {
    // 创建班级
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<ClassesCard> create(StudentFollowModel studentFollowModel) {
        User self = getSelf();
        if (self.getType()!=0){
            return ResponseModel.buildTypeError();
        }


        final Student student = StudentFactory.findById(studentFollowModel.getStudentid());
        if (student == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundStudentError(null);
        }


        final  Family family= FamilyFactory.findByteacherid(studentFollowModel.getParentId());
        if (family == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundFamilyError(null);
        }

        StudentFollow studentFollow = FamilyFollowFactory.create(family,student, studentFollowModel);
        if (studentFollow == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildCreateTeacherFollowError();
        }
        return ResponseModel.buildOk();
    }
}
