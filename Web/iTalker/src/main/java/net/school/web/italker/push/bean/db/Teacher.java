package net.school.web.italker.push.bean.db;

import net.school.web.italker.push.bean.api.teacher.TeacherModel;
import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_TEACHER")
public class Teacher {
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的类型为UUID
    @GeneratedValue(generator = "uuid")
    // 把uuid的生成器定义为uuid2，uuid2是常规的UUID toString
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // 不允许更改，不允许为null
    @Column(updatable = false, nullable = false)
    private String id;



    // 科目为空
    @Column
    private String  project;

    // 级别为空
    @Column
    private String  level;

    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();


    // 定义一个发起人，你关注某人，这里就是你
    // 1对1 -> 你可以对应一个家长身份
    // 你可以一个用户对应家长身份；
    // 这里的一对一是：User 对应 Teacher
    // optional 不可选，必须存储，一条关注记录一定要有一个"你"
    @ManyToOne(optional = false)
    // 定义的是数据库中的存储字段
    @JoinColumn(name = "teacherId")
    private User user;
    // 把这个列提取到我们的Model中，不允许为null，不允许更新，插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String teacherId;

    // 我关注的人的列表方法
    // 对应的数据库表字段为TB_USER_FOLLOW.originId
    @JoinColumn(name = "teacherClassNo")
    // 定义为懒加载，默认加载User信息的时候，并不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    // 1对多，一个用户可以有很多关注人，每一次关注都是一个记录
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<TeacherFollow> teacherFollows = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Set<TeacherFollow> getTeacherFollows() {
        return teacherFollows;
    }

    public void setTeacherFollows(Set<TeacherFollow> teacherFollows) {
        this.teacherFollows = teacherFollows;
    }

    public Teacher(TeacherModel model, User creator){
        this.level=model.getLevel();
        this.project=model.getProject();
        this.teacherId=creator.getId();
        this.user=creator;
    }

    public Teacher() {
    }
}
