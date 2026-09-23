package programmers.lv3.Q84021;

import java.util.Set;

public class Main {
    public static void main(String[] args) {

    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        return answer;
    }

    public class BlankPiece extends Piece {
        int x, y;
        int size;
        int width, height;

        public BlankPiece(int[][] shape) {
            super(shape);
        }

        public void setCoordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int calcWidth() {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < shape.length; i++){
                for(int j = 0; j < shape[0].length; j++){
                    if(shape[i][j] == 1){
                        min = Math.min(min, j);
                        max = Math.max(max, j);
                    }
                }
            }
            width = max - min + 1;
            return width;
        }

        public int calcHeight() {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < shape.length; i++){
                for(int j = 0; j < shape[0].length; j++){
                    if(shape[i][j] == 1){
                        min = Math.min(min, i);
                        max = Math.max(max, i);
                    }
                }
            }
            height = max - min + 1;
            return height;
        }
    }

    public class Piece {
        int[][] shape;
        Set<Integer[][]> rotations;

        public Piece(int[][] shape) {
            this.shape = shape;

            // int[][] 를 Integer[][] 로 변환
            Integer[][] conversion = new Integer[shape.length][shape[0].length];
            for(int i = 0; i < shape.length; i++){
                for(int j = 0; j < shape[0].length; j++){
                    conversion[i][j] = shape[i][j];
                }
            }

            rotations.add(conversion);
        }

        public Integer[][] rotate(Integer[][] shape) {
            int row = shape.length;
            int col = shape[0].length;
            Integer[][] rotated = new Integer[col][row];
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    rotated[j][row - i - 1] = shape[i][j];
                }
            }

            return rotated;
        }

        // 중심대칭 판별
        public boolean isCenterSymmetric() {
            int row = shape.length;
            int col = shape[0].length;
            for(int i = 0; i < row / 2; i++){
                for(int j = 0; j < col; j++){
                    if(shape[i][j] != shape[row - i - 1][col - j - 1]){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
