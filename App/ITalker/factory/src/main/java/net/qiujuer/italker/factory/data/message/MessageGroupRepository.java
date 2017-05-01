package net.qiujuer.italker.factory.data.message;

import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import net.qiujuer.italker.factory.data.BaseDbRepository;
import net.qiujuer.italker.factory.model.db.Message;

import java.util.Collections;
import java.util.List;

/**
 * 跟群聊天的时候的聊天列表
 * 关注的内容一定是我发给群或者是别人发送到群的信息
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class MessageGroupRepository extends BaseDbRepository<Message>
        implements MessageDataSource {
    // 聊天的群Id
    private String receiverId;

    public MessageGroupRepository(String receiverId) {
        super();
        this.receiverId = receiverId;
    }

    @Override
    public void load(SucceedCallback<List<Message>> callback) {
        super.load(callback);

        // TODO
        /*
        //(sender_id == receiverId and group_id == null)
        // or (receiver_id==receiverId)
        SQLite.select()
                .from(Message.class)
                .where(OperatorGroup.clause()
                        .and(Message_Table.sender_id.eq(receiverId))
                        .and(Message_Table.group_id.isNull()))
                .or(Message_Table.receiver_id.eq(receiverId))
                .orderBy(Message_Table.createAt, false)
                .limit(30)
                .async()
                .queryListResultCallback(this)
                .execute();
                */
    }

    @Override
    protected boolean isRequired(Message message) {
        return false;
    }

    @Override
    public void onListQueryResult(QueryTransaction transaction, @NonNull List<Message> tResult) {
        // 反转返回的集合
        Collections.reverse(tResult);
        // 然后再调度
        super.onListQueryResult(transaction, tResult);
    }
}
