package de.michfisch.southamericaquiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declaration of variables
    int correctAnswers = 0;
    RadioGroup answersGroup1;
    RadioGroup answersGroup2;
    RadioGroup answersGroup3;
    RadioGroup answersGroup4;
    RadioGroup answersGroup5;
    CheckBox question6_answer1_checkbox;
    CheckBox question6_answer2_checkbox;
    CheckBox question6_answer3_checkbox;
    EditText question7_answer_edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answersGroup1 = (RadioGroup) findViewById(R.id.answers_group1);
        answersGroup2 = (RadioGroup) findViewById(R.id.answers_group2);
        answersGroup3 = (RadioGroup) findViewById(R.id.answers_group3);
        answersGroup4 = (RadioGroup) findViewById(R.id.answers_group4);
        answersGroup5 = (RadioGroup) findViewById(R.id.answers_group5);
        question6_answer1_checkbox = (CheckBox) findViewById(R.id.question6_answer1_checkbox);
        question6_answer2_checkbox = (CheckBox) findViewById(R.id.question6_answer2_checkbox);
        question6_answer3_checkbox = (CheckBox) findViewById(R.id.question6_answer3_checkbox);
        question7_answer_edittext = (EditText) findViewById(R.id.question7_answer_edittext);

    }

    public int answersMethod() {

        //correct answers
        //Question 1: A1
        //Question 2: A2
        //Question 3: A2
        //Question 4: A2
        //Question 5: A3
        //Question 6: 1 and 2
        //Question 7: Amazon


        // Question 1: Is the correct answer button checked?
        RadioButton answerQuestionOne = findViewById(R.id.question1_answer1);
        boolean answerOneButton = answerQuestionOne.isChecked();

        // Question 2: Is the correct answer button checked?
        RadioButton answerQuestionTwo = findViewById(R.id.question2_answer2);
        boolean answerTwoButton = answerQuestionTwo.isChecked();

        // Question 3: Is the correct answer button checked?
        RadioButton answerQuestionThree = findViewById(R.id.question3_answer2);
        boolean answerThreeButton = answerQuestionThree.isChecked();

        // Question 4: Is the correct answer button checked?
        RadioButton answerQuestionFour = findViewById(R.id.question4_answer2);
        boolean answerFourButton = answerQuestionFour.isChecked();

        // Question 5: Is the correct answer button checked?
        RadioButton answerQuestionFive = findViewById(R.id.question5_answer3);
        boolean answerFiveButton = answerQuestionFive.isChecked();

        // Question 6: Are answers 1 and 2 checked?

        CheckBox answerQuestionSix_first = findViewById(R.id.question6_answer1_checkbox);
        boolean answerSixCheck_first = answerQuestionSix_first.isChecked();

        CheckBox answerQuestionSix_second = findViewById(R.id.question6_answer2_checkbox);
        boolean answerSixCheck_second = answerQuestionSix_second.isChecked();


        //Question 7: Is the answer "Amazon"?

        EditText answerSevenEdit = findViewById(R.id.question7_answer_edittext);
        String userInput = answerSevenEdit.getText().toString();

        String amazon_uppercase = "Amazon";
        String amazon_lowercase = "amazon";


        // Summing up on point for each correct answer
        if (answerQuestionOne.isChecked()) {
            correctAnswers += 1;
        }

        if (answerQuestionTwo.isChecked()) {
            correctAnswers += 1;
        }

        if (answerQuestionThree.isChecked()) {
            correctAnswers += 1;
        }

        if (answerQuestionFour.isChecked()) {
            correctAnswers += 1;
        }

        if (answerQuestionFive.isChecked()) {
            correctAnswers += 1;
        }

        if (question6_answer1_checkbox.isChecked() && question6_answer2_checkbox.isChecked() && !question6_answer3_checkbox.isChecked()) {
            correctAnswers += 1;
        }

        if (amazon_uppercase.equalsIgnoreCase(userInput) && (amazon_lowercase.equalsIgnoreCase(userInput))) {
            correctAnswers += 1;
        }

        //if (amazon_lowercase.equalsIgnoreCase(userInput)){
        //    correctAnswers += 1;
        //}

        return correctAnswers;
    }

    public void submitButton(View view) {

        //Display Result
        correctAnswers = answersMethod();

        Toast resultToast = Toast.makeText(this, "You got " + correctAnswers + " of 7 questions right.", Toast.LENGTH_LONG);
        resultToast.show();

        correctAnswers = 0;

    }

    //method to reset Quiz

    public void resetQuiz(View view) {

        answersGroup1.clearCheck();
        answersGroup2.clearCheck();
        answersGroup3.clearCheck();
        answersGroup4.clearCheck();
        answersGroup5.clearCheck();

        question6_answer1_checkbox.setChecked(false);
        question6_answer2_checkbox.setChecked(false);
        question6_answer3_checkbox.setChecked(false);
        question7_answer_edittext.setText("");


        Toast resultToast = Toast.makeText(this, "Quiz has been reset. Try again!", Toast.LENGTH_LONG);
        resultToast.show();
    }
}