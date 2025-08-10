package com.company.app;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView=findViewById(R.id.mainImageView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        
        switch (id) {
            case R.id.set_brick_image:
                AlertDialog.Builder adb=new AlertDialog.Builder(this);
                adb.setTitle(getString(R.string.set_brick));
                adb.setMessage(getString(R.string.dialog_msg));
                adb.setPositiveButton(getString(R.string.dialog_yes),new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface di, int i){
                            imgView.setImageResource(R.raw.brick);
                        }
                    });
                adb.setNegativeButton(getString(R.string.dialog_no), /*null*/new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface di, int i){
                            di.dismiss();
                        }
                    });
                adb.create().show();
                break;
            case R.id.exit_app:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
