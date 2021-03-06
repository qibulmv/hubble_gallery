package com.derek_s.hubble_gallery.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.derek_s.hubble_gallery.R;
import com.derek_s.hubble_gallery.utils.svg.SvgView;
import com.derek_s.hubble_gallery.utils.ui.FontFactory;
import com.nineoldandroids.animation.Animator;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by dereksmith on 15-05-15.
 */
public class FragWelcomeOutline extends Fragment {

    @InjectView(R.id.hubble_outline)
    SvgView hubbleOutline;
    @InjectView(R.id.tv_app_title)
    TextView tvTitle;
    @InjectView(R.id.tv_scroll_down)
    TextView tvScrollDown;
    Handler showTitleHandler;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedState) {
        View rootView = inflater.inflate(R.layout.frag_welcome_outline, container, false);
        ButterKnife.inject(this, rootView);

        /*
        show initial intro animation
        */
        YoYo.with(Techniques.FadeIn).duration(800).playOn(hubbleOutline);
        hubbleOutline.setSvgResource(R.raw.hubble_outline);
        hubbleOutline.setVisibility(View.VISIBLE);
        tvTitle.setTypeface(FontFactory.getCondensedLight(getActivity()));
        tvScrollDown.setTypeface(FontFactory.getCondensedRegular(getActivity()));

        showTitleHandler = new Handler();
        showTitleHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvTitle.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.FadeInUp).duration(1000).playOn(tvTitle);
                tvScrollDown.setVisibility(View.VISIBLE);
                YoYo.with(Techniques.FadeIn).duration(1000).playOn(tvScrollDown);
            }
        }, 4000);

        return rootView;
    }

}