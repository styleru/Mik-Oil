package org.styleru.mik_oil.profile;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.squareup.picasso.Picasso;

import org.styleru.mik_oil.R;
import org.styleru.mik_oil.picasso_circle.CropCircleTransformation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {

    @BindView(R.id.logout)
    TextView logout;
    @BindView(R.id.add_photo)
    TextView addPhoto;
    @BindView(R.id.photo)
    ImageView photo;

    private Unbinder unbinder;

    @InjectPresenter
    ProfilePresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        SpannableString spannableString = new SpannableString(logout.getText());
        spannableString.setSpan(new UnderlineSpan(), 0, logout.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        logout.setText(spannableString);

        SpannableString spannableStringPhoto = new SpannableString(addPhoto.getText());
        spannableStringPhoto.setSpan(new UnderlineSpan(), 0, addPhoto.getText().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        addPhoto.setText(spannableStringPhoto);

        CropCircleTransformation crop = new CropCircleTransformation();

        Picasso.get()
                .load(R.drawable.try2)
                .transform(crop)
                .into(photo);
    }


    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

}
