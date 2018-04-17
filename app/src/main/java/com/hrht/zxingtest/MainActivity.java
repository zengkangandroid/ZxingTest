package com.hrht.zxingtest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.hrht.zxingtest.utils.ZxingUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_pic;
    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_msg = findViewById(R.id.tv_msg);
        Button btn_create = findViewById(R.id.btn_create);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        Button btn_scan = findViewById(R.id.btn_scan);
        iv_pic = findViewById(R.id.iv_pic);

        Log.e("zengkang","第二次提交");
        Log.e("zengkang","创建分支");
        Log.e("zengkang","测试提交");
        Log.e("zengkang","再次测试提交");
        Log.e("zengkang","啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { 
            }
        });
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new IntentIntegrator(MainActivity.this)
//                        .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)// 扫码的类型,可选：一维码，二维码，一/二维码
                        .setOrientationLocked(false)//方向锁
                        .setCameraId(0)// 选择摄像头,可使用前置或者后置
//                        .setPrompt("请对准二维码")// 设置提示语
                        .setBeepEnabled(true)// 是否开启声音,扫完码之后会"哔"的一声
                        .setBarcodeImageEnabled(true)// 扫完码之后生成二维码的图片
                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
                        .initiateScan(); // 初始化扫描
            }
        });

    }

    @Override
    // 通过 onActivityResult的方法获取扫描回来的值
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(intentResult != null) {
            if(intentResult.getContents() == null) {
                Toast.makeText(this,"内容为空",Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this,"扫描成功",Toast.LENGTH_LONG).show();
                // ScanResult 为 获取到的字符串
                String ScanResult = intentResult.getContents();
                tv_msg.setText(ScanResult);
            }
        } else {
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_1:
                Bitmap bitmap =  ZxingUtils.createQRCodeWithLogo1("aaaa",500);
                iv_pic.setImageBitmap(bitmap);
                break;
            case R.id.btn_2:
                Bitmap bitmap2 =  ZxingUtils.createQRCodeWithLogo2("aaaa",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap2);
                break;
            case R.id.btn_3:
                Bitmap bitmap3 =  ZxingUtils.createQRCodeWithLogo3("aaaa",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap3);
                break;
            case R.id.btn_4:
                Bitmap bitmap4 =  ZxingUtils.createQRCodeWithLogo4("aaaa",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap4);
                break;
            case R.id.btn_5:
                Bitmap bitmap5 =  ZxingUtils.createQRCodeWithLogo5("aaaa",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap5);
                break;
            case R.id.btn_6:
                Bitmap bitmap6 =  ZxingUtils.createQRCodeWithLogo6("aaaa",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap6);
                break;
            default:
                break;
        }
    }
}
