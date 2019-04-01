package indonesia.angarsalabs.belajarsharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private EditText input;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        input = findViewById(R.id.et_input);
        next = findViewById(R.id.btn_next);

        // TODO: Siapkan Shared Preference nya
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Save save an", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!input.getText().toString().equals("")) {

                    // TODO: Ini digunakan untuk menyimpan suatu value ke "Kata Yang Disimpan"
                    editor.putString("Kata Yang Disimpan", input.getText().toString());

                    // TODO: Tambahkan ini jika sudah tidak ada lagi yang dilakukan
                    editor.commit();

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));

                    // * Untuk mengakhiri activity ini. agar saat tombol back dipencet, tidak kesini lagi
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Isi dulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
