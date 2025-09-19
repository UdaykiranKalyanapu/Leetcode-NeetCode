package Tem;

public class SpreadSheet {

        private int[][] grid; // rows × 26 columns

        public void Spreadsheet(int rows) {
            grid = new int[rows][26];
        }

        public void setCell(String cell, int value) {
            int[] pos = parseCell(cell);
            grid[pos[0]][pos[1]] = value;
        }

        public void resetCell(String cell) {
            int[] pos = parseCell(cell);
            grid[pos[0]][pos[1]] = 0;
        }

        public int getValue(String formula) {
            // Formula looks like "=X+Y"
            formula = formula.substring(1); // remove '='
            String[] parts = formula.split("\\+");
            return parseValue(parts[0]) + parseValue(parts[1]);
        }

        // --- Helpers ---

        // Convert cell like "B2" -> [row, col]
        private int[] parseCell(String cell) {
            char colChar = cell.charAt(0);
            int col = colChar - 'A';
            int row = Integer.parseInt(cell.substring(1)) - 1;
            return new int[]{row, col};
        }

        // Decide if token is an integer or a cell reference
        private int parseValue(String token) {
            if (Character.isDigit(token.charAt(0))) {
                return Integer.parseInt(token);
            } else {
                int[] pos = parseCell(token);
                return grid[pos[0]][pos[1]];
            }
        }
    }
