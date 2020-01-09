package id.ac.poliban.mi.firah.magfirahe020317094;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch aSwitch = findViewById(R.id.swActive);
        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama);
        EditText etAlamat = findViewById(R.id.etAlamat);
        EditText etTelp = findViewById(R.id.etTelp);
        Button btClear = findViewById(R.id.btClear);
        Button btSubmit = findViewById(R.id.btSubmit);
        RadioGroup rgGroup = findViewById(R.id.rgJenis);
        RadioButton rbLakiLaki = findViewById(R.id.rbLakiLaki);
        RadioButton rbPerempuan = findViewById(R.id.rbPerempuan);


        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (aSwitch.isChecked()) {
                etNim.setEnabled(true);
                etNama.setEnabled(true);
                etAlamat.setEnabled(true);
                etTelp.setEnabled(true);
                btClear.setEnabled(true);
                btSubmit.setEnabled(true);
            }else {
                etNim.setEnabled(false);
                etNama.setEnabled(false);
                etAlamat.setEnabled(false);
                etTelp.setEnabled(false);
                btClear.setEnabled(false);
                btSubmit.setEnabled(false);
            }
        });


        btSubmit.setOnClickListener(v -> {
            String jenisKelamin = "";
            if (rbLakiLaki.isChecked()) {
                jenisKelamin+= "Laki Laki";
            }
            if (rbPerempuan.isChecked()){
                jenisKelamin+= "Perempuan";
            }


            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("INFO")
                    .setMessage("Nim                  : " + etNim.getText().toString() + "\n" +
                                "Nama               : " + etNama.getText().toString() + "\n" +
                                "Jenis Kelamin     : " + jenisKelamin.toString() + "\n" +
                                "Alamat               : " + etAlamat.getText().toString() + "\n" +
                                "Telephone         : " + etTelp.getText().toString() + "\n")
                    .setNegativeButton("CANCEL", null)
                    .setPositiveButton("OK", null).show();
        });

        btClear.setOnClickListener(v -> {
            etNim.setText("");
            etNama.setText("");
            etAlamat.setText("");
            etTelp.setText("");
            rgGroup.clearCheck();
            etNim.requestFocus();
        });
    }

}
