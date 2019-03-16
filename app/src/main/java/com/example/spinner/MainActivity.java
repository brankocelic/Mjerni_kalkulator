package com.example.spinner;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner unitTypeSpinner;

    private EditText amountTextView;

    ArrayList imena, decimale;

    TextView teaspoonTextView, tablespoonTextView, cupTextView, ounceTextView,

    pintTextView, quartTextView, gallonTextView, poundTextView,

    millilitersTextView, literTextView, milligramTextView, kilogramTextView;

    @Override


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imena = new ArrayList<String>();

        imena.add("teaspoon");
        imena.add("cup");
        imena.add("tablespoon");
        imena.add("ounce");
        imena.add("pint");
        imena.add("quart");
        imena.add("gallon");
        imena.add("pound");
        imena.add("milliliters");
        imena.add("liter");
        imena.add("kilogram");
        imena.add("milligram");

        decimale = new ArrayList<Double>();

        decimale.add(1.0);
        decimale.add(0.0208);
        decimale.add(0.3333);
        decimale.add(0.1666);
        decimale.add(0.0104);
        decimale.add(0.0052);
        decimale.add(0.0013);
        decimale.add(0.0125);
        decimale.add(4.9289);
        decimale.add(0.0049);
        decimale.add(0.0057);
        decimale.add(5687.5);


        initializeTextViews();

        addItemsToUnitTypeSpinner();

        addListenerToUnitTypeSpinner();


    }


    public void initializeTextViews() {

        amountTextView = findViewById(R.id.amount_text_view);

        teaspoonTextView = findViewById(R.id.teaspoon_text_view);

        tablespoonTextView = findViewById(R.id.tablespoon_text_view);

        cupTextView = findViewById(R.id.cup_text_view);

        ounceTextView = findViewById(R.id.ounce_text_view);

        pintTextView = findViewById(R.id.pint_text_view);

        quartTextView = findViewById(R.id.quart_text_view);

        gallonTextView = findViewById(R.id.gallon_text_view);

        poundTextView = findViewById(R.id.pound_text_view);

        millilitersTextView = findViewById(R.id.milliliters_text_view);

        literTextView = findViewById(R.id.liter_text_view);

        milligramTextView = findViewById(R.id.milligram_text_view);

        kilogramTextView = findViewById(R.id.kilogram_text_view);

    }


    public void addItemsToUnitTypeSpinner() {

        unitTypeSpinner = findViewById(R.id.unit_type_spinner);

        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.conversion_types, android.R.layout.simple_spinner_item);

        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);

    }


    public void addListenerToUnitTypeSpinner() {

        unitTypeSpinner = findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            public void onItemSelected(AdapterView<?> parent, View arg1, int pos, long arg3) {

                String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();

                postaviSveUTextViwe(itemSelectedInSpinner, Double.parseDouble(amountTextView.getText().toString()));

            }


            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });

    }

    @SuppressLint("SetTextI18n")
    public void postaviSveUTextViwe(String odabraniSpinner, double vrijednost) {

        DecimalFormat cetDecimale = new DecimalFormat("#.####");
        if (odabraniSpinner.equals("teaspoon")) {
            teaspoonTextView.setText("" + cetDecimale.format((double) decimale.get(0) * vrijednost) + " " + imena.get(0));
            tablespoonTextView.setText("" + cetDecimale.format((double) decimale.get(2) * vrijednost) + " " + imena.get(2));
            cupTextView.setText("" + cetDecimale.format((double) decimale.get(1) * vrijednost) + " " + imena.get(1));
            ounceTextView.setText("" + cetDecimale.format((double) decimale.get(3) * vrijednost) + " " + imena.get(3));
            pintTextView.setText("" + cetDecimale.format((double) decimale.get(4) * vrijednost) + " " + imena.get(4));
            quartTextView.setText("" + cetDecimale.format((double) decimale.get(5) * vrijednost) + " " + imena.get(5));
            gallonTextView.setText("" + cetDecimale.format((double) decimale.get(6) * vrijednost) + " " + imena.get(6));
            poundTextView.setText("" + cetDecimale.format((double) decimale.get(7) * vrijednost) + " " + imena.get(7));
            millilitersTextView.setText("" + cetDecimale.format((double) decimale.get(8) * vrijednost) + " " + imena.get(8));
            literTextView.setText("" + cetDecimale.format((double) decimale.get(9) * vrijednost) + " " + imena.get(9));
            milligramTextView.setText("" + cetDecimale.format((double) decimale.get(11) * vrijednost) + " " + imena.get(11));
            kilogramTextView.setText("" + cetDecimale.format((double) decimale.get(10) * vrijednost) + " " + imena.get(10));
        } else {

            double uTeaSpoons = toTeaSpoon(odabraniSpinner, Double.parseDouble(amountTextView.getText().toString()));
            Log.i("aaaaaaaaaaaaaaaaaa", "" + uTeaSpoons);
            teaspoonTextView.setText("" + cetDecimale.format(uTeaSpoons) + " teaspoons");
            tablespoonTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(2, uTeaSpoons)) + " " + imena.get(2));
            cupTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(1, uTeaSpoons)) + " " + imena.get(1));
            ounceTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(3, uTeaSpoons)) + " " + imena.get(3));
            pintTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(4, uTeaSpoons)) + " " + imena.get(4));
            quartTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(5, uTeaSpoons)) + " " + imena.get(5));
            gallonTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(6, uTeaSpoons)) + " " + imena.get(6));
            poundTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(7, uTeaSpoons)) + " " + imena.get(7));
            millilitersTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(8, uTeaSpoons)) + " " + imena.get(8));
            literTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(9, uTeaSpoons)) + " " + imena.get(9));
            milligramTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(11, uTeaSpoons)) + " " + imena.get(11));
            kilogramTextView.setText("" + cetDecimale.format(uDrugeMjerneJedinice(10, uTeaSpoons)) + " " + imena.get(10));

        }

        String trenutniTextView = odabraniSpinner + "_text_view";
        int currentId = getResources().getIdentifier(trenutniTextView, "id", MainActivity.this.getPackageName());
        TextView currentTextView = findViewById(currentId);
        currentTextView.setText("" + amountTextView.getText().toString() + " " + odabraniSpinner);

    }


    double toTeaSpoon(String odabraniSpinner, double vrednost) {
        return vrednost / (double) decimale.get(imena.indexOf(odabraniSpinner));
    }

    double uDrugeMjerneJedinice(int i, double values) {
        return (double) decimale.get(i) * values;
    }


}

