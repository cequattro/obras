package pe.globalhub.rest.test;

public class TenPinBowlingGame {
	String[] oneGameScores;
    int score;

    public TenPinBowlingGame(String input) {
        oneGameScores = input.split("\\|");
        if (this.oneGameScores.length == 12) {
            this.oneGameScores[10] = this.oneGameScores[11];
            this.oneGameScores[11] = "";
        }
    }

    public int score() {
        for (int i = 0; i < 10; i++) {
            score += oneTurnScore(i);
        }
        return score;
    }

    public int oneTurnScore(int i) {
        int score = 0;
        String scoreExpress = oneGameScores[i];
        score = oneFrameScore(scoreExpress);
        if (scoreExpress.equals("X")) {
            score += strikeBonus(i);
        } else if (scoreExpress.indexOf("/") != -1) {
            score += spareBonus(i);
        }
        return score;
    }

    private int strikeBonus(int i) {
        String scoreExpress = oneGameScores[i + 1];
        int bonus = 0;
        if (scoreExpress.equals("X")) {
            bonus = 10;
            scoreExpress = oneGameScores[i + 2];

            scoreExpress = scoreExpress.charAt(0) + "";
            bonus += oneFrameScore(scoreExpress);
            return bonus;
        } else {
            return oneFrameScore(scoreExpress);
        }
    }


    private int spareBonus(int i) {
        String scoreExpress = oneGameScores[i + 1];
        scoreExpress = scoreExpress.charAt(0) +"";
        return oneFrameScore(scoreExpress);
    }

    public int oneFrameScore(String score) {
        if (score.equals("XX")) {
            return 20;
        } else if (score.indexOf("X") != -1) {
            if (score.length() == 2) {
                score = score.replace("X", "");
                return 10 + Integer.parseInt(score);
            }
            return 10;
        } else if (score.indexOf("/") != -1) {
            return 10;
        } else if (score.indexOf("-") != -1) {
            score = score.replace("-", "");
            try {
                return Integer.parseInt(score);
            } catch (Exception e) {
                return 0;
            }
        } else {
            if (score.length() == 1) {

                return Integer.parseInt(score.charAt(0) + "");
            } else {
                return Integer.parseInt(score.charAt(0) + "") + Integer.parseInt(score.charAt(1) + "");

            }

        }
    }
}