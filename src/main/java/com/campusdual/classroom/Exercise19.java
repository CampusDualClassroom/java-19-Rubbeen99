package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }

        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < intArrayTri.length - 1; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length - 1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int colums = intArrayTri[0][0].length;

        int[][] arrayTriDimensional = new int[rows][colums];

        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < colums; k++) {
                    arrayTriDimensional[j][k] += intArrayTri[i][j][k];
                }
            }
        }
        return arrayTriDimensional;
    }

    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder arrayBiDimensional = new StringBuilder();

        for (int i = 0; i < intArrayBi.length; i++) {
            arrayBiDimensional.append(stringFlatMatrixRow(intArrayBi, i));

            if (i < intArrayBi.length - 1) {
                arrayBiDimensional.append("\n");
            }
        }
        return arrayBiDimensional.toString();
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder arrayUniDimensional = new StringBuilder();

        for (int i = 0; i < uniArray.length; i++) {
            arrayUniDimensional.append(uniArray[i]);

            if (i < uniArray.length - 1) {
                arrayUniDimensional.append(" ");
            }
        }
        return arrayUniDimensional.toString();
    }

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[columns];

        for (int i = 0; i < columns; i++) {
            uniArray[i] = i + 1;
        }
        return uniArray;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] intArrayBi = new int[rows][columns];

        int contador = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                intArrayBi[i][j] = contador++;
            }
        }
        return intArrayBi;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] intArrayTri = new int[depth][rows][columns];

        int contador = 1;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    intArrayTri[i][j][k] = contador++;
                }
            }
        }
        return intArrayTri;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));

        System.out.println("===================");

        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));

        System.out.println("===================");

        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
