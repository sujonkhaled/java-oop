import java.util.Scanner;

abstract class QuizItem {
    abstract void show();
    abstract boolean check(int userAnswer);
    abstract void displayCorrectAnswer();
}

class Question extends QuizItem {
    private int sequence;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private int answer;
    private String[] option;

    public Question(int seq, String q, String o1, String o2, String o3, int a) {
        this.sequence = seq;
        this.question = q;
        this.option1 = o1;
        this.option2 = o2;
        this.option3 = o3;
        this.answer = a;
        this.option = new String[]{option1, option2, option3};
    }

    @Override
    void show() {
        System.out.println("Question " + sequence + ": " + question);
        System.out.println("1. " + option1);
        System.out.println("2. " + option2);
        System.out.println("3. " + option3);
    }

    @Override
    boolean check(int userAnswer) {
        return userAnswer == answer;
    }

    @Override
    void displayCorrectAnswer() {
        System.out.println("Correct answer: " + answer + ". Explanation: " + option[answer - 1]);
    }
}

class Quiz {
    private Question[] quizItems;
    private int quizSize;

    public Quiz(Question[] items, int size) {
        this.quizItems = items;
        this.quizSize = size;
    }

    void run() {
        System.out.println("Welcome to the UN SDG Quiz game! We have built it as our Programming Technique 2 project!");

        int score = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < quizSize; ++i) {
            quizItems[i].show();

            System.out.print("Enter your answer: ");
            int userAnswer = scanner.nextInt();

            if (quizItems[i].check(userAnswer)) {
                System.out.println("Correct! Congratulations!");
                score++;
            } else {
                System.out.println("Incorrect. Don't worry, keep going!");
                quizItems[i].displayCorrectAnswer();
            }
        }

        System.out.println("Your final score is " + score + " out of " + quizSize);
    }
}

class Player {
    private String name;

    public Player(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        final int numQuestions = 21;
        Question[] quizArray = {
                new Question(1, "What is the goal of SDG 17?", "To end poverty", "To promote gender equality", "To strengthen the means of implementation and revitalize the Global Partnership for Sustainable Development", 3),
                new Question(2, "Which UN agency is primarily responsible for coordinating international cooperation under SDG 17?", "UNESCO", "UNICEF", "UNDP", 3),
                new Question(3, "What is the focus of SDG 17, Target 17.6?", "Reducing inequality", "Ensuring access to education", "Enhancing North-South cooperation", 1),
                new Question(4, "Which of the following is a principle of effective development cooperation under SDG 17?", "Isolationism", "Transparency and accountability", "Unilateral decision-making", 2),
                new Question(5, "What does the term 'ODA' stand for in the context of SDG 17?", "Overseas Development Assessment", "Official Development Assistance", "Operational Development Agreement", 2),
                new Question(6, "In SDG 17, what is meant by the term 'technology transfer'?", "Returning technology to developed countries", "Sharing technology between countries", "Selling technology to the highest bidder", 2),
                new Question(7, "Which aspect of SDG 17 addresses issues related to debt sustainability?", "Target 17.3", "Target 17.4", "Target 17.5", 3),
               new Question(8, "What is the role of SDG 17 in addressing global trade challenges?", "Promoting protectionism", "Encouraging fair and equitable trade", "Restricting trade agreements", 2),
                new Question(9, "Which international event in 2015 adopted the 2030 Agenda for Sustainable Development, including SDG 17?", "Rio+20 Summit", "Copenhagen Climate Summit", "UN General Assembly", 3),
                new Question(10, "What is the significance of SDG 17 in the context of peace and security?", "It focuses on military alliances", "It emphasizes disarmament", "It recognizes the importance of partnerships in achieving peace and security", 3),
                new Question(11, "How does SDG 17 contribute to global health?", "By providing healthcare services directly", "By supporting international cooperation for health", "By focusing only on local health issues", 2),
               
               new Question(12, "Which SDG 17 target aims to enhance policy coherence for sustainable development?", "Target 17.14", "Target 17.15", "Target 17.16", 1),
               new  Question(13, "What is the primary objective of SDG 17, Target 17.17?", "Encouraging global partnerships", "Strengthening domestic resource mobilization", "Promoting sustainable tourism", 2),
               new  Question(14, "In the context of SDG 17, what is meant by 'South-South cooperation'?", "Cooperation among southern hemisphere countries", "Collaboration between developed and developing countries", "Collaboration among developing countries", 3),
               new  Question(15, "Which international organization plays a key role in promoting international trade under SDG 17?", "World Health Organization (WHO)", "World Trade Organization (WTO)", "World Bank", 2),
              new  Question(16, "What is the significance of SDG 17 in achieving environmental sustainability?", "It focuses on wildlife conservation", "It emphasizes the protection of natural resources", "It promotes global cooperation for environmental protection", 3),
              new  Question(17, "Which indicator measures the total government spending on SDG implementation under SDG 17?", "Indicator 17.15.1", "Indicator 17.16.1", "Indicator 17.17.1", 1),
              new   Question(18, "What is the purpose of the 'Global Partnership for Sustainable Development Data' under SDG 17?", "To promote open data sharing", "To collect data for academic research", "To restrict data access", 1),
              new   Question(19, "Which type of partnerships does SDG 17 emphasize for achieving its goals?", "Public-private partnerships", "Government-only partnerships", "Academic partnerships", 1),
             new    Question(20, "What is the role of SDG 17 in addressing climate change?", "It focuses on reducing carbon emissions", "It emphasizes the importance of international climate agreements", "It advocates for individual lifestyle changes", 2),
             new   Question(21, "Which international forum is associated with the review of SDG 17 progress?", "G7 Summit", "High-level Political Forum on Sustainable Development (HLPF)", "World Economic Forum (WEF)", 2),
        };

        Quiz quiz = new Quiz(quizArray, numQuestions);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Hey, no more wait! We are group matrix so excited to help you. Please enter your name: ");
        String playerName = scanner.nextLine();
        System.out.print("please use your matric no to be in the quiz! enter your matric number: ");
        String playerMatricNo = scanner.nextLine();

        Player player = new Player(playerName);

        int choice;
        do {
            System.out.println("\nMain Menu");
            System.out.println("1. Start Quiz");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quiz.run();
                    break;
                case 2:
                    System.out.println("Thank you for playing this Quiz, and thanks to our lecturer Dr. Jamilah Mahmood. I am " + player.getName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }
        } while (choice != 2);
    }
}
