package readability;

public class ScoreChecker {
    public double scoreInARI(double characters, double words, double sentences) {
        return 4.71 * (characters / words) + 0.5 * (words / sentences) - 21.43;
    }

    public double scoreInFK(double words, double sentences, double syllables) {
        return 0.39 * (words / sentences) + 11.8 * (syllables / words) - 15.59;
    }

    public double scoreInSMOG(double polysyllables, double sentences) {
        return 1.043 * Math.sqrt(polysyllables * (30 / sentences)) + 3.1291;
    }

    public double scoreInCL(double characters, double words, double sentences) {
        return 0.0588 * (characters / words * 100) - 0.296 * (sentences / words * 100) - 15.8;
    }
}
