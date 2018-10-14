package com.example.user.calculatornew;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    Intent getT;
    ListView listView;
    TextView tvX1,tvUnknown,tvMulti,tvSn;
    double x1,d;
    boolean Type;
    String[] list = new String[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvX1 = (TextView)findViewById(R.id.tvX1);
        tvUnknown = (TextView)findViewById(R.id.tvUnknown);
        tvMulti = (TextView)findViewById(R.id.tvMulti);
        tvSn = (TextView)findViewById(R.id.tvSn);
        getT = getIntent();

        x1 = getT.getDoubleExtra("x1", 0.0);
        Type = getT.getBooleanExtra("type", true);
        d = getT.getDoubleExtra("multi", 0.0);

        tvX1.setText("x1 = " + String.valueOf(x1));
        tvMulti.setText("d = " + String.valueOf(d));

        //Order the list referring to the calculation
        if(Type){
            list[0] = String.valueOf(x1);
            for (int i=2; i<21; i++){
                list[i-1] = String.valueOf(x1*Math.pow(d,i-1));
            }
        }

        if(!Type){
            list[0] = String.valueOf(x1);
            for (int i=2; i<21; i++){
                list[i-1] = String.valueOf(x1+(i-1)*d);
            }
        }

        listView = (ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,list);

        listView.setAdapter(adp);

    }
    public void goBack(View view) {
        Intent t = new Intent(this,MainActivity.class);
        startActivity(t);
        finish();
    }
    //Calculation referring to the chosen RADIO-BOX
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        if(Type){
            tvUnknown.setText("n= " +String.valueOf(position+1));
            if(d == 1){
                tvSn.setText("Sn= 0");
            }else{
                tvSn.setText("Sn= " +String.valueOf((x1*(Math.pow(d,position+1)-1))/(d-1)));
            }
        }
        if(!Type){
            tvUnknown.setText("n= "+ String.valueOf(position+1));
            tvSn.setText("Sn= " +String.valueOf(((position+1)*(2*x1+((position+1)-1)*d))/2));
        }
    }
}

