package mobile.andorid.yjin.op_research_ver2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import static mobile.andorid.yjin.op_research_ver2.R.id.table;

//import static mobile.andorid.yjin.op_research_ver2.R.id.sign_table;

/**
 * Created by You Jin on 2017-05-14.
 */

public class GeneralActivity extends AppCompatActivity {

    final static int DIALOG_LIST_MESSAGE = 1;

    private int selectedID = -1;

    Spinner spinner;

    int x, y, v=0;
    int vars;
    int rows;
    EditText[] arrEditText;
    Spinner[] arrSpinner;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_main);

        RadioGroup rg = (RadioGroup) findViewById(R.id.general_radiogroup);

        Button b = (Button) findViewById(R.id.gmethod);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (selectedID) {
                    case R.id.general_tobinary:
                        break;
                    case R.id.general_tointeger:
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "조건을 선택하시오", Toast.LENGTH_SHORT).show();
                }
                showDialog(DIALOG_LIST_MESSAGE);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectedID = checkedId;
            }
        });

        spinner = (Spinner) findViewById(R.id.spinner_goal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.goal_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Intent i = getIntent();
        vars = i.getIntExtra("NUM_OF_VAR", 3);
        rows = i.getIntExtra("NUM_OF_ROW", 4);
        arrEditText = new EditText[vars*rows];
        arrSpinner = new Spinner[rows];
        Toast.makeText(getApplicationContext(), "vars=" + vars + ", rows=" + rows, Toast.LENGTH_SHORT).show();

        TableLayout t1 = (TableLayout) findViewById(table);
        EditText et;

        for (x = 0; x < rows; x++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            for (y = 0; y < vars; y++) {
                et = new EditText(this);
                et.setHint("상수");
                et.setId(v);
                arrEditText[v] = et;
                row.addView(et);
                v++;
            }

            Spinner constraints = new Spinner(this);
            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cons_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            constraints.setAdapter(adapter2);

            arrSpinner[x] = constraints;
            row.addView(constraints);
            t1.addView(row, x);
        }

//        TableRow cons = new TableRow(this);
//        TableRow.LayoutParams cp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
//        cons.setLayoutParams(cp);
//
//        for (int z = 0; z < rows; z++) {
////            Spinner constraints = (Spinner) findViewById(R.id.constraint_range);
//            Spinner constraints = new Spinner(this);
//            ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.cons_array, android.R.layout.simple_spinner_item);
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            constraints.setAdapter(adapter2);
//
//            ((ViewGroup) t2.getParent()).removeAllViews();
//            t2.addView(cons, z);
//        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_LIST_MESSAGE:
                final CharSequence[] items = {"Branch and Bound","Cutting Plane","Continuous Heuristic","Tabu Search","Simulated Annealing","Genetic"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("풀이 방법을 선택하시오");

                builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {

                        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();

                        switch (item) {
                            case 0:
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "풀이방법을 선택하시오", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("onClick()", "진입");

                        Log.d("onClick()", "MAX/MIN: " + spinner.getSelectedItem().toString());

                        Log.d("onClick()", "arrSpinner.length: " + arrSpinner.length);
                        for(int i=0; i<arrSpinner.length; i++)
                            Log.d("onClick()", "arrSpinner["+i+"]: " + arrSpinner[i].getSelectedItem().toString());

                        Log.d("onClick()", "arrEditText.length: " + arrEditText.length);
                        for(int i=0; i<arrEditText.length; i++)
                            Log.d("onClick()", "arrEditText["+i+"]: " + arrEditText[i].getText().toString());


                        String strUriParams = "&i0=";
//                        String[] iValues = new String[arr.length];

                        if (spinner.getSelectedItem().equals("MAX"))
                            strUriParams += "Maximize";
                        else if (spinner.getSelectedItem().equals("MIN"))
                            strUriParams += "Minimize"; //

//                        URL url = new URL("http://www.wolframalpha.com/widget/widgetPopup.jsp?p=v&id=1e692c6f72587b2cbd3e7be018fd8960&title=Linear%20Programming%20Calculator&theme=blue" + "?" + strUriParams);
//                        URLConnection conn = url.openConnection();

//                        for(int i= 0; i <= v; i++){
//                           arr = new EditText[v];
//                            arr[i] = (EditText)findViewById (i);
//
//                            try{
//                                String param = "value = " + URLEncoder.encode(arr[i]+"x"+i)
//                            }
//                        }



                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.wolframalpha.com/widget/widgetPopup.jsp?p=v&id=1e692c6f72587b2cbd3e7be018fd8960&title=Linear%20Programming%20Calculator&theme=blue"));


                        startActivity(intent);
                    }
                });

                AlertDialog alert = builder.create();
                return alert;
        }
        return null;
    }
}
