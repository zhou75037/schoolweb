package net.school.web.italker.push.factory;

import net.school.web.italker.push.bean.api.base.ResponseModel;
import net.school.web.italker.push.bean.api.task.TaskModel;
import net.school.web.italker.push.bean.card.TaskCard;
import net.school.web.italker.push.bean.db.Student;
import net.school.web.italker.push.bean.db.Task;
import net.school.web.italker.push.utils.Hib;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

public class TaskFactory {
    public static Task create(TaskModel model,Student student) {
        return Hib.query(session -> {
            Task task = new Task(model,student);
            session.save(task);
            return task;
        });
    }
    public static List<Task> findBystudentTaskId(String studentTaskId) {

        return Hib.query(session -> {
            return (List<Task>) session.createQuery("from Task where studentTaskId  =:studentTaskId")
                    .setParameter("studentTaskId", studentTaskId)
                    .setMaxResults(20) // 至多20条
                    .list();

        });
    }

}
