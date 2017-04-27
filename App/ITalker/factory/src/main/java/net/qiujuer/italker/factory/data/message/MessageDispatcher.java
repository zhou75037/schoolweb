package net.qiujuer.italker.factory.data.message;

import net.qiujuer.italker.factory.data.user.UserDispatcher;
import net.qiujuer.italker.factory.model.card.MessageCard;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 消息中心的实现类
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class MessageDispatcher implements MessageCenter {
    private static MessageCenter instance;
    // 单线程池；处理卡片一个个的消息进行处理
    private final Executor executor = Executors.newSingleThreadExecutor();

    public static MessageCenter instance() {
        if (instance == null) {
            synchronized (UserDispatcher.class) {
                if (instance == null)
                    instance = new MessageDispatcher();
            }
        }
        return instance;
    }


    @Override
    public void dispatch(MessageCard... cards) {
        if (cards == null || cards.length == 0)
            return;

        // 丢到单线程池中
        executor.execute(new MessageCardHandler(cards));
    }

    /**
     * 消息的卡片的线程调度的处理会触发run方法
     */
    private class MessageCardHandler implements Runnable {
        private final MessageCard[] cards;

        MessageCardHandler(MessageCard[] cards) {
            this.cards = cards;
        }

        @Override
        public void run() {

        }
    }
}
