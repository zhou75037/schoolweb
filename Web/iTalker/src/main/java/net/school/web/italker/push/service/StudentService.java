package net.school.web.italker.push.service;

import com.google.common.base.Strings;
import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.student.StudentModel;
import net.school.web.italker.push.bean.card.StudentCard;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.bean.db.User;
import net.school.web.italker.push.factory.StudentFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/student")
public class StudentService extends BaseService {


    // 获取某人的信息
    @GET
    @Path("/find/{id}") // http://127.0.0.1/api/student/{id}
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<StudentCard> getStudent(@PathParam("id") String id) {
        User self = getSelf();

        if (Strings.isNullOrEmpty(id)) {
            // 返回参数异常
            return ResponseModel.buildParameterError();
        }
        final Student student = StudentFactory.findById(id);
        if (student == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundStudentError(null);
        }
//        System.out.println(student.getName());
        return ResponseModel.buildOk(new StudentCard(student));
    }
    // 注册
    @POST
    @Path("/create/{classNo}")
    // 指定请求与返回的相应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<StudentCard> register(StudentModel model, @PathParam("classNo") String classNo) {
       Student student = new Student();
        student = StudentFactory.createStudent(model.getSex(),
                model.getName(),
                model.getIdentity()
        ,model.getPortrait(),classNo);
        if (student != null) {
            return ResponseModel.buildOk(new StudentCard(student));
        }
        else {
            // 创建异常
            return ResponseModel.buildCreateStudentError();
        }
    }
    // 获取某人的信息
    @GET
    @Path("/search/{name:(.*)?}") // 名字为任意字符，可以为空
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<StudentCard>> searchStudents(@PathParam("name") String name) {


        final List<Student> students = StudentFactory.search(name);

        if (students == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundStudentError(null);
        }
        List<StudentCard> studentCards = students.stream()
                .map(student -> {
                    return new StudentCard(student);
                }).collect(Collectors.toList());

        return ResponseModel.buildOk(studentCards);
    }
}
