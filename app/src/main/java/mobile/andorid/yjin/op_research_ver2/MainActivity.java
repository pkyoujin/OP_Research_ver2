package mobile.andorid.yjin.op_research_ver2;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static mobile.andorid.yjin.op_research_ver2.R.id.g_confirm;

//import static mobile.andorid.yjin.op_research_ver2.R.id.g_confirm;

public class MainActivity extends AppCompatActivity {

    MainDialog1 gDialog;
    MainDialog2 tDialog;

    private static final int DIALOG_GENERAL = 1;

    EditText gv, gc, tv, tc;

    int gv_num, gc_num, tv_num, tc_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        gv = (EditText) findViewById(R.id.general_variable);
//        gc = (EditText) findViewById(R.id.general_constraint);

        tv = (EditText) findViewById(R.id.tsp_variable);
        tc = (EditText) findViewById(R.id.tsp_constraint);


        Button togeneral = (Button) findViewById(R.id.general_layout);
        togeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View target) {

                gDialog = new MainDialog1(MainActivity.this);
//                gDialog.show(getFragmentManager(),"General");
                gDialog.show();
            }
        });

        Button totsp = (Button) findViewById(R.id.tsp_layout);
        totsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View target) {
                tDialog = new MainDialog2();
                tDialog.show(getFragmentManager(), "TSP");

            }
        });}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public class MainDialog1 extends Dialog { //d

        public MainDialog1(Activity a) {
            super(a);
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.gdialog_main);

            gv = (EditText) findViewById(R.id.general_variable);
            gc = (EditText) findViewById(R.id.general_constraint);
            Button btnConfirm = (Button) findViewById(R.id.g_confirm);
            Button btnCancel = (Button) findViewById(R.id.g_cancel);

            View.OnClickListener btnClick = new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    switch (v.getId()) {
                        case g_confirm:
                            Intent g_intent = new Intent(getApplicationContext(), GeneralActivity.class);

                            Log.v("MainActivity", "gv = " + gv.getText());
                            gv_num = Integer.parseInt("" + gv.getText());
                            gc_num = Integer.parseInt("" + gc.getText());

                            Log.v("MainActivity", "gv=" + gv_num + ", gc=" + gc_num);

                            g_intent.putExtra("NUM_OF_VAR", gv_num);
                            g_intent.putExtra("NUM_OF_ROW", gc_num);

                            startActivity(g_intent);
                            gDialog.dismiss();
                            break;
                        case R.id.g_cancel:
                            gDialog.dismiss();
                            break;
                    }
                }
            };

            btnConfirm.setOnClickListener(btnClick);
            btnCancel.setOnClickListener(btnClick);
        }

//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
//            LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
//            mBuilder.setView(mLayoutInflater.inflate(R.layout.gdialog_main, null));
//            mBuilder.setTitle("General Problem");
//            mBuilder.setMessage("변수의 값을 입력하시오");
//
//
//
//            return mBuilder.create();
//        }

//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
//            LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
//            mBuilder.setView(mLayoutInflater.inflate(R.layout.gdialog_main, null));
//            mBuilder.setTitle("General Problem");
//            mBuilder.setMessage("변수의 값을 입력하시오");
//
//            gv = (EditText) findViewById(R.id.general_variable);
//            gc = (EditText) findViewById(R.id.general_constraint);
//
//            return mBuilder.create();
//
//        }

        @Override
        public void onStop() {
            super.onStop();
        }

    }

//    public void ONCLICK_DIALOG1(View v) {
//
//
//        switch (v.getId()) {
//            case g_confirm:
//                Intent g_intent = new Intent(getApplicationContext(), GeneralActivity.class);
//
//                Log.v("MainActivity", "gv = " + gv.getText());
//                gv_num = Integer.parseInt("" + gv.getText());
//                gc_num = Integer.parseInt("" + gc.getText());
//
//                Log.v("MainActivity", "gv=" + gv_num + ", gc=" + gc_num);
//
//                g_intent.putExtra("NUM_OF_VAR", gv_num);
//                g_intent.putExtra("NUM_OF_ROW", gc_num);
//
//                startActivity(g_intent);
//                gDialog.dismiss();
//                break;
//            case R.id.g_cancel:
//                gDialog.dismiss();
//                break;
//        }
//    }

    public static class MainDialog2 extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
            LayoutInflater mLayoutInflater = getActivity().getLayoutInflater();
            mBuilder.setView(mLayoutInflater.inflate(R.layout.tdialog_main, null));
            mBuilder.setTitle("TSP Problem");
            mBuilder.setMessage("X x Y 의 값을 입력하시오");
            return mBuilder.create();
        }
        @Override
        public void onStop() {
            super.onStop();
        }
    }

    public void ONCLICK_DIALOG2(View v) {
        switch (v.getId()) {
            case R.id.t_confirm:
                Intent t_intent = new Intent(getApplicationContext(), TSPActivity.class);

//                tv_num = Integer.parseInt(gv.getText().toString());
//                tc_num = Integer.parseInt(gc.getText().toString());

                t_intent.putExtra("TNUM_OF_VAR", tv_num);
                t_intent.putExtra("TNUM_OF_ROW", tc_num);

                startActivity(t_intent);
                tDialog.dismiss();
                break;
            case R.id.t_cancel:
                tDialog.dismiss();
                break;
        }

    }
}
