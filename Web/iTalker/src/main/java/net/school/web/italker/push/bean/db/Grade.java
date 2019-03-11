package net.school.web.italker.push.bean.db;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 成绩表
 * @version 1.0.0
 */
@Entity
@Table(name = "TB_GRADE")
public class Grade {
    @Id
    @PrimaryKeyJoinColumn
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(updatable = false, nullable = false)
    private String id;


    //成绩 不可为空
    @Column(nullable = false)
    private int grade;

    //科目不可为空
    @Column(nullable = false)
    private String porject;

    // 定义为创建时间戳，在创建时就已经写入
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();

    // 定义为更新时间戳，在创建时就已经写入
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updateAt = LocalDateTime.now();

    //说明可为空
    @Column
    private String content;

    // 定义关注的目标，你关注的人
    // 也是多对1，你可以被很多人关注，每次一关注都是一条记录
    // 所有就是 多个Grade 对应 一个 Student 的情况
    @ManyToOne(optional = false)
    // 定义关联的表字段名为targetId，对应的是Student.id
    // 定义的是数据库中的存储字段
    @JoinColumn(name = "studentgradeId")
    private Student  student;
    // 把这个列提取到我们的Model中，不允许为null，不允许更新，插入
    @Column(nullable = false, updatable = false, insertable = false)
    private String studentgradeId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getPorject() {
        return porject;
    }

    public void setPorject(String porject) {
        this.porject = porject;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentgradeId() {
        return studentgradeId;
    }

    public void setStudentgradeId(String studentgradeId) {
        this.studentgradeId = studentgradeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
