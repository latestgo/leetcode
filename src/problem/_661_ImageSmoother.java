package problem;

public class _661_ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        if (img.length == 0) return new int[][]{};
        int[][] ret = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int num = 0, sum = 0;
                for (int k = i - 1; k < i + 2 ; k++) {
                    for (int l = j - 1; l < j + 2; l++) {
                        if (k > -1 && k < img.length && l > -1 && l < img[0].length) {
                            num++;
                            sum += img[k][l];
                        }
                    }
                }
                ret[i][j] = sum / num;
            }
        }
        return ret;
    }
}
