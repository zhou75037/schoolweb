package net.qiujuer.italker.factory.presenter.account;

import android.text.TextUtils;

import net.qiujuer.italker.common.Common;
import net.qiujuer.italker.factory.data.helper.AccountHelper;
import net.qiujuer.italker.factory.model.api.RegisterModel;
import net.qiujuer.italker.factory.presenter.BasePresenter;

import java.util.regex.Pattern;

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
        // 调用开始方法，在start中默认启动了Loading
        start();


        if (!checkMobile(phone)) {
            // 提示
        } else if (name.length() < 2) {
            // 姓名需要大于2位
        } else if (password.length() < 2) {
            // 密码需要大于6位
        } else {
            // 进行网络请求

            // 构造Model，进行请求调用
            RegisterModel model = new RegisterModel(phone, password, name);
            AccountHelper.register(model);

        }

    }

    /**
     * 检查手机号是否合法
     *
     * @param phone 手机号码
     * @return 合法为True
     */
    @Override
    public boolean checkMobile(String phone) {
        // 手机号不为空，并且满足格式
        return !TextUtils.isEmpty(phone)
                && Pattern.matches(Common.Constance.REGEX_MOBILE, phone);
    }
}
