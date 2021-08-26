package com.example.slidingpuzzleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.net.FileNameMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageButton img00,img01,img02,img03,img10,img11,img12,img13,img20,img21,img22,img23,img30,img31,img32,img33,fullimage;
    private TextView movesDisplay,resultDisplay;
    private Button restart,solve;
    private int imagesX = 4;
    private int imagesY = 4;
    private int imagesCount = imagesX * imagesY;
    private int blankButtonId = R.id.image_33;
    private int blankPosition = imagesCount-1;
    private int movesCount=0;
    private int[] images={
            R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,
            R.drawable.img5,R.drawable.img6, R.drawable.img7,R.drawable.img8,
            R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12,
            R.drawable.img13,R.drawable.img14,R.drawable.img15,R.drawable.img16};
    private int[] imageIdeies=new int[images.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialViews();

        if (savedInstanceState!=null){
            imageIdeies = savedInstanceState.getIntArray("imageIndex");
            ImageButton oldBlanButton = findViewById(blankButtonId);
            oldBlanButton.setVisibility(View.VISIBLE);
            ImageButton newBlankButton = findViewById(savedInstanceState.getInt("blankButtonId"));
            newBlankButton.setVisibility(View.INVISIBLE);
            blankButtonId = savedInstanceState.getInt("blankButtonId");
            blankPosition = savedInstanceState.getInt("blankPosition");
            movesDisplay.setText(savedInstanceState.getString("movesDisplay"));
            resultDisplay.setText(savedInstanceState.getString("resultDisplay"));
            movesCount = savedInstanceState.getInt("moveCount");
            boolean isClickable = savedInstanceState.getBoolean("isClickable");
            img00.setClickable(isClickable);
            img01.setClickable(isClickable);
            img02.setClickable(isClickable);
            img03.setClickable(isClickable);
            img10.setClickable(isClickable);
            img11.setClickable(isClickable);
            img12.setClickable(isClickable);
            img13.setClickable(isClickable);
            img20.setClickable(isClickable);
            img21.setClickable(isClickable);
            img22.setClickable(isClickable);
            img23.setClickable(isClickable);
            img30.setClickable(isClickable);
            img31.setClickable(isClickable);
            img32.setClickable(isClickable);
            img33.setClickable(isClickable);
            setImgToButton();
        }else {
            for (int i=0;i<imageIdeies.length;i++){
                imageIdeies[i]=i;
            }
            setImgToButton();
            solve.setClickable(false);
        }


    }
    public void initialViews(){
        img00 = findViewById(R.id.image_00);
        img01 = findViewById(R.id.image_01);
        img02 = findViewById(R.id.image_02);
        img03 = findViewById(R.id.image_03);
        img10 = findViewById(R.id.image_10);
        img11 = findViewById(R.id.image_11);
        img12 = findViewById(R.id.image_12);
        img13 = findViewById(R.id.image_13);
        img20 = findViewById(R.id.image_20);
        img21 = findViewById(R.id.image_21);
        img22 = findViewById(R.id.image_22);
        img23 = findViewById(R.id.image_23);
        img30 = findViewById(R.id.image_30);
        img31 = findViewById(R.id.image_31);
        img32 = findViewById(R.id.image_32);
        img33 = findViewById(R.id.image_33);
        movesDisplay = findViewById(R.id.moves_textView);
        restart = findViewById(R.id.restart_button);
        solve = findViewById(R.id.solve_button);
        resultDisplay = findViewById(R.id.result_display);
        fullimage = findViewById(R.id.sliding_puzzle_imag);
    }

    public void disruptImages(){
        Random random= new Random();
        random.nextInt();
        for (int i = 0; i < imageIdeies.length; i++) {
            int change = i + random.nextInt(imageIdeies.length - i);
            swap(imageIdeies, i, change);
        }
        for (int i = 0; i < imageIdeies.length; i++){
        Log.d("index",""+imageIdeies[i]);}
        solve.setClickable(true);
        setImgToButton();

    }
    public void setImgToButton(){
        img00.setImageResource(images[imageIdeies[0]]);
        img01.setImageResource(images[imageIdeies[1]]);
        img02.setImageResource(images[imageIdeies[2]]);
        img03.setImageResource(images[imageIdeies[3]]);
        img10.setImageResource(images[imageIdeies[4]]);
        img11.setImageResource(images[imageIdeies[5]]);
        img12.setImageResource(images[imageIdeies[6]]);
        img13.setImageResource(images[imageIdeies[7]]);
        img20.setImageResource(images[imageIdeies[8]]);
        img21.setImageResource(images[imageIdeies[9]]);
        img22.setImageResource(images[imageIdeies[10]]);
        img23.setImageResource(images[imageIdeies[11]]);
        img30.setImageResource(images[imageIdeies[12]]);
        img31.setImageResource(images[imageIdeies[13]]);
        img32.setImageResource(images[imageIdeies[14]]);
        img33.setImageResource(images[imageIdeies[15]]);

    }
    private void swap(int[] a, int i, int change) {
        int temp = a[i];
        a[i] = a[change];
        a[change] = temp;
        setImgToButton();
    }

    public void clickImage(View view) {
        int imageButtonId = view.getId();
        switch (view.getId()){
            case R.id.image_00:
                moveImage(R.id.image_00,0);
                break;
            case R.id.image_01:
                moveImage(imageButtonId,1);
                break;
            case R.id.image_02:
                moveImage(imageButtonId,2);
                break;
            case R.id.image_03:
                moveImage(imageButtonId,3);
                break;
            case R.id.image_10:
                moveImage(imageButtonId,4);
                break;
            case R.id.image_11:
                moveImage(imageButtonId,5);
                break;
            case R.id.image_12:
                moveImage(imageButtonId,6);
                break;
            case R.id.image_13:
                moveImage(imageButtonId,7);
                break;
            case R.id.image_20:
                moveImage(imageButtonId,8);
                break;
            case R.id.image_21:
                moveImage(imageButtonId,9);
                break;
            case R.id.image_22:
                moveImage(imageButtonId,10);
                break;
            case R.id.image_23:
                moveImage(imageButtonId,11);
                break;
            case R.id.image_30:
                moveImage(imageButtonId,12);
                break;
            case R.id.image_31:
                moveImage(imageButtonId,13);
                break;
            case R.id.image_32:
                moveImage(R.id.image_32,14);
                break;
            case R.id.image_33:
                moveImage(imageButtonId,15);
                break;
            default:
                break;
        }


    }
    public void moveImage(int imageButtonId, int site){
        //get the row position of the clicked button
        int siteX = site / imagesX;
        //get the column position of the clicked button
        int siteY = site % imagesY;
        //get the row position of the blank button
        int blankX = blankPosition / imagesX;
        //get the column position of the blank button
        int blankY = blankPosition % imagesY;
        //if the difference of the position of two buttons equals 1, then they can make a swap
        int x = Math.abs(siteX-blankX);
        int y = Math.abs(siteY-blankY);
        if((x==0&&y==1)||(x==1&&y==0)){
            ImageButton clickedButton = findViewById(imageButtonId);
            clickedButton.setVisibility(View.INVISIBLE);
            ImageButton blankButton = findViewById(blankButtonId);
            blankButton.setVisibility(View.VISIBLE);
            swap(imageIdeies,site,blankPosition);

            blankPosition = site;
            blankButtonId = imageButtonId;

            movesCount++;
            movesDisplay.setText("Moves so far:          "+movesCount);
        }else {
            resultDisplay.setText("Illegal move!");
        }

        checkWin();
    }
    public void restartGame(View view) {
        ImageButton newblankButton = findViewById(blankButtonId);
        newblankButton.setVisibility(View.VISIBLE);
        ImageButton resetBlankButton = findViewById(R.id.image_33);
        resetBlankButton.setVisibility(View.INVISIBLE);
        ImageButton slidingImange = findViewById(R.id.sliding_puzzle_imag);
        slidingImange.setVisibility(View.INVISIBLE);
        blankButtonId = R.id.image_33;
        blankPosition = imagesCount-1;
        disruptImages();
        movesCount = 0;
        movesDisplay.setText("Moves so far:          ");
        resultDisplay.setText("");
        img00.setClickable(true);
        img01.setClickable(true);
        img02.setClickable(true);
        img03.setClickable(true);
        img10.setClickable(true);
        img11.setClickable(true);
        img12.setClickable(true);
        img13.setClickable(true);
        img20.setClickable(true);
        img21.setClickable(true);
        img22.setClickable(true);
        img23.setClickable(true);
        img30.setClickable(true);
        img31.setClickable(true);
        img32.setClickable(true);
        img33.setClickable(true);
    }


    public void checkWin() {
        //if the indexes of images are sorted inorderly, user weins
        boolean win = true;
        for (int i=0; i<imageIdeies.length;i++){
            if (imageIdeies[i]!=i){
                win = false;
            }
        }
        if (win){
            resultDisplay.setText("You solved the puzzle in "+movesCount+" moves!");
            img00.setClickable(false);
            img01.setClickable(false);
            img02.setClickable(false);
            img03.setClickable(false);
            img10.setClickable(false);
            img11.setClickable(false);
            img12.setClickable(false);
            img13.setClickable(false);
            img20.setClickable(false);
            img21.setClickable(false);
            img22.setClickable(false);
            img23.setClickable(false);
            img30.setClickable(false);
            img31.setClickable(false);
            img32.setClickable(false);
            img33.setClickable(false);
        }
    }

    public void solvePuzzle(View view) {
//        make the images index display inoderly
        Arrays.sort(imageIdeies);
        setImgToButton();
        ImageButton newblankButton = findViewById(blankButtonId);
        newblankButton.setVisibility(View.VISIBLE);
        ImageButton resetBlankButton = findViewById(R.id.image_33);
        resetBlankButton.setVisibility(View.INVISIBLE);
        fullimage.setVisibility(View.VISIBLE);
        resultDisplay.setText("");
        movesCount=0;
        movesDisplay.setText("Moves so far:          ");
        img00.setClickable(false);
        img01.setClickable(false);
        img02.setClickable(false);
        img03.setClickable(false);
        img10.setClickable(false);
        img11.setClickable(false);
        img12.setClickable(false);
        img13.setClickable(false);
        img20.setClickable(false);
        img21.setClickable(false);
        img22.setClickable(false);
        img23.setClickable(false);
        img30.setClickable(false);
        img31.setClickable(false);
        img32.setClickable(false);
        img33.setClickable(false);


    }

// save the data while totating the screen
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("imageIndex",imageIdeies);
        outState.putString("resultDisplay",resultDisplay.getText().toString());
        outState.putString("movesDisplay",movesDisplay.getText().toString());
        outState.putBoolean("isClickable",img00.isClickable());
        outState.putInt("blankButtonId",blankButtonId);
        outState.putInt("blankPosition",blankPosition);
        outState.putInt("moveCount",movesCount);
    }
}