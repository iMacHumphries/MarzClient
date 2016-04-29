public class Test {

	
	public static void test(Object act, Object expect) {
		boolean pass = (act == null ? act == expect : act.equals(expect));
		System.out.println(pass ? "PASS" : "FAIL");
	}
	
	public static void main(String[] args) {
		new Controller();
		
	}
	
//	public boolean isFound(int[] array, int num) {
//		boolean isfound = false;
//		for (int i = 0; i < array.length && !isfound; i++) {
//			if (array[i] == num) {
//				isfound = true;
//			}
//		}
//		return isfound;
//	}
//	
//	public int timesFound(int[] array, int num) {
//		int count = 0;
//		for (int i = 0; i < array.length; i++) {
//			count++;
//		}
//		return count;
//	}
//	
//	private int timesFound(int) {
//		
//	}
}
