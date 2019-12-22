public class Main 
{
	public static void main(String[] args)
	{
		Integer[] array = new Integer[500000];
		for (int i = 0; i < 500000; i++)
		{
			array[i] = Integer.valueOf((int)(Math.random()* 100 ));
			System.out.println(array[i]);
		}
		for (int i = 1; i <= 16; i*=2)
		{
			MergeSort p = new MergeSort(array, i);
			//MergeSort m = new MergeSort(array, 16);
			long timeBeginUsual = System.currentTimeMillis();
			p.sort();
			long timeEndUsual = System.currentTimeMillis();
			long time = timeEndUsual - timeBeginUsual;
			System.out.println("Thread " + time + "ms" + "\n");
		} 
		//MergeSort p = new MergeSort(array, 1);
		//MergeSort s = new MergeSort(array, 4);
		//MergeSort k = new MergeSort(array, 8);
		//MergeSort m = new MergeSort(array, 16);
		//long timeBeginUsual = System.currentTimeMillis();
		//p.sort();
		//long timeEndUsual = System.currentTimeMillis();
		//long timeBeginThread = System.currentTimeMillis();
		//s.sort();
		//long timeEndThread = System.currentTimeMillis();
		//System.out.println(s);
		//System.out.println("Usual multiply: " + (timeEndUsual - timeBeginUsual) + "ms" + "\n");
		//System.out.println("Thread multiply: " + (timeEndThread - timeBeginThread) + "ms" + "\n");

	}
}