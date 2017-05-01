package net.qiujuer.italker.push.frags.message;


import net.qiujuer.italker.factory.model.db.Group;
import net.qiujuer.italker.factory.model.db.view.MemberUserModel;
import net.qiujuer.italker.factory.presenter.message.ChatContract;
import net.qiujuer.italker.factory.presenter.message.ChatGroupPresenter;
import net.qiujuer.italker.push.R;

import java.util.List;

/**
 * 群聊天界面实现
 */
public class ChatGroupFragment extends ChatFragment<Group>
        implements ChatContract.GroupView {


    public ChatGroupFragment() {
        // Required empty public constructor
    }

    @Override
    protected int getHeaderLayoutId() {
        return R.layout.lay_chat_header_group;
    }

    @Override
    protected ChatContract.Presenter initPresenter() {
        return new ChatGroupPresenter(this, mReceiverId);
    }

    @Override
    public void onInit(Group group) {

    }

    @Override
    public void onInitGroupMembers(List<MemberUserModel> members, int moreCount) {

    }

    @Override
    public void showAdminOption(boolean isAdmin) {

    }


}
