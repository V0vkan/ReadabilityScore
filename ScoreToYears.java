package readability;

public class ScoreToYears {
    public int scoreToYears(double dScore) {
        int years;

        switch ((int) Math.round(dScore)) {
            case 1:
                years = 6;
                break;
            case 2:
                years = 7;
                break;
            case 3:
                years = 9;
                break;
            case 4:
                years = 10;
                break;
            case 5:
                years = 11;
                break;
            case 6:
                years = 12;
                break;
            case 7:
                years = 13;
                break;
            case 8:
                years = 14;
                break;
            case 9:
                years = 15;
                break;
            case 10:
                years = 16;
                break;
            case 11:
                years = 17;
                break;
            case 12:
                years = 18;
                break;
            case 13:
                years = 24;
                break;
            default:
                years = 25;
                break;
        }

        return years;
    }
}
