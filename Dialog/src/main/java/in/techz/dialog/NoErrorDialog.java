package in.techz.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class NoErrorDialog implements View.OnClickListener{

    private Activity activity;
    private Dialog dialog;
    private String Success = "Successful";
    private String descripion = "Thank you";

    private DialogResponse dialogResponse;


    public NoErrorDialog(Activity activity) {
        this.activity = activity;
        showDialog();
    }

    public NoErrorDialog(Activity activity, String Success, String descripion) {
        this.activity = activity;
        this.Success = Success;
        this.descripion = descripion;
        showDialog();
    }

    public NoErrorDialog(Activity activity, String Success, String descripion, DialogResponse dialogResponse) {
        this.activity = activity;
        this.Success = Success;
        this.descripion = descripion;
        this.dialogResponse = dialogResponse;
        showDialog();
    }

    private void showDialog(){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.noerrorlayout);

        TextView tvNoError = dialog.findViewById(R.id.tvNoError);
        TextView tvNoErrorDescription = dialog.findViewById(R.id.tvNoErrorDescription);

        tvNoError.setText(Success);
        tvNoErrorDescription.setText(descripion);

        Button btnCancel = dialog.findViewById(R.id.ibCancel);
        btnCancel.setOnClickListener(this);

        dialog.show();
    }

    @Override
    public void onClick(View view) {
        dialog.dismiss();
        if (dialogResponse!=null)
            dialogResponse.dialogFinish(true);
    }
}
