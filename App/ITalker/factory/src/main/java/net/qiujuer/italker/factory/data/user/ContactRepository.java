package net.qiujuer.italker.factory.data.user;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;

import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.QueryTransaction;

import net.qiujuer.italker.factory.data.DataSource;
import net.qiujuer.italker.factory.data.helper.DbHelper;
import net.qiujuer.italker.factory.model.db.User;
import net.qiujuer.italker.factory.model.db.User_Table;
import net.qiujuer.italker.factory.persistence.Account;

import java.util.List;

/**
 * 联系人仓库
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class ContactRepository implements ContactDataSource,
        QueryTransaction.QueryResultListCallback<User>,
        DbHelper.ChangedListener<User> {

    private DataSource.SucceedCallback<List<User>> callback;

    @Override
    public void load(DataSource.SucceedCallback<List<User>> callback) {
        this.callback = callback;
        // 对数据辅助工具类添加一个数据更新的监听
        DbHelper.addChangedListener(User.class, this);

        // 加载本地数据库数据
        SQLite.select()
                .from(User.class)
                .where(User_Table.isFollow.eq(true))
                .and(User_Table.id.notEq(Account.getUserId()))
                .orderBy(User_Table.name, true)
                .limit(100)
                .async()
                .queryListResultCallback(this)
                .execute();
    }

    @Override
    public void dispose() {
        this.callback = null;
        // 取消对数据集合的监听
        DbHelper.removeChangedListener(User.class, this);
    }

    @Override
    public void onListQueryResult(QueryTransaction transaction, @NonNull List<User> tResult) {
        // 数据库加载数据成功
        if (callback != null) {
            callback.onDataLoaded(tResult);
        }
    }

    @Override
    public void onDataSave(User... list) {
        // 当数据库数据变更的操作

        for (User user : list) {
            // 是关注的人，同时不是我自己
            if(isRequired(user)){

            }
        }

    }

    @Override
    public void onDataDelete(User... list) {
        // 但数据库数据删除的操作
    }

    private void insertOrUpdate(User user){
        
    }


    /**
     * 检查一个User是否是我需要关注的数据
     * @param user User
     * @return True是我关注的数据
     */
    private boolean isRequired(User user){
        return user.isFollow()&&!user.getId().equals(Account.getUserId());
    }
}
