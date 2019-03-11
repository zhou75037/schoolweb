package net.school.web.italker.push.service;


import com.google.common.base.Strings;
import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.classes.ClassesModel;
import net.school.web.italker.push.bean.card.ClassesCard;
import net.school.web.italker.push.bean.db.Classes;
import net.school.web.italker.push.factory.ClassFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

// 127.0.0.1/api/account/...
@Path("/class")
public class ClassesService extends BaseService {
    // 创建班级
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<ClassesCard> create(ClassesModel model) {
        if (!ClassesModel.check(model)) {
            return ResponseModel.buildParameterError();
        }
        Classes classes = ClassFactory.create(model);
        return ResponseModel.buildOk(new ClassesCard(classes));
    }
    @GET
    @Path("/search/{classNo}") // http://127.0.0.1/api/student/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<ClassesCard> getClasses(@PathParam("classNo") String classNo) {
        if (Strings.isNullOrEmpty(classNo)){
            return ResponseModel.buildParameterError();
        }
        Classes classes = ClassFactory.findByclassNo(classNo);
        if (classes == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundTeacherError(null);
        }
        // 如果我们直接有关注的记录，则我已关注需要查询信息的用户
        return ResponseModel.buildOk(new ClassesCard(classes));
    }
}
