package de.janmeckelholt.quizapp

object Constants {

    fun getQuestions(): ArrayList<Question> {
        val q1 = Question(
            id = 0,
            question = "Solution is one?",
            optionOne = "Q1 Answer 1",
            optionTwo = "Q1 Answer 2",
            optionThree = "Q1 Answer 3",
            optionFour = "Q1 Answer 4",
            correctAnswer = 1,
            image = null
        )
        val q2 = Question(
            id = 1,
            question = "Solution is four?",
            optionOne = "Q2 Answer 1",
            optionTwo = "Q2 Answer 2",
            optionThree = "Q2 Answer 3",
            optionFour = "Q2 Answer 4",
            correctAnswer = 4,
            image = null
        )


        val questionsList = ArrayList<Question>()
        questionsList.add(q1)
        questionsList.add(q2)

        return questionsList

    }
}