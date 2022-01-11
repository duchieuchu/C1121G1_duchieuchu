package ss8_clean_code_refactoring.bai_tap;

public class TennisGame {
    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String scoreResult = "";
//        boolean isDeuce = player1Name == player2Name;
        int tempScore = 0;
        if (player1Score == player2Score) {
            switch (player1Score) {
                case 0:
                    scoreResult = "Love-All";
                    break;
                case 1:
                    scoreResult = "Fifteen-All";
                    break;
                case 2:
                    scoreResult = "Thirty-All";
                    break;
                case 3:
                    scoreResult = "Forty-All";
                    break;
                default:
                    scoreResult = "Deuce";
                    break;

            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            if (minusResult == 1) scoreResult = "Advantage player1";
            else if (minusResult == -1) scoreResult = "Advantage player2";
            else if (minusResult >= 2) scoreResult = "Win for player1";
            else scoreResult = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = player1Score;
                else {
                    scoreResult += "-";
                    tempScore = player2Score;
                }
                switch (tempScore) {
                    case 0:
                        scoreResult += "Love";
                        break;
                    case 1:
                        scoreResult += "Fifteen";
                        break;
                    case 2:
                        scoreResult += "Thirty";
                        break;
                    case 3:
                        scoreResult += "Forty";
                        break;
                }
            }
        }
        return scoreResult;
    }
}
