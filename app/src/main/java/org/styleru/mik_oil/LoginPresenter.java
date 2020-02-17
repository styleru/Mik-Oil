package org.styleru.mik_oil;

import android.os.Handler;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import static java.lang.Math.random;

@InjectViewState
public class LoginPresenter extends MvpPresenter<LoginView> {
    private int progressStatus = 0;
    Handler handler = new Handler();

    void showProgressBar(){
        getViewState().changeVisibility(true);

        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    // Update the progress bar and display the
                    //current value in the text view
                    handler.post(new Runnable() {
                        public void run() {
                            getViewState().increaseProgress();
                        }
                    });
                    try {
                        // Sleep for 20 milliseconds.
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                getViewState().changeVisibility(false);
                getViewState().showToast(generateToastText());
            }
        }).start();

    }

//    private void stopProgressBar(){
//        Activity activity = getActivity();
//        if (activity != null) {
//            activity.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    circularProgressBar.setVisibility(View.INVISIBLE);
//                    showToast();
//                }
//            });
//        }
//    }

    private String generateToastText(){
        boolean state = random() >= 0.5;
        String toast_text = state ? "Success!" : "Failed!";

        return toast_text;
    }


}
