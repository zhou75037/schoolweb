package net.qiujuer.italker.factory.presenter.search;

import net.qiujuer.italker.factory.model.card.UserCard;
import net.qiujuer.italker.factory.presenter.BasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索人的实现
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class SearchUserPresenter extends BasePresenter<SearchContract.UserView>
        implements SearchContract.Presenter {
    public SearchUserPresenter(SearchContract.UserView view) {
        super(view);
    }

    @Override
    public void search(String content) {
        start();
        
        UserCard userCard = new UserCard();
        userCard.setName("dsadasd");
        userCard.setPortrait("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493146510453&di=d50f84921dec4c0a2b5732fbef71f5c4&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fzhidao%2Fwh%253D450%252C600%2Fsign%3Dca1fd2eb054f78f0805e92f74c012663%2Fbd3eb13533fa828b97ecd15cfb1f4134960a5a45.jpg");
        userCard.setFollow(true);

        List<UserCard> userCards = new ArrayList<>();
        userCards.add(userCard);
        userCards.add(userCard);
        userCards.add(userCard);
        userCards.add(userCard);

        getView().onSearchDone(userCards);



    }
}
