package com.example.myapptracnghiem.question;

import java.io.Serializable;

public class Question implements Serializable {
    private int id;

    private String question;
    private int numberQues;
    private String ans_a;
    private String ans_b;
    private String ans_c;
    private String ans_d;
    private String result;
    private int id_exam;
    private String subject;
    private String image;
    private String ansCheck="";
    private String Check;


    public String getCheck() {
        return Check;
    }

    public void setCheck(String check) {
        Check = check;
    }

    public Question(String ansCheck, String endCheck) {
        this.ansCheck = ansCheck;
    }



    public String getAnsCheck() {
        return ansCheck;
    }

    public void setAnsCheck(String ansCheck) {
        this.ansCheck = ansCheck;
    }

    public Question(int id, int numberQues, String question, String ans_a, String ans_b, String ans_c,
                    String ans_d, String result, int id_exam, String subject, String image) {
        this.id = id;
        this.numberQues=numberQues;
        this.question = question;
        this.ans_a = ans_a;
        this.ans_b = ans_b;
        this.ans_c = ans_c;
        this.ans_d = ans_d;
        this.result = result;
        this.id_exam = id_exam;
        this.subject = subject;
        this.image = image;
    }

    public int getNumberQues() {
        return numberQues;
    }

    public void setNumberQues(int numberQues) {
        this.numberQues = numberQues;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }

    public String getAns_d() {
        return ans_d;
    }

    public void setAns_d(String ans_d) {
        this.ans_d = ans_d;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getId_exam() {
        return id_exam;
    }

    public void setId_exam(int id_exam) {
        this.id_exam = id_exam;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
