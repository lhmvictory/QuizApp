package com.example.teta.quizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * @param editTextId is the id of an EditText
     * @return the text that the user write on the EditText
     */
    private String textWriteOnEditText(@IdRes int editTextId) {

        EditText edittext = (EditText) findViewById(editTextId);
        return edittext.getText().toString();
    }

    /**
     * @param answerId is the id of a CheckBox
     * @return whither an answer is checked or not
     */
    private boolean answerIsChecked(@IdRes int answerId) {

        CheckBox answer = (CheckBox) findViewById(answerId);
        return answer.isChecked();
    }

    /**
     * @param radioGroupAnswerId is the id of a RadioGroup
     * @return the Index of chosen answer/RadioButton(for question 1 - 10 )
     */
    private int getSelectedRadioButtonIndex(@IdRes int radioGroupAnswerId) {

        RadioGroup rg = (RadioGroup) findViewById(radioGroupAnswerId);
        // get selected radio button from radioGroup
        int selectedRadioButtonID = rg.getCheckedRadioButtonId();

        // If nothing is selected from Radio Group, then it return -1
        if (selectedRadioButtonID != -1) {

            View selectedRadioButton = rg.findViewById(selectedRadioButtonID);
            int selectedRadioButtonIndex = rg.indexOfChild(selectedRadioButton);

            return selectedRadioButtonIndex;
        } else {

            return -1;
        }
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View v) {

        /*The correct answer for question 1 is the answer number 2: which means Index 1*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_1) == 1) {

            score = score + 1;
        }
        /*The correct answer for question 2 is the answer number 1: which means Index 0*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_2) == 0) {

            score = score + 1;
        }
        /*The correct answer for question 3 is the answer number 2: which means Index 1*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_3) == 1) {

            score = score + 1;
        }
        /*The correct answer for question 4 is the answer number 3: which means Index 2*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_4) == 2) {

            score = score + 1;
        }
        /*The correct answer for question 5 is the answer number 1: which means Index 0*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_5) == 0) {

            score = score + 1;
        }
        /*The correct answer for question 6 is the answer number 1: which means Index 0*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_6) == 0) {

            score = score + 1;
        }
        /*The correct answer for question 7 is the answer number 2: which means Index 1*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_7) == 1) {

            score = score + 1;
        }
        /*The correct answer for question 8 is the answer number 3: which means Index 2*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_8) == 2) {

            score = score + 1;
        }
        /*The correct answer for question 9 is the answer number 2: which means Index 1*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_9) == 1) {

            score = score + 1;
        }
        /*The correct answer for question 10 is the answer number 1: which means Index 0*/
        if (getSelectedRadioButtonIndex(R.id.rg_question_10) == 0) {

            score = score + 1;
        }

        /* check that the correct answers are checked AND the incorrect answers are not checked */
        if (answerIsChecked(R.id.answer_1_question_11) == true && answerIsChecked(R.id.answer_2_question_11) == false && answerIsChecked(R.id.answer_3_question_11) == true && answerIsChecked(R.id.answer_4_question_11) == true && answerIsChecked(R.id.answer_5_question_11) == false) {

            score = score + 1;
        }

        if (answerIsChecked(R.id.answer_1_question_12) == true && answerIsChecked(R.id.answer_2_question_12) == false && answerIsChecked(R.id.answer_3_question_12) == false && answerIsChecked(R.id.answer_4_question_12) == true && answerIsChecked(R.id.answer_5_question_12) == true) {

            score = score + 1;
        }

        /*trim() Returns a string equal to the string without spaces of beginning and end.*/
        if (textWriteOnEditText(R.id.answer_1_question_13).trim().equals("33")) {

            score = score + 1;
        }
        if (textWriteOnEditText(R.id.answer_2_question_13).trim().equals("42")) {

            score = score + 1;
        }
        if (textWriteOnEditText(R.id.answer_3_question_13).trim().equals("64")) {

            score = score + 1;
        }

        String message;
        String user_name = textWriteOnEditText(R.id.use_name);

        if (score < 8) {

            message = "try again " + user_name + " keep practicing and you'll get amazing results! \n you score " + score + "/15 on this quiz";

        } else if (score < 15) {

            message = "good job " + user_name + ", you score " + score + "/15 on this quiz";

        } else {

            message = "congratulation! excellent work " + user_name + ", you score 15/15 on this quiz";

        }

        // Show a message as a toast telling the user his score
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        View toastView = toast.getView(); // This'll return the default View of the Toast.
        /* And now you can get the TextView of the default View of the Toast. */
        TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
        toastMessage.setTextSize(25);
        toastMessage.setTextColor(Color.RED);
        toastMessage.setGravity(Gravity.CENTER);
        toastMessage.setCompoundDrawablePadding(16);
        toastView.setBackgroundColor(Color.YELLOW);
        toast.show();
    }
}