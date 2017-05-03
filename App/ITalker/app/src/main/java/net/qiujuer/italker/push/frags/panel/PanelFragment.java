package net.qiujuer.italker.push.frags.panel;


import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.qiujuer.genius.ui.Ui;
import net.qiujuer.italker.common.app.Fragment;
import net.qiujuer.italker.common.tools.UiTool;
import net.qiujuer.italker.face.Face;
import net.qiujuer.italker.push.R;

/**
 * 底部面板实现
 */
public class PanelFragment extends Fragment {


    public PanelFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_panel;
    }


    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        initFace(root);
        initRecord(root);
        initGallery(root);
    }


    private void initFace(View root) {
        final View facePanel = root.findViewById(R.id.lay_panel_face);

        View backspace = facePanel.findViewById(R.id.im_backspace);
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 删除逻辑
            }
        });

        TabLayout tabLayout = (TabLayout) facePanel.findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) facePanel.findViewById(R.id.pager);
        tabLayout.setupWithViewPager(viewPager);

        // 每一表情显示48dp
        final int minFaceSize = (int) Ui.dipToPx(getResources(), 48);
        final int totalScreen = UiTool.getScreenWidth(getActivity());
        final int spanCount = totalScreen / minFaceSize;


        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return Face.all(getContext()).size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }


            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // 添加的
                LayoutInflater inflater = LayoutInflater.from(getContext());
                RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.lay_face_content, container, false);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));

                // 设置Adapter
                

                // 添加
                container.addView(recyclerView);

                return recyclerView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                // 移除的
                container.removeView((View) object);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                // 拿到表情盘的描述
                return Face.all(getContext()).get(position).name;
            }
        });


    }

    private void initRecord(View root) {

    }

    private void initGallery(View root) {

    }


    public void showFace() {

    }

    public void showRecord() {

    }

    public void showGallery() {

    }
}
