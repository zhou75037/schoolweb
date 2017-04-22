package net.qiujuer.web.italker.push.service;

import com.google.common.base.Strings;
import net.qiujuer.web.italker.push.bean.api.base.ResponseModel;
import net.qiujuer.web.italker.push.bean.api.user.UpdateInfoModel;
import net.qiujuer.web.italker.push.bean.card.UserCard;
import net.qiujuer.web.italker.push.bean.db.User;
import net.qiujuer.web.italker.push.factory.UserFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 用户信息处理的Service
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
// 127.0.0.1/api/user/...
@Path("/user")
public class UserService {

    // 用户信息修改接口
    // 返回自己的个人信息
    @PUT
    //@Path("") //127.0.0.1/api/user 不需要写，就是当前目录
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseModel<UserCard> update(@HeaderParam("token") String token,
                                          UpdateInfoModel model) {
        if (Strings.isNullOrEmpty(token) || !UpdateInfoModel.check(model)) {
            return ResponseModel.buildParameterError();
        }


        // 拿到自己的个人信息
        User user = UserFactory.findByToken(token);
        if (user != null) {

            // 更新用户信息
            user = model.updateToUser(user);
            user = UserFactory.update(user);
            // 构架自己的用户信息
            UserCard card = new UserCard(user, true);
            // 返回
            return ResponseModel.buildOk(card);
        } else {
            // Token 失效，所有无法进行绑定
            return ResponseModel.buildAccountError();
        }

    }

}
