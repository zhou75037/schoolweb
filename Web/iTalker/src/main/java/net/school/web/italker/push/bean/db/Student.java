package net.school.web.italker.push.bean.db;

import org.hibernate.annotations.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "TB_STUDENT")
public class Student {
    // 这是一个主键
    @Id
    @PrimaryKeyJoinColumn
    // 主键生成存储的类型为UUID
    @GeneratedValue(generator = "uuid")
    // 把uuid的生成器定义为uuid2，uuid2是常规的UUID toString
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    // 不允许更改，不允许为null
    @Column(updatable = false, nullable = false)
    private String id;

    // 用户名必须唯一
    @Column(nullable = false, length = 128, unique = true)
    private String name;


    // 性别有初始值，所有不为空
    @Column(nullable = false)
    private int sex = 0;


    // 头像允许为null
    @Column
    private String portrait;
    // 身份证号可为空
    @Column
    private String identity;


    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    // 关注我的人的列表
    // 对应的数据库表字段为TB_STUDNET_FOLLOW.studentownId
    @JoinColumn(name = "studentfollowId")
    // 定义为懒加载，默认加载Student信息的时候，并不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    // 1对多，一个用户可以被很多人关注，每一次关注都是一个记录
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<StudentFollow> followers = new HashSet<>();

    // 关注我的人的列表
    // 对应的数据库表字段为TB_GRADE.studentgradeId
    @JoinColumn(name = "studentgradeId")
    // 定义为懒加载，默认加载Student信息的时候，并不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    // 1对多，一个用户可以被很多人关注，每一次关注都是一个记录
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Grade> grades = new HashSet<>();


    // 关注我的人的列表
    // 对应的数据库表字段为TB_GRADE.studentclassid
    @JoinColumn(name = "studentclassid")
    // 定义为懒加载，默认加载Student信息的时候，并不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    // 1对多，一个学生只有一个班级
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Classes classes = new Classes();


    // 我关注的人的列表方法
    // 对应的数据库表字段为TB_USER_FOLLOW.originId
    @JoinColumn(name = "studentTaskId")
    // 定义为懒加载，默认加载User信息的时候，并不查询这个集合
    @LazyCollection(LazyCollectionOption.EXTRA)
    // 1对多，一个学生可以有很多作业成绩，每一次关注都是一个记录
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks = new HashSet<>();

    @Column
    private String classNo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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

    public Set<StudentFollow> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<StudentFollow> followers) {
        this.followers = followers;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }


    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getPortrait() {
        return portrait;
    }


    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }


    public Student(){}
}
