package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

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
        setContentView(R.layout.general_main);
        Button b = (Button) findViewById(R.id.gmethod);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_LIST_MESSAGE);
            }
        });
    }

}
