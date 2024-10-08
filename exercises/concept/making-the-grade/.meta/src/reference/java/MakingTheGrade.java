import java.util.List;
import java.util.ArrayList;

class MakingTheGrade {

    static int countFailedStudents(List<Integer> studentScores) {
        int count = 0;

        for (int score : studentScores) {
            if (score <= 40) {
                count++;
            }
        }

        return count;
    }

    static int getAverageScoreOfStudents(List<Integer> studentScores, int numberOfStudents) {
        int count = 0;
        int sum = 0;

        while (count < numberOfStudents) {
            sum += studentScores.get(count);
            count++;
        }

        return sum / numberOfStudents;
    }

    static List<String> letterGrades(List<Integer> studentScores, List<String> studentNames) {
        List<String> letter = new ArrayList<>();
        int sum = 0;
        int count = 0;

        do {
            sum += studentScores.get(count);
            letter.add(studentNames.get(count));
            count++;
        } while (sum + studentScores.get(count) < 95);

        return letter;
    }
    
    static List<String> studentRanking(List<Integer> studentScores, List<String> studentNames) {
        List<String> ranking = new ArrayList<>();

        for (int i = 0; i < studentScores.size(); i++) {
            String student = String.valueOf(i + 1) + ". " + studentNames.get(i) + ": " + 
                String.valueOf(studentScores.get(i));
            
            ranking.add(student);
        }

        return ranking;
    }

    static int countOddScores(List<Integer> studentScores) {
        int count = 0;

        for (int score : studentScores) {
            if (score % 2 == 0) {
                continue;
            }

            count++;
        }

        return count;
    }

    static int evaluateChallengingExam(List<Integer> studentScores) {
        int count = 0;

        for (int score : studentScores) {
            if (score <= 40) {
                break;
            }

            count++;
        }

        return count;
    }
}
