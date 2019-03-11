package net.school.web.italker.push.bean.db;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_TEACHER_FOLLOW")
public class TeacherFollow {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;

    // 定义一个发起人，你关注某人，这里就是你
    // 多对1 -> 你可以关注很多人，你的每一次关注都是一条记录
    // 你可以创建很多个关注的信息，所有是多对1；
    // 这里的多对一是：User 对应 多个UserFollow
    // optional 不可选，必须存储，一条关注记录一定要有一个"你"
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // 定义关联的表字段名为originId，对应的是User.id
    // 定义的是数据库中的存储字段
    @JoinColumn(name = "teacherClassNo")
    private Teacher teacher;
    // 把这个列提取到我们的Model中，不允许为null，不允许更新，插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String teacherClassNo;

    // 定义一个发起人，你关注某人，这里就是你
    // 多对1 -> 你可以关注很多人，你的每一次关注都是一条记录
    // 你可以创建很多个关注的信息，所有是多对1；
    // 这里的多对一是：User 对应 多个UserFollow
    // optional 不可选，必须存储，一条关注记录一定要有一个"你"
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // 定义关联的表字段名为originId，对应的是User.id
    // 定义的是数据库中的存储字段
    @JoinColumn(name = "classTeacherNo")
    private Classes classes;
    // 把这个列提取到我们的Model中，不允许为null，不允许更新，插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String classTeacherNo;


    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherClassNo() {
        return teacherClassNo;
    }

    public void setTeacherClassNo(String teacherClassNo) {
        this.teacherClassNo = teacherClassNo;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getClassTeacherNo() {
        return classTeacherNo;
    }

    public void setClassTeacherNo(String classTeacherNo) {
        this.classTeacherNo = classTeacherNo;
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

    public TeacherFollow (){}

    public TeacherFollow(String teacherClassNo, String classTeacherNo) {
        this.teacherClassNo = teacherClassNo;
        this.classTeacherNo = classTeacherNo;
    }
}
