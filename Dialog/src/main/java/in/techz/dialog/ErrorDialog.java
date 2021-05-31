package in.techz.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ErrorDialog implements View.OnClickListener{

    private final Activity activity;
    private Dialog dialog;
    private String error = "Error";
    private String descripion = "Please try again after sometime";

    private DialogResponse dialogResponse;


    public ErrorDialog(Activity activity) {
        this.activity = activity;
        showDialog();
    }

    public ErrorDialog(Activity activity, String error, String descripion) {
        this.activity = activity;
        this.error = error;
        this.descripion = descripion;
        showDialog();
    }

    public ErrorDialog(Activity activity, String error, String descripion, DialogResponse dialogResponse) {
        this.activity = activity;
        this.error = error;
        this.descripion = descripion;
        this.dialogResponse = dialogResponse;
        showDialog();
    }

    private void showDialog(){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.errorlayout);

        TextView tvError = dialog.findViewById(R.id.tvError);
        TextView tvErrorDescription = dialog.findViewById(R.id.tvErrorDescription);

        tvError.setText(error);
        tvErrorDescription.setText(descripion);

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
