package com.vic.fileoperation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("test1111哎哎哎");
        
        
        
        setContentView(R.layout.main);
        final EditText filename = (EditText) this.findViewById(R.id.filename);
        final EditText filecontent = (EditText) this.findViewById(R.id.content);
        Button btn = (Button) this.findViewById(R.id.btn);
        Button rbtn = (Button) this.findViewById(R.id.rbtn);
        Button sbtn1 = (Button) this.findViewById(R.id.sbtn1);
        Button rbtn1 = (Button) this.findViewById(R.id.rbtn1);
        rbtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
						
					
					FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory()+File.separator+filename.getText().toString());
					byte[] data = new byte[fis.available()];
					fis.read(data);
					System.out.println(new String(data));
					filecontent.setText(new String(data));
					fis.close();
					Toast.makeText(getApplicationContext(), R.string.operation_suc, Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(getApplicationContext(), R.string.sdcarderror, Toast.LENGTH_SHORT).show();
						
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				}
			}
		});
        sbtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			try {
				if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
					FileOutputStream fos = new FileOutputStream(Environment.getExternalStorageDirectory()+File.separator+filename.getText().toString());
					fos.write(filecontent.getText().toString().getBytes());
					fos.flush();
					fos.close();
					Toast.makeText(getApplicationContext(), R.string.operation_suc, Toast.LENGTH_SHORT).show();
					}else{
						Toast.makeText(getApplicationContext(), R.string.sdcarderror, Toast.LENGTH_SHORT).show();
						
					}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
			} finally{
				filename.setText("");
				filecontent.setText("");
			}
			}
		});
        rbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					FileInputStream fis = getApplicationContext().openFileInput(filename.getText().toString());
					byte[] data = new byte[fis.available()];
					fis.read(data);
					System.out.println(new String(data));
					filecontent.setText(new String(data));
					fis.close();
					Toast.makeText(getApplicationContext(), R.string.operation_suc, Toast.LENGTH_SHORT).show();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				}
			}
		});
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
						FileOutputStream fos = getApplicationContext().openFileOutput(filename.getText().toString(), MODE_PRIVATE);
						fos.write(filecontent.getText().toString().getBytes());
						fos.flush();
						fos.close();
						Toast.makeText(getApplicationContext(), R.string.operation_suc, Toast.LENGTH_SHORT).show();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Toast.makeText(getApplicationContext(), R.string.operation_fail, Toast.LENGTH_SHORT).show();
				} finally{
					filename.setText("");
					filecontent.setText("");
				}
			}
		});
    }
}
