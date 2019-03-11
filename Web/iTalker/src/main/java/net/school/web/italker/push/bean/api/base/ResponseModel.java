package net.school.web.italker.push.bean.api.base;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.time.LocalDateTime;

/** @version 1.0.0
 */
public class ResponseModel<M> implements Serializable {
    // 成功
    public static final int SUCCEED = 1;
    // 未知错误
    public static final int ERROR_UNKNOWN = 0;

    // 没有找到用户信息
    public static final int ERROR_NOT_FOUND_USER = 4041;
    // 没有找到群信息
    public static final int ERROR_NOT_FOUND_GROUP = 4042;
    // 没有找到群成员信息
    public static final int ERROR_NOT_FOUND_GROUP_MEMBER = 4043;
    // 没有找到学生信息
    public static final int ERROR_NOT_FOUND_STUDENT = 4044;
    //没有找到学生对应的成绩
    public static final int ERROR_NOT_FOUND_GRADE = 4045;
    //没有找到对应的老师信息
    public static final int ERROR_NOT_FOUND_TEACHER = 4046;
    //没有找到对应的班级信息
    public static final int ERROR_NOT_FOUND_CLASS = 4047;
    //没有找到对应的家长信息
    public static final int ERROR_NOT_FOUND_FAMILY = 4048;
    //没有找到对应的任务信息
    public static final int ERROR_NOT_FOUND_TASK = 4049;

    // 创建用户失败
    public static final int ERROR_CREATE_USER = 3001;
    // 创建群失败
    public static final int ERROR_CREATE_GROUP = 3002;
    // 创建群成员失败
    public static final int ERROR_CREATE_MESSAGE = 3003;
    //创建学生失败
    public static final int ERROR_CREATE_STUDENT = 3004;

    //创建家庭失败
    public static final int ERROR_CREATE_FAMILY = 3005;

    //创建老师与教师绑定失败
    public static final int ERROR_CREATE_TEACHER_FOLLOW = 3006;

    //创建任务失败
    public static final int ERROR_CREATE_TASK = 3007;


    // 请求参数错误
    public static final int ERROR_PARAMETERS = 4001;
    // 请求参数错误-已存在账户
    public static final int ERROR_PARAMETERS_EXIST_ACCOUNT = 4002;
    // 请求参数错误-已存在名称
    public static final int ERROR_PARAMETERS_EXIST_NAME = 4003;

    // 服务器错误
    public static final int ERROR_SERVICE = 5001;

    // 账户Token错误，需要重新登录
    public static final int ERROR_ACCOUNT_TOKEN = 2001;
    // 账户登录失败
    public static final int ERROR_ACCOUNT_LOGIN = 2002;
    // 账户注册失败
    public static final int ERROR_ACCOUNT_REGISTER = 2003;
    // 没有权限操作
    public static final int ERROR_ACCOUNT_NO_PERMISSION = 2010;



    @Expose
    private int code;
    @Expose
    private String message;
    @Expose
    private LocalDateTime time = LocalDateTime.now();
    @Expose
    private M result;

    public ResponseModel() {
        code = 1;
        message = "ok";
    }

    public ResponseModel(M result) {
        this();
        this.result = result;
    }

    public ResponseModel(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseModel(int code, String message, M result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public boolean isSucceed() {
        return code == SUCCEED;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public M getResult() {
        return result;
    }

    public void setResult(M result) {
        this.result = result;
    }

    public static <M> ResponseModel<M> buildOk() {
        return new ResponseModel<M>();
    }

    public static <M> ResponseModel<M> buildOk(M result) {
        return new ResponseModel<M>(result);
    }

    public static <M> ResponseModel<M> buildParameterError() {
        return new ResponseModel<M>(ERROR_PARAMETERS, "Parameters Error.");
    }

    public static <M> ResponseModel<M> buildHaveAccountError() {
        return new ResponseModel<M>(ERROR_PARAMETERS_EXIST_ACCOUNT, "Already have this account.");
    }

    public static <M> ResponseModel<M> buildHaveNameError() {
        return new ResponseModel<M>(ERROR_PARAMETERS_EXIST_NAME, "Already have this name.");
    }

    public static <M> ResponseModel<M> buildServiceError() {
        return new ResponseModel<M>(ERROR_SERVICE, "Service Error.");
    }

    public static <M> ResponseModel<M> buildNotFoundUserError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_USER, str != null ? str : "Not Found User.");
    }

    public static <M> ResponseModel<M> buildNotFoundTeacherError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_TEACHER, str != null ? str : "Not Found Teacher.");
    }
    public static <M> ResponseModel<M> buildNotFoundFamilyError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_FAMILY, str != null ? str : "Not Found family.");
    }

    public static <M> ResponseModel<M> buildNotFoundGroupError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_GROUP, str != null ? str : "Not Found Group.");
    }

    public static <M> ResponseModel<M> buildNotFoundGroupMemberError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_GROUP_MEMBER, str != null ? str : "Not Found GroupMember.");
    }

    public static <M> ResponseModel<M> buildNotFoundClassError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_CLASS, str != null ? str : "Not Found Class.");
    }

    public static <M> ResponseModel<M> buildAccountError() {
        return new ResponseModel<M>(ERROR_ACCOUNT_TOKEN, "Account Error; you need login.");
    }

    public static <M> ResponseModel<M> buildLoginError() {
        return new ResponseModel<M>(ERROR_ACCOUNT_LOGIN, "Account or password error.");
    }

    public static <M> ResponseModel<M> buildRegisterError() {
        return new ResponseModel<M>(ERROR_ACCOUNT_REGISTER, "Have this account.");
    }

    public static <M> ResponseModel<M> buildNoPermissionError() {
        return new ResponseModel<M>(ERROR_ACCOUNT_NO_PERMISSION, "You do not have permission to operate.");
    }

    public static <M> ResponseModel<M> buildCreateError(int type) {
        return new ResponseModel<M>(type, "Create failed.");
    }
    public static <M> ResponseModel<M> buildCreateStudentError() {
        return new ResponseModel<M>(ERROR_CREATE_STUDENT, "Create Student failed.");
    }
    public static <M> ResponseModel<M> buildCreateTaskError() {
        return new ResponseModel<M>(ERROR_CREATE_TASK, "Create Task failed.");
    }

    public static <M> ResponseModel<M> buildNotFoundStudentError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_STUDENT, str != null ? str : "Not Found Student.");
    }
    public static <M> ResponseModel<M> buildNotFoundTaskError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_TASK, str != null ? str : "Not Found Task.");
    }

    public static <M> ResponseModel<M> buildNotFoundGradeError(String str) {
        return new ResponseModel<M>(ERROR_NOT_FOUND_GRADE, str != null ? str : "Not Found Grade.");
    }
    public static <M> ResponseModel<M> buildCreateFamilyError() {
        return new ResponseModel<M>(ERROR_CREATE_FAMILY, "Create family failed.");
    }
    public static <M> ResponseModel<M> buildCreateTeacherFollowError() {
        return new ResponseModel<M>(ERROR_CREATE_TEACHER_FOLLOW, "Create Teacher Follow failed.");
    }
    public static <M> ResponseModel<M> buildTypeError() {
        return new ResponseModel<M>(ERROR_CREATE_FAMILY, "Create Teacher failed.");
    }

}