package com.example.gamescore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private int teamScore1 = 0; // очки для команд
    private int teamScore2 = 0;
    private TextView team1;
    private TextView team2;



    @Override
    protected void onCreate(Bundle savedInstanceState) // запуск приложения
    {
        Log.d("MainActivity", "called onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        team1 = findViewById(R.id.textViewScoreTeam1);
        team2 = findViewById(R.id.textViewScoreTeam2);

        if (savedInstanceState != null) // если наш объект класса не пуст, а в нем есть значения, то забираем эти значения
        {
            teamScore1 = savedInstanceState.getInt("teamScore1");
            teamScore2 = savedInstanceState.getInt("teamScore2");
        }


        Button resetScore = findViewById(R.id.resetScoreButton);

        updateScore1();
        updateScore2();

        team1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("MainActivity", "Clicked teamScore1");
                teamScore1++;
                updateScore1();
            }
        }); // добавляем событий на клик для команды

        team2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("MainActivity", "Clicked teamScore2");
                teamScore2++;
                updateScore2();
            }
        });
        
        
        resetScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) 
            {
                teamScore1 = 0;
                teamScore2 = 0;
                updateScore1();
                updateScore2();
            }
        }); // здесь обнуляем счетчики




    }

    private void updateScore1()
    {
        team1.setText(String.valueOf(teamScore1));
    }

    private void updateScore2()
    {
        team2.setText(String.valueOf(teamScore2));
    }


    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("MainActivity", "called onStart");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("MainActivity", "called onResume");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("MainActivity", "called onRestart");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("MainActivity", "called onStop");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("MainActivity", "called onPause");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState)
    {
        Log.d("MainActivity", "called onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("teamScore1", teamScore1);
        outState.putInt("teamScore2", teamScore2);
    } // сохраняем данные, если они есть

    @Override
    protected void onDestroy() // метод закрытия приложения
    {
        Log.d("MainActivity", "called onDestroy");
        super.onDestroy();
    }
}