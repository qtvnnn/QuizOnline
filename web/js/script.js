/**
 * Copyright (C) 2021, FPT University
 * J3.L.P0001
 * Online Quiz.
 *
 * Record of change:
 * DATE         VERSION         Author
 * 2021-02-23   1.0             DungHT
 *
 */

this.currentQuiz = 0;
this.number = 0;
this.questionPos = document.getElementById("questionPos");
this.currentDiv = null;
this.timeRemaining = 0;
this.timeDisplay = document.getElementById("timeDisplay");
function setNumber(n) {
    number = n;
    this.questionPos = document.getElementById("questionPos");
    this.timeDisplay = document.getElementById("timeDisplay");
    this.currentQuiz = 0;
    this.currentDiv = null;
    this.timeRemaining = number * 5;
}

function nextQuestion() {
    if (this.currentDiv !== null) {
        this.currentDiv.classList.add("hidden");
    }
    currentDiv = document.getElementById("q" + currentQuiz);
    currentDiv.classList.remove("hidden");
    //show question
    currentQuiz = (currentQuiz % number) + 1;
    questionPos.textContent = "Question: " + currentQuiz + "/" + number;
    if (currentQuiz === number) {
        currentQuiz = 0;
        //load first quiz
    }
}

var bt = document.getElementById("btn-next");
bt.onclick = function () {
    nextQuestion();
};
var quizStart = function () {
    nextQuestion();
    var loop = setInterval(function () {
        timeRemaining--;
        updateTime();
        if (timeRemaining <= 0) {
            //time it up ==> sumit answers
            document.getElementById("quizForm").submit();
            clearInterval(loop);
        }
        //countdown 1s
    }, 1000);
};
/**
 * 
 * @returns {undefined}
 */
var updateTime = function () {
    var time = Math.floor(timeRemaining / 60);
    var sec = timeRemaining % 60;
    timeDisplay.textContent = time + ":" + sec;
};




