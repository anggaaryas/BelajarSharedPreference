package indonesia.angarsalabs.belajarsharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView info;
    private Button next, hapus;

    private String kata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        info = findViewById(R.id.tv_info);
        next = findViewById(R.id.btn_next);
        hapus = findViewById(R.id.btn_hapus);

        // TODO: Siapkan Shared Preference nya
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Save save an", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit(); // menggunakan final karena akan di akses di dalam inner class. lihat line 55 dan 58

        // TODO: Untuk mendapatkan value yang disimpan dari key "Kata Yang Disimpan"
        kata = pref.getString("Kata Yang Disimpan", "");

        if(!kata.equals("")){
            info.setText("Kata Yang Anda Simpan -> " + kata);
            next.setText("Ganti Kata");

            hapus.setVisibility(View.VISIBLE);
        } else {
            info.setText("Tidak ada yang disimpan");
            next.setText("Input Kata");

            hapus.setVisibility(View.GONE);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), InputActivity.class));
                finish();
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: untuk menghapus value dari key "Kata Yang Disimpan"
                editor.remove("Kata Yang Disimpan");

                // TODO: Tambahkan ini jika tidak ada lagi yang dilakukan
                editor.commit();

                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi
                finish();
            }
        });
    }
}
