package by.vita02.backend.service;

import by.vita02.backend.enums.ProjectType;

public class MethodRankService {
    public ProjectType calculate(int[][] matrix){
        double max = -1;
        int maxId = 0;
        int n = matrix.length;
        int m = 5;
        double[] weights = new double[m];
        int[] sums = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                sums[i] += matrix[i][j];
            }
        }
        for(int j = 0; j<m; j++){
            for(int i = 0; i<n; i++) {
                weights[j] += (double) matrix[i][j] / sums[i];
            }
            weights[j] /= n;
            if (weights[j] > max){
                max = weights[j];
                maxId = j;
            }
        }
        return switch (maxId) {
            case (0) -> ProjectType.BUSINESS_CARD_SITE;
            case (1) -> ProjectType.MOBILE_APP;
            case (2) -> ProjectType.CORPORATE_SITE;
            case (3) -> ProjectType.ONLINE_SHOP;
            case (4) -> ProjectType.SITE_CATALOG;
            default -> null;
        };
    }
}
