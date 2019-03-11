package net.school.web.italker.push.bean.db;

import net.school.web.italker.push.bean.api.task.TaskModel;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TASK")
public class Task {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 任务内容不可以为null
    @Column(nullable = false)
    private String content;

    // 任务类型不可以为空
    //1:作业，0：考试
    @Column(nullable = false)
    private int type;


    // 定义一个发起人，你关注某人，这里就是你
    // 1对1 -> 你可以对应一个家长身份
    // 你可以一个用户对应家长身份；
    // 这里的一对一是：User 对应 Teacher
    // optional 不可选，必须存储，一条关注记录一定要有一个"你"
    @OneToOne(optional = false)
    // 定义的是数据库中的存储字段
    @JoinColumn(name = "studentTaskId")
    private Student student;
    // 把这个列提取到我们的Model中，不允许为null，不允许更新，插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String studentTaskId;

    @Column
    private int grade;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentTaskId() {
        return studentTaskId;
    }

    public void setStudentTaskId(String studentTaskId) {
        this.studentTaskId = studentTaskId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Task(){}

    public Task(TaskModel model,Student student) {
        this.content = model.getContent();
        this.type = model.getType();
        this.student = student;
        this.studentTaskId = model.getStudentTaskId();
        this.grade = model.getGrade();
    }
}
