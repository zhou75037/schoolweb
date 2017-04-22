package net.qiujuer.italker.push.frags.account;


import android.content.Context;

import net.qiujuer.italker.common.app.PresenterFragment;
import net.qiujuer.italker.factory.presenter.account.RegisterContract;
import net.qiujuer.italker.factory.presenter.account.RegisterPresenter;
import net.qiujuer.italker.push.R;

/**
 * 注册的界面
 */
public class RegisterFragment extends PresenterFragment<RegisterContract.Presenter>
        implements RegisterContract.View {
    private AccountTrigger mAccountTrigger;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 拿到我们的Activity的引用
        mAccountTrigger = (AccountTrigger) context;
    }

    @Override
    protected RegisterContract.Presenter initPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    public void registerSuccess() {

    }
}
