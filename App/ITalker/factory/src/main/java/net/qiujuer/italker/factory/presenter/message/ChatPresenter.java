package net.qiujuer.italker.factory.presenter.message;

import android.support.v7.util.DiffUtil;

import net.qiujuer.italker.factory.data.message.MessageDataSource;
import net.qiujuer.italker.factory.model.db.Message;
import net.qiujuer.italker.factory.presenter.BaseSourcePresenter;
import net.qiujuer.italker.factory.utils.DiffUiDataCallback;

import java.util.List;

/**
 * 聊天Presenter的基础类
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class ChatPresenter<View extends ChatContract.View>
        extends BaseSourcePresenter<Message, Message, MessageDataSource, View>
        implements ChatContract.Presenter {

    protected String mReceiverId;
    protected int mReceiverType;


    public ChatPresenter(MessageDataSource source, View view,
                         String receiverId, int receiverType) {
        super(source, view);
        this.mReceiverId = receiverId;
        this.mReceiverType = receiverType;
    }

    @Override
    public void pushText(String content) {

    }

    @Override
    public void pushAudio(String path) {

    }

    @Override
    public void pushImages(String[] paths) {

    }

    @Override
    public boolean rePush(Message message) {
        return false;
    }

    @Override
    public void onDataLoaded(List<Message> messages) {
        ChatContract.View view = getView();
        if (view == null)
            return;

        // 拿到老数据
        List<Message> old = view.getRecyclerAdapter().getItems();

        // 差异计算
        DiffUiDataCallback<Message> callback = new DiffUiDataCallback<>(old, messages);
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);

        // 进行界面刷新
        refreshData(result, messages);
    }
}
