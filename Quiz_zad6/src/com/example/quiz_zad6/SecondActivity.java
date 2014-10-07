package com.example.quiz_zad6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	int[] randomQuestions = new int[3];
	int[] chosenAnswer = new int[3];
	List<Integer> list = new ArrayList<Integer>();
	Question[] questions;
	int currQuestion = 0;
	boolean answerMode = false;
	ImageView question_imageView;
	TextView questionNumber;
	TextView questionName;
	TextView item_answer1;
	TextView item_goodAnswer1;
	TextView item_chosenAnswer1;
	TextView item_answer2;
	TextView item_goodAnswer2;
	TextView item_chosenAnswer2;
	TextView item_answer3;
	TextView item_goodAnswer3;
	TextView item_chosenAnswer3;
	TextView helperTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_layout);
		createBaseOfQuestions();
		createView();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		answerMode = true;
		changeHelper();
		showResults();
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this, "Ta akcja jest zabroniona", Toast.LENGTH_SHORT)
				.show();
	}

	public void relativeClick(View v) {
		if (!answerMode) {
			if (currQuestion <= 2) {
				switch (v.getId()) {
				case R.id.relative_layout1:
					chosenAnswer[currQuestion] = 1;
					changeQuestion();
					break;
				case R.id.relative_layout2:
					chosenAnswer[currQuestion] = 2;
					changeQuestion();
					break;
				case R.id.relative_layout3:
					chosenAnswer[currQuestion] = 3;
					changeQuestion();
					break;
				}
			} else {
				currQuestion = 0;
				Intent intent = new Intent(this, MainActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
				startActivity(intent);
			}
		}
	}

	public void changeHelper() {
		helperTextView = (TextView) findViewById(R.id.item_helper);
		helperTextView.setBackgroundResource(R.drawable.rounded_layout);
		helperTextView.setText("Naciœnij, aby przejœæ dalej");
		helperTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (currQuestion <= 2)
					showResults();
				else {
					Intent intent = new Intent(SecondActivity.this,
							MainActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});

	}

	public void createView() {
		question_imageView = (ImageView) findViewById(R.id.question_imageView);
		questionName = (TextView) findViewById(R.id.questionName);
		questionNumber = (TextView) findViewById(R.id.questionNumber);
		item_answer1 = (TextView) findViewById(R.id.item_answer1);
		item_goodAnswer1 = (TextView) findViewById(R.id.item_goodAnswer1);
		item_chosenAnswer1 = (TextView) findViewById(R.id.item_chosenAnswer1);
		item_answer2 = (TextView) findViewById(R.id.item_answer2);
		item_goodAnswer2 = (TextView) findViewById(R.id.item_goodAnswer2);
		item_chosenAnswer2 = (TextView) findViewById(R.id.item_chosenAnswer2);
		item_answer3 = (TextView) findViewById(R.id.item_answer3);
		item_goodAnswer3 = (TextView) findViewById(R.id.item_goodAnswer3);
		item_chosenAnswer3 = (TextView) findViewById(R.id.item_chosenAnswer3);

		changeQuestion();
	}

	public void changeQuestion() {
		int firstItem = randomQuestions[currQuestion];
		question_imageView.setImageResource(questions[firstItem]
				.getQuestionImage());
		questionName.setText(questions[firstItem].getQuestionName());
		questionNumber.setText("Pytanie " + (currQuestion + 1));
		item_answer1.setText(questions[firstItem].answers[0]);
		item_answer2.setText(questions[firstItem].answers[1]);
		item_answer3.setText(questions[firstItem].answers[2]);
		currQuestion++;
	}

	public void showResults() {
		int firstItem = randomQuestions[currQuestion];
		question_imageView.setImageResource(questions[firstItem]
				.getQuestionImage());
		questionName.setText(questions[firstItem].getQuestionName());
		questionNumber.setText("Pytanie " + (currQuestion + 1));
		item_answer1.setText(questions[firstItem].answers[0]);
		item_answer2.setText(questions[firstItem].answers[1]);
		item_answer3.setText(questions[firstItem].answers[2]);
		item_goodAnswer1.setVisibility(View.INVISIBLE);
		item_goodAnswer2.setVisibility(View.INVISIBLE);
		item_goodAnswer3.setVisibility(View.INVISIBLE);
		item_chosenAnswer1.setVisibility(View.INVISIBLE);
		item_chosenAnswer2.setVisibility(View.INVISIBLE);
		item_chosenAnswer3.setVisibility(View.INVISIBLE);

		if (questions[firstItem].numberOfRightAnswer == 1) {
			item_goodAnswer1 = (TextView) findViewById(R.id.item_goodAnswer1);
			item_goodAnswer1.setVisibility(View.VISIBLE);
		} else {
			if (questions[firstItem].numberOfRightAnswer == 2) {
				item_goodAnswer2 = (TextView) findViewById(R.id.item_goodAnswer2);
				item_goodAnswer2.setVisibility(View.VISIBLE);
			} else {
				item_goodAnswer3 = (TextView) findViewById(R.id.item_goodAnswer3);
				item_goodAnswer3.setVisibility(View.VISIBLE);
			}
		}
		if (chosenAnswer[currQuestion] == 1) {
			item_chosenAnswer1 = (TextView) findViewById(R.id.item_chosenAnswer1);
			item_chosenAnswer1.setVisibility(View.VISIBLE);
		} else {
			if (chosenAnswer[currQuestion] == 2) {
				item_chosenAnswer2 = (TextView) findViewById(R.id.item_chosenAnswer2);
				item_chosenAnswer2.setVisibility(View.VISIBLE);
			} else {
				item_chosenAnswer3 = (TextView) findViewById(R.id.item_chosenAnswer3);
				item_chosenAnswer3.setVisibility(View.VISIBLE);
			}
		}
		currQuestion++;
	}

	public void createBaseOfQuestions() {
		questions = new Question[6];
		questions[0] = new Question("Ile wa¿y wilk?", new String[] {
				"10 - 20 kg", "30 - 75 kg", "100 - 150 kg" }, 2,
				R.drawable.wilk);
		questions[1] = new Question("Ile wa¿y czarna puma?", new String[] {
				"35 - 100 kg", "300 - 400 kg", "250 - 300 kg" }, 1,
				R.drawable.puma);
		questions[2] = new Question("Ile wa¿y s³oñ afrykañski?", new String[] {
				"6100 - 8000 kg", "1000 - 2000 kg", "2100 - 6000 kg" }, 3,
				R.drawable.slon);
		questions[3] = new Question("Ile wa¿y koñ?", new String[] {
				"200 - 300 kg", "50 - 200 kg", "50 - 100 kg" }, 2,
				R.drawable.kon);
		questions[4] = new Question("Ile wa¿y mucha?", new String[] {
				"0.1 - 1 kg", "0.02 - 0.1 kg", "0.001 - 0.02 kg" }, 3,
				R.drawable.mucha);
		questions[5] = new Question("Ile wa¿y kozio³?", new String[] {
				"30 - 120 kg", "120 - 200 kg", "200 - 250 kg" }, 1,
				R.drawable.koziol);
		createRandomQuestions();
	}

	public void createRandomQuestions() {
		if (randomQuestions[0] == 0) {
			for (int i = 0; i < questions.length; i++)
				list.add(i);
			Collections.shuffle(list);
			for (int i = 0; i < randomQuestions.length; i++) {
				randomQuestions[i] = list.get(i);
			}
		} else {
			for (int i = 0; i < randomQuestions.length; i++) {
				randomQuestions[i] = list.get(i + 3);
			}
		}
	}

	public int[] getRandomQuestions() {
		return randomQuestions;
	}

	public void setRandomQuestions(int[] randomQuestions) {
		this.randomQuestions = randomQuestions;
	}
}
