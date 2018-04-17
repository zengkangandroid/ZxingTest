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

public class MainActivity extends AppCompatActivity {

    private ImageView iv_pic;
    private TextView tv_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_msg = findViewById(R.id.tv_msg);
        Button btn_create = findViewById(R.id.btn_create);
        Button btn_scan = findViewById(R.id.btn_scan);
        iv_pic = findViewById(R.id.iv_pic);

        Log.e("zengkang","第二次提交");
        Log.e("zengkang","创建分支");
        Log.e("zengkang","测试提交");
        Log.e("zengkang","再次测试提交");

        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bitmap bitmap = ZxingUtils.createBitmap("nihaoa");

//                Bitmap bitmap =  ZxingUtils.createQRCodeWithLogo3("http://www.jianshu.com/users/4a4eb4feee62/latest_articles",500,getResources().getDrawable(R.mipmap.ic_launcher));
                Bitmap bitmap =  ZxingUtils.createQRCodeWithLogo4("aaaa",500);
                iv_pic.setImageBitmap(bitmap);
            }
        });
//http://www.baidu.com/link?url=wWSmbvjuNe2LzYTcCUDcPIkyhrz8zdIV9t2LBDsgg1lQiCmOOPDzdxkgDmLa02TkY51irTyynwU_xG4AdhwtzWxL6q4OsG6nv2SUHLPrK72DdsdSKqNNMsynqmfDNBqxa92DNLqiXygNZdYEhNxCbDbqAdu1h1gC2mEuBKNGrRz0hKemUmrydCpgCJE0m3PnTe5g_jbqCFA2ULUp_qZ9xLSghYrCSwfFS1hnP3j_m37ZANtbr9hN5137F_wYRHQ27J5fUERvnutfnmbJ--flQ4dYPRbY7134UXQY3gcSn1enIborwqYWe-hB3xo1TEenjCcs_xiyJQG_NmhcRSZZS8OCAqQtw9konn8nGAtXk8rOj6yhZE08SFEmXhVntGKknP9tLXr8HbQhUzlQZb4deOK-oL7i3cQquMZqiscSx8XwrOcY4od6m7Qfi8zNxpiqRk6lU-22FsEMRnJlOCuhk3T5hTjZw673nfFYjySC5ywgoEbxPScdZOYsPylx83MUxbeCMOqZFAkBXMJiVV9_v03IKRp78HpSmI3kRP5gUkUi6yCXSIH8vwhR_bnXIhVL4S8wZW0B_a780mzvdhSkefhLqvufxnTFE_zvTvtwDsVrnuTschZOVoPXhVEawV44&timg=https%3A%2F%2Fss0.bdstatic.com%2F94oJfD_bAAcT8t7mm9GUKT-xh_%2Ftimg%3Fimage%26quality%3D100%26size%3Db4000_4000%26sec%3D1523871947%26di%3D6b088240e24495b9e7355f878e724427%26src%3Dhttp%3A%2F%2Fnews.hainan.net%2FEditor%2Fimg%2F201411%2F20141117%2Fbig%2F2014111709041942_9984304.jpg&click_t=1523871947102&s_info=1232_848&wd=&eqid=ada0010500029605000000055ad470cb
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Bitmap bitmap =  ZxingUtils.createQRCodeWithLogo1("aaaa",500);
                Bitmap bitmap =  ZxingUtils.createQRCodeWithLogo3("http://www.baidu.com/link?url=wWSmbvjuNe2LzYTcCUDcPIkyhrz8zdIV9t2LBDsgg1lQiCmOOPDzdxkgDmLa02TkY51irTyynwU_xG4AdhwtzWxL6q4OsG6nv2SUHLPrK72DdsdSKqNNMsynqmfDNBqxa92DNLqiXygNZdYEhNxCbDbqAdu1h1gC2mEuBKNGrRz0hKemUmrydCpgCJE0m3PnTe5g_jbqCFA2ULUp_qZ9xLSghYrCSwfFS1hnP3j_m37ZANtbr9hN5137F_wYRHQ27J5fUERvnutfnmbJ--flQ4dYPRbY7134UXQY3gcSn1enIborwqYWe-hB3xo1TEenjCcs_xiyJQG_NmhcRSZZS8OCAqQtw9konn8nGAtXk8rOj6yhZE08SFEmXhVntGKknP9tLXr8HbQhUzlQZb4deOK-oL7i3cQquMZqiscSx8XwrOcY4od6m7Qfi8zNxpiqRk6lU-22FsEMRnJlOCuhk3T5hTjZw673nfFYjySC5ywgoEbxPScdZOYsPylx83MUxbeCMOqZFAkBXMJiVV9_v03IKRp78HpSmI3kRP5gUkUi6yCXSIH8vwhR_bnXIhVL4S8wZW0B_a780mzvdhSkefhLqvufxnTFE_zvTvtwDsVrnuTschZOVoPXhVEawV44&timg=https%3A%2F%2Fss0.bdstatic.com%2F94oJfD_bAAcT8t7mm9GUKT-xh_%2Ftimg%3Fimage%26quality%3D100%26size%3Db4000_4000%26sec%3D1523871947%26di%3D6b088240e24495b9e7355f878e724427%26src%3Dhttp%3A%2F%2Fnews.hainan.net%2FEditor%2Fimg%2F201411%2F20141117%2Fbig%2F2014111709041942_9984304.jpg&click_t=1523871947102&s_info=1232_848&wd=&eqid=ada0010500029605000000055ad470cb",500,getResources().getDrawable(R.mipmap.a));
                iv_pic.setImageBitmap(bitmap);


//                new IntentIntegrator(MainActivity.this)
////                        .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)// 扫码的类型,可选：一维码，二维码，一/二维码
//                        .setOrientationLocked(false)//方向锁
//                        .setCameraId(0)// 选择摄像头,可使用前置或者后置
////                        .setPrompt("请对准二维码")// 设置提示语
//                        .setBeepEnabled(true)// 是否开启声音,扫完码之后会"哔"的一声
//                        .setBarcodeImageEnabled(true)// 扫完码之后生成二维码的图片
//                        .setCaptureActivity(ScanActivity.class) // 设置自定义的activity是ScanActivity
//                        .initiateScan(); // 初始化扫描
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
}
