package sidikmilati1998gmail.com;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText tombolWaktu;
    //memberikan nama pda sebuah kolom edit text dengan nama tombolwaktu
    Button tombolMain;
    //memberikan nama oda sebuah tombol button dengan nama tombolmain
    Button tombolStop;
    //memberikan nama oda sebuah tombol button dengan nama tombolstop
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //digunkan untuk mendesripsikan nama daru sebuah kelas xml dengan nama activity main
        tombolWaktu=findViewById(R.id.et_waktu);
        //digunakan untuk mendeksrikan pada sebuah nama dari sebuah edit text yang sudah dibuat dan kumudian dipangggil sebuah nama dari sebuah kelas xml
        tombolMain=findViewById(R.id.bt_play);
        //digunakan untuk mendeksrikan pada sebuah nama dari sebuah edit text yang sudah dibuat dan kumudian dipangggil sebuah nama dari sebuah kelas xml
        tombolStop=findViewById(R.id.bt_stop);
        //digunakan untuk mendeksrikan pada sebuah nama dari sebuah edit text yang sudah dibuat dan kumudian dipangggil sebuah nama dari sebuah kelas xml
       tombolMain.setOnClickListener(this);
        tombolStop.setOnClickListener(this);
    }
    //memberikan sebuag perintah pada sebuah button dimana akan ada sebuah oerintah natinya yang berfungsi untuk play dan stop

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.bt_play:
        callPlay();
        break;
        //perintah yang dignakah untuk memberikan sebuah fungsi dimana namtinya pada sebuah button play da stop akan digunakan sebagai fungsi untuk membuat service
    //pada perintah diata dipanggil id dari setiap button dimana pada button play mebnggunkan sebuah  id bt_play
    //selanjutnya tredat perintah break yang befung sebagai berhenti atau jeda sesuai denga  inputan nanntinya pda sebuah kolom waktu
    case R.id.bt_stop:
        stopPlay();
        break;
    //perintah yang dignakah untuk memberikan sebuah fungsi dimana namtinya pada sebuah button play da stop akan digunakan sebagai fungsi untuk membuat service
    //pada perintah diata dipanggil id dari setiap button dimana pada button play mebnggunkan sebuah  id bt_play
    //selanjutnya tredat perintah break yang befung sebagai berhenti atau jeda sesuai denga  inputan nanntinya pda sebuah kolom waktu
}

    }
public void callPlay(){
        int detik=Integer.parseInt(tombolWaktu.getText().toString());
    Intent intent=new Intent(MainActivity.this,MyService.class);
    //perintah diats dibgunakan untuk mendeksipsikan dari sebuah fungsi callplay pada sebuah button play
    //diamana pda sebuah class clallplay nantiny pada saat rpgram dijlakan akan muncul sebuah kolom yang digunkan sebgai detik dan jeda
    //kemudian dilakukan sebuah intent antar ativit dimana pada sebuah class main activty nantinya akan dilempar pada sebuah class service pada saat di tekan pada sebuah tombol play
    PendingIntent pendingIntent=PendingIntent.getService(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
    AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
    if(alarmManager !=null){
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(detik*1000),pendingIntent);
        Toast.makeText(getApplicationContext(),"song play after"+detik+"second !",Toast.LENGTH_LONG).show();
    }
    //perintah diats diman digunkana sebagian 
}
public void stopPlay(){
        stopService(new Intent(MainActivity.this,MyService.class));
}
}
