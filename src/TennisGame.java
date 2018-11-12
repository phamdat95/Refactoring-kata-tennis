public class TennisGame {

    public static final String MINUS = "-";
    public static final String LOVE = "Love";
    public static final String FIFTEEN = "Fifteen";
    public static final String THIRTY = "Thirty";
    public static final String FORTY = "Forty";

    public static String getScore(String firstNameOfPlayer, String secondNameOfPlayer, int firstScore, int secondScore) {
        String score = "";
        int tempScore;
        final boolean isFirstScoreEqualSecondScore = firstScore == secondScore;
        if (isFirstScoreEqualSecondScore)
        {
            switch (firstScore)
            {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        }
        else {
            final boolean isFirstScoreEqualOrBigger4 = firstScore >= 4;
            final boolean isSecondScoreEqualOrBigger4 = secondScore >= 4;
            if (isFirstScoreEqualOrBigger4 || isSecondScoreEqualOrBigger4)
            {
                int minusResult = firstScore-secondScore;
                final boolean isMinusResultEqual1 = minusResult == 1;
                final boolean isMinusResultEqualMinus1 = minusResult == -1;
                final boolean isMinusResultBiggerOrEqual2 = minusResult >= 2;
                if (isMinusResultEqual1) score ="Advantage player1";
                else {
                    if (isMinusResultEqualMinus1) score ="Advantage player2";
                    else {
                        if (isMinusResultBiggerOrEqual2) score = "Win for player1";
                        else score ="Win for player2";
                    }
                }
            }
            else
            {
                for (int i=1; i<3; i++)
                {
                    if (i==1) tempScore = firstScore;
                    else { score += MINUS; tempScore = secondScore;}
                    switch(tempScore)
                    {
                        case 0:
                            score += LOVE;
                            break;
                        case 1:
                            score += FIFTEEN;
                            break;
                        case 2:
                            score += THIRTY;
                            break;
                        case 3:
                            score += FORTY;
                            break;
                    }
                }
            }
        }
        return score;
    }
}
