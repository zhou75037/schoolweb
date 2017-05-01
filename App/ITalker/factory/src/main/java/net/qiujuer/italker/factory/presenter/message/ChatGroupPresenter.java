package net.qiujuer.italker.factory.presenter.message;

import net.qiujuer.italker.factory.data.helper.GroupHelper;
import net.qiujuer.italker.factory.data.message.MessageGroupRepository;
import net.qiujuer.italker.factory.model.db.Group;
import net.qiujuer.italker.factory.model.db.Message;

/**
 * 群聊天的逻辑
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class ChatGroupPresenter extends ChatPresenter<ChatContract.GroupView>
        implements ChatContract.Presenter {

    public ChatGroupPresenter(ChatContract.GroupView view, String receiverId) {
        // 数据源，View，接收者，接收者的类型
        super(new MessageGroupRepository(receiverId), view, receiverId, Message.RECEIVER_TYPE_GROUP);
    }

    @Override
    public void start() {
        super.start();

        // 拿群的信息
        Group group = GroupHelper.findFromLocal(mReceiverId);
        if (group != null) {
            // 初始化操作


        }

    }
}