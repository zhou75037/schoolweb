package net.school.web.italker.push.service;

import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.task.TaskModel;
import net.school.web.italker.push.bean.card.TaskCard;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.bean.db.Task;
import net.school.web.italker.push.factory.StudentFactory;
import net.school.web.italker.push.factory.TaskFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@Path("/task")
public class TaskService {
    // 注册
    @POST
    @Path("/create/{classNo}")
    // 指定请求与返回的相应体为JSON
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<TaskCard> register(TaskModel model) {
        Student student  = StudentFactory.findById(model.getStudentTaskId());
        if (student == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundStudentError(null);
        }
        Task task= TaskFactory.create(model,student);
        if (task != null) {
            return ResponseModel.buildOk(new TaskCard(task));
        }
        else {
            // 创建异常
            return ResponseModel.buildCreateTaskError();
        }
    }

    // 获取学生的任务信息
    @GET
    @Path("/search/{studentid}") // 名字为任意字符，可以为空
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<TaskCard>> searchTask(@PathParam("studentid") String studentid) {


        final List<Task> tasks = TaskFactory.findBystudentTaskId(studentid);

        if (tasks == null) {
            // 没找到，返回没找到用户
            return ResponseModel.buildNotFoundTaskError(null);
        }
        List<TaskCard> taskCards = tasks.stream()
                .map(task -> {
                    return new TaskCard(task);
                }).collect(Collectors.toList());

        return ResponseModel.buildOk(taskCards);
    }

}
