package net.qiujuer.italker.factory.presenter.account;

import net.qiujuer.italker.factory.presenter.BasePresenter;

/**
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {
    public RegisterPresenter(RegisterContract.View view) {
        super(view);
    }

    @Override
    public void register(String phone, String name, String password) {

    }

    @Override
    public boolean checkMobile(String phone) {
        return false;
    }
}
