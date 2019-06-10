package ir.androidlife.multiplecheckboxdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    // all items
    CharSequence[] items = {"چلسی", "منچستر یونایتد", "آرسنال", "منچستر سیتی", "لیورپول", "تاتنهام"};

    // if items are selected
    boolean[] selectedItems = {false, false, false, false, false, false};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        // show selected items
        textView.setText(itemsToString());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setCancelable(true);
                alertDialogBuilder.setTitle("باشگاه مورد علاقه خود را انتخاب کنید");
                alertDialogBuilder.setMultiChoiceItems(items, selectedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // set the selected items to true or false
                        selectedItems[i] = b;
                    }
                });
                alertDialogBuilder.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // show selected items
                        textView.setText(itemsToString());

                        dialogInterface.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.setCanceledOnTouchOutside(true);
                alertDialog.show();
            }
        });
    }

    // Get all items and show them if they are selected
    private String itemsToString() {
        String text = "";
        for (int i = 0; i < selectedItems.length; i++) {
            // check if item is selected and show it if it is
            if (selectedItems[i]) {
                text = text + items[i] + " ";
            }
        }
        return text.trim();
    }
}
