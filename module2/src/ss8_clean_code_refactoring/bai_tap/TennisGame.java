package ss8_clean_code_refactoring.bai_tap;

public class TennisGame {
    public static final int Love = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String scoreResult = "";
        int tempScore = 0;
        if (player1Score == player2Score) {
            checkPlayer1score(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            lonHonHoacBang4(player1Score, player2Score);
        } else {
            nhoHon3(player1Score, player2Score);
        }
        return scoreResult;
    }

    public static void checkPlayer1score(int player1Score) {
        String scoreResult = " ";
        switch (player1Score) {
            case Love:
                scoreResult = "Love-All";
                break;
            case FIFTEEN:
                scoreResult = "Fifteen-All";
                break;
            case THIRTY:
                scoreResult = "Thirty-All";
                break;
            case FORTY:
                scoreResult = "Forty-All";
                break;
            default:
                scoreResult = "Deuce";
                break;
        }
    }

    public static void lonHonHoacBang4(int player1Score, int player2Score) {
        String scoreResult = " ";
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) scoreResult = "Advantage player1";
        else if (minusResult == -1) scoreResult = "Advantage player2";
        else if (minusResult >= 2) scoreResult = "Win for player1";
        else scoreResult = "Win for player2";
    }

    public static void nhoHon3(int player1Score, int player2Score) {
        String scoreResult = " ";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                scoreResult += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case Love:
                    scoreResult += "Love";
                    break;
                case FIFTEEN:
                    scoreResult += "Fifteen";
                    break;
                case THIRTY:
                    scoreResult += "Thirty";
                    break;
                case FORTY:
                    scoreResult += "Forty";
                    break;
                default:
                    scoreResult += "Deuce";
            }
        }
    }
}
