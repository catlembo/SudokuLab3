package pkgGame;
import java.util.Arrays;
import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare{
	
	private int iSize;
	private int iSqrtSize;
	
	public Sudoku() {
		super();
	}
	
	public Sudoku(int iSize) {
		this.iSize = iSize;
		this.iSqrtSize = Math.sqrt(this.iSize);
	}

	
	public Sudoku(int[][] LatinSquare) {
		super(LatinSquare);
		
		this.setLatinSquare(LatinSquare);
		this.iSize = LatinSquare.length;
		this.iSqrtSize = Math.sqrt(this.iSize);
	}
	
	protected int[][] getPuzzle(){
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int r) throws Exception {
		int[] answer = new int[super.getLatinSquare().length];

		int[][] square = super.getLatinSquare();

		int col = r%iSqrtSize * iSqrtSize;

		int row = r/iSqrtSize * iSqrtSize;

		int count = 0;

		for (int i=row; i < (row + iSqrtSize); i++) {

			for (int j=col ; j < (col + iSqrtSize); j++) {

				answer[count] = square[i][j];

				count++;

			}

		}

		return answer;

	}
	
	protected int[] getRegion(int iCol, int iRow) {


			int region = (iCol / iSqrtSize) + ((iRow / iSqrtSize) * iSqrtSize);

			return getRegion(region);

		}



	@Override
	protected boolean hasDuplicates(int[] arr) {
		super.hasDuplicates(arr);
	}
	
	protected boolean isPartialSudoku() {

		boolean SSS = true;
		super.setbIgnoreZero(true);

		if(!super.ContainsZero()) {

			SSS = false;
		}
		for(int i = 0;i<super.getLatinSquare().length;i++) {
			if(super.hasDuplicates(super.getRow(i))) {
				
				SSS = false;
				break;
			}
		}
		for(int j = 0; j<super.getLatinSquare().length;j++) {

			if(super.hasDuplicates(super.getColumn(j))) {

				SSS = false;
				break;
			}
		}
		for(int k = 0;k<super.getLatinSquare().length;k++) {

			if(super.hasDuplicates(getRegion(k))) {
				
				SSS = false;
				break;
			}
		}
		return SSS;
	}
	
	protected boolean isSudoku() {		

		super.setbIgnoreZero(false);


		if(!super.isLatinSquare()) {

			return false;
		}

		if (!super.ContainsZero()) {
			return false;
		}

		for(int i = 0;i<super.getLatinSquare().length; i++) {
			if(super.hasDuplicates(getRegion(i))) {
				return false;
				break;
			}
		}
		for(int j = 0; j<super.getLatinSquare().length;j++) {
			if(!super.hasAllValues(getRegion(j), super.getRow(0))) {

				return false;
				break;
			}
		}
		return true;
	}
	
	protected boolean isValidValue(int iCol, int iRow, int iValue) {
		if(!(doesElementExist(getColumn(iCol), iValue))){
			if(!(doesElementExist(getRow(iRow), iValue))){
				return true;}
			else {
				return false;}
			}
		else{
			return false;}
		
			}
		
	}

