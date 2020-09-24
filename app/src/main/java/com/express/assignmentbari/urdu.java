package com.express.assignmentbari;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class urdu extends AppCompatActivity {
    databaseopenhelper dbhp;
    EditText editname,editsubject,editmarks,editid;
    Button btnadd,btnviewall,btnupdate,btndelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);
        dbhp=new databaseopenhelper(this);
        editname=(EditText)findViewById(R.id.editText_name);
        editsubject=(EditText)findViewById(R.id.editText_subject);
        editmarks=(EditText)findViewById(R.id.editText_marks);
        editid=(EditText)findViewById(R.id.editText_id);
        btnadd=(Button) findViewById(R.id.button_add);
        btnviewall=(Button) findViewById(R.id.button_view);
        btnupdate=(Button) findViewById(R.id.button_update);
        btndelete=(Button) findViewById(R.id.button_delete);
        adddata();
        updatedata();
        deletedata();
        viewall();
    }
    public void adddata(){
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isinserted=dbhp.insertdataurdu(editname.getText().toString(),editsubject.getText().toString(),editmarks.getText().toString());
                if (isinserted==true){
                    Toast.makeText(urdu.this,"Data is INSERTED",Toast.LENGTH_SHORT).show();
                    editname.setText("");
                    editsubject.setText("");
                    editmarks.setText("");
                    editid.setText("");}
                else
                    Toast.makeText(urdu.this,"Data is not INSERTED",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void viewall(){
        btnviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=dbhp.getalldataurdu();
                if (res.getCount()==0){
                    //show msg
                    showmsg("Error","Nothing Found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Subject :"+res.getString(2)+"\n");
                    buffer.append("Marks :"+res.getString(3)+"\n\n");

                }
                //show all data
                showmsg("urdu Data",buffer.toString());
            }
        });
    }
    public void showmsg(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void updatedata(){
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isupdated=dbhp.updatedataurdu(editid.getText().toString(),editname.getText().toString(),editsubject.getText().toString(),editmarks.getText().toString());
                if (isupdated==true){
                    Toast.makeText(urdu.this,"Data is UPDATED",Toast.LENGTH_SHORT).show();
                    editname.setText("");
                    editsubject.setText("");
                    editmarks.setText("");
                    editid.setText("");
                }
                else
                    Toast.makeText(urdu.this,"Data is not UPDATED",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void deletedata(){
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedrow=dbhp.deletedataurdu(editid.getText().toString());
                if (deletedrow >0){
                    Toast.makeText(urdu.this,"Data is DELETED",Toast.LENGTH_SHORT).show();
                    editname.setText("");
                    editsubject.setText("");
                    editmarks.setText("");
                    editid.setText("");}
                else
                    Toast.makeText(urdu.this,"Data is not DELETED",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
