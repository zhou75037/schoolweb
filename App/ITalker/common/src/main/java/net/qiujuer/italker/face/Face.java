package net.qiujuer.italker.face;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.Spannable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 表情工具类
 *
 * @author qiujuer Email:qiujuer@live.cn
 * @version 1.0.0
 */
public class Face {

    // 获取所有的表情
    public static List<FaceTab> all(@NonNull Context context) {
        return new ArrayList<>();
    }

    // 输入表情到editable
    public static void inputFace(@NonNull Context context, final Editable editable,
                                 final Face.Bean bean, final int size) {

    }

    // 从spannable解析表情并替换显示
    public static List<FaceTab> decode(@NonNull View target, final Spannable spannable, final int size) {
        return null;
    }


    /**
     * 每一个表情盘，含有很多表情
     */
    public static class FaceTab {
        public List<Bean> faces = new ArrayList<>();
        public String name;
        // 预览图, 包括了drawable下面的资源int类型
        public Object preview;
    }

    /**
     * 每一个表情
     */
    public static class Bean {
        public static String key;
        public static String desc;
        public static Object source;
        public static Object preview;
    }

}
