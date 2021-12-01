package com.example.demofragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

public class InputDialogFragment extends DialogFragment {
    // 권장
    public interface InputListener{
        void onInput(String name);
    }

    public Dialog onCreateDialog(Bundle savedInterfaceState) {
        final EditText input = new EditText(getActivity());
        input.setId(View.generateViewId());

        return new AlertDialog.Builder(getActivity())
                .setTitle("입력")
                .setMessage("이름")
                .setView(input)
                .setPositiveButton("완료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 리스너 형식 변환 가능
                        // 메인액티비티 사용하여도 됨

                        InputListener listener = (InputListener) getActivity();
                        listener.onInput(input.getId() + input.getText().toString());

//                        MainActivity ma = (MainActivity) getActivity();
//                        // 메인액티비티 전체가 필요한건 아니니까 굳이 메인액티비티 가져올 필요가 없음
//                        ma.onInput(input.getText().toString());
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
