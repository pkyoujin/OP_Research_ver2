package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import static mobile.andorid.yjin.op_research_ver2.R.id.table;

/**
 * Created by You Jin on 2017-05-14.
 */

public class TSPActivity extends AppCompatActivity {

    final static int DIALOG_LIST_MESSAGE = 1;

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_LIST_MESSAGE:
                final CharSequence[] items = {"General","BnB","Tabu","Genetic","Simulated Annealing","1"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("풀이 방법을 선택하시오");
                builder.setItems(items, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show(); } }
                );
                AlertDialog alert = builder.create();
                return alert;
        }
        return null;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tsp_main);
        Button b = (Button) findViewById(R.id.gmethod);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_LIST_MESSAGE);
            }
        });

        Intent i = getIntent();
        int vars = i.getIntExtra("TNUM_OF_VAR", 3);
        int rows = i.getIntExtra("TNUM_OF_ROW", 4);
        Toast.makeText(getApplicationContext(), "vars=" + vars + ", rows=" + rows, Toast.LENGTH_SHORT).show();

        TableLayout tl = (TableLayout) findViewById(table);
        EditText et;

        for (int x = 0; x < rows; x++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            for (int y = 0; y <vars; y++) {

                et = new EditText(this);
                et.setHint("상수");
                row.addView(et);
            }

            tl.addView(row, x);
        }

    }
}