package net.qiujuer.web.italker.push.service;

import net.qiujuer.web.italker.push.bean.api.base.ResponseModel;
import net.qiujuer.web.italker.push.bean.api.group.GroupCreateModel;
import net.qiujuer.web.italker.push.bean.api.group.GroupMemberAddModel;
import net.qiujuer.web.italker.push.bean.api.group.GroupMemberUpdateModel;
import net.qiujuer.web.italker.push.bean.card.ApplyCard;
import net.qiujuer.web.italker.push.bean.card.GroupCard;
import net.qiujuer.web.italker.push.bean.card.GroupMemberCard;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 群组的接口的入口
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
@Path("/group")
public class GroupService extends BaseService {
    /**
     * 创建群
     *
     * @param model 基本参数
     * @return 群信息
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<GroupCard> create(GroupCreateModel model) {
        return null;
    }

    /**
     * 查找群，没有传递参数就是搜索最近所有的群
     *
     * @param name 搜索的参数
     * @return 群信息列表
     */
    @GET
    @Path("/search/{name:(.*)?}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<GroupCard>> search(@PathParam("name") @DefaultValue("") String name) {
        return null;
    }

    /**
     * 拉取自己当前的群的列表
     *
     * @param dateStr 时间字段，不传递，则返回全部当前的群列表；有时间，则返回这个时间之后的加入的群
     * @return 群信息列表
     */
    @GET
    @Path("/list/{date:(.*)?}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<GroupCard>> list(@DefaultValue("") @PathParam("date") String dateStr) {
        return null;
    }

    /**
     * 获取一个群的信息
     *
     * @param id 群的Id
     * @return 群的信息
     */
    @GET
    @Path("/{groupId}")
    //http:.../api/group/0000-0000-0000-0000
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<GroupCard> getGroup(@PathParam("groupId") String id) {
        return null;
    }

    /**
     * 拉取一个群的所有成员，你必须是成员之一
     *
     * @param groupId 群id
     * @return 成员列表
     */
    @GET
    @Path("/{groupId}/member")
    //http:.../api/group/0000-0000-0000-0000/member
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<GroupMemberCard>> members(@PathParam("groupId") String groupId) {
        return null;
    }

    /**
     * 给群添加成员的接口
     *
     * @param groupId 群Id，你必须是这个群的管理者之一
     * @param model   添加成员的Model
     * @return 添加成员列表
     */
    @POST
    @Path("/{groupId}/member")
    //http:.../api/group/0000-0000-0000-0000/member
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<List<GroupMemberCard>> memberAdd(@PathParam("groupId") String groupId, GroupMemberAddModel model) {
        return null;
    }


    /**
     * 更改成员信息，请求的人要么是管理员，要么就是成员本人
     *
     * @param memberId 成员Id，可以查询对应的群，和人
     * @param model    修改的Model
     * @return 当前成员的信息
     */
    @PUT
    @Path("/member/{memberId}")
    //http:.../api/group/member/0000-0000-0000-0000
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<GroupMemberCard> modifyMember(@PathParam("memberId") String memberId, GroupMemberUpdateModel model) {
        return null;
    }


    /**
     * 申请加入一个群，
     * 此时会创建一个加入的申请，并写入表；然后会给管理员发送消息
     * 管理员同意，其实就是调用添加成员的接口把对应的用户添加进去
     *
     * @param groupId 群Id
     * @return 申请的信息
     */
    @POST
    @Path("/applyJoin/{groupId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<ApplyCard> join(@PathParam("groupId") String groupId) {
        return null;
    }

}
