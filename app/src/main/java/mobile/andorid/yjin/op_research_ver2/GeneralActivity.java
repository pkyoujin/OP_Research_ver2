package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import static mobile.andorid.yjin.op_research_ver2.R.id.table;

/**
 * Created by You Jin on 2017-05-14.
 */

public class GeneralActivity extends AppCompatActivity {

    final static int DIALOG_LIST_MESSAGE = 1;

    int myNum = 0;

//
//        final EditText et = (EditText) findViewById(R.id.general_getx);
//        final TableLayout tableLayout = (TableLayout) findViewById(R.id.table); // 테이블 id 명
//
//        try {
//            myNum = Integer.parseInt(et.getText().toString());
//
//            for (int i = 0; i < myNum; i++) { // Creation row
//                final TableRow tableRow = new TableRow(this);
//                tableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
//
//                for(int j = 0 ; j < myNum ; j++){
//                    final TextView text = new TextView(this);
//
//                    text.setText( i + j + "|");
//                    text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
//                    tableRow.addView(text);
//                }
//
//                tableLayout.addView(tableRow);
//            }
//
//        } catch(NumberFormatException nfe) {
//            System.out.println("Could not parse " + nfe);
//        }
//
//    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_LIST_MESSAGE:
                final CharSequence[] items = {"Branch and Bound","Cutting Plane","Continuous Heuristic","Tabu Search","Simulated Annealing","Genetic"};

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
        setContentView(R.layout.general_main);
        Button b = (Button) findViewById(R.id.gmethod);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_LIST_MESSAGE);
            }
        });

        Intent i = getIntent();
        int vars = i.getIntExtra("NUM_OF_VAR", 3);
        int rows = i.getIntExtra("NUM_OF_ROW", 4);
        Toast.makeText(getApplicationContext(), "vars=" + vars + ", rows=" + rows, Toast.LENGTH_SHORT).show();

        TableLayout tl = (TableLayout) findViewById(table);

        CheckBox checkBox;
        EditText et;

        for (int x = 0; x < rows; x++) {

            for (int y = 0; y < vars; y++) {

                TableRow row = new TableRow(this);
                TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                row.setLayoutParams(lp);
                checkBox = new CheckBox(this);
                et = new EditText(this);
                checkBox.setText("hello");
                et.setHint("상수");
                row.addView(checkBox);
                row.addView(et);
                tl.addView(row, x);
            }
        }
    }

}
