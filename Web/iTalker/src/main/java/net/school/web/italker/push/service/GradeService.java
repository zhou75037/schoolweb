package net.school.web.italker.push.service;

import com.google.common.base.Strings;
import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.grade.GradeModel;
import net.school.web.italker.push.bean.card.GradeCard;
import net.school.web.italker.push.bean.db.Grade;
import net.school.web.italker.push.factory.GradeFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

// 127.0.0.1/api/grade/...
@Path("/grade")
public class GradeService extends BaseService {


    // 获取某人的信息
    @GET
    @Path("/search/{studentid}") // http://127.0.0.1/api/student/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<GradeCard> getStudent(@PathParam("studentid") String studentid) {
        Grade grade = new Grade();

        if (Strings.isNullOrEmpty(studentid)) {
            // 返回参数异常
            return ResponseModel.buildParameterError();
        }
        final List<Grade> grades = GradeFactory.getGrades(studentid);
        if (grades == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundGradeError(null);
        }
        return ResponseModel.buildOk(new GradeCard(grade));
    }



    //搜索学生成绩
    @GET
    @Path("/find/{studentid}") //
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<GradeCard>> searchStudents(@PathParam("studentid") String studentid) {


        final List<Grade> grades = GradeFactory.findGrades(studentid);

        if (grades == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundGradeError(null);
        }
        List<GradeCard> gradeCards = grades.stream()
                .map(grade -> {
                    return new GradeCard(grade);
                }).collect(Collectors.toList());

        return ResponseModel.buildOk(gradeCards);
    }

    // 创建成绩
    @POST
    @Path("/create/{studentid}")
    // 指定请求与返回的相应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<GradeCard> register(GradeModel model, @PathParam("studentid") String studentid) {
        Grade grade = new Grade();
        grade = GradeFactory.createGrade(model,studentid);
        if (grade != null) {
            return ResponseModel.buildOk(new GradeCard(grade));
        }
        else {
            // 创建异常
            return ResponseModel.buildCreateStudentError();
        }
    }
}
