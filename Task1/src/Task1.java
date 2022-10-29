public class Task1{

    public static void main(String[] args){
		System.out.println("Задание 1: " + "Hello World!");
		
		int z2 = 2;
		System.out.println("Задание 2: " + z2);
		
		int z3 = 0;
		z3 = z3 + 1;
		z3 += 1;
		++z3;
		System.out.println("Задание 3: " + z3);

		int z4_1 = 4;
		int z4_2 = 44;
		
		var z4_3 = z4_1;
		z4_1 = z4_2;
		z4_2 = z4_3;
		
		z4_1 += z4_2;
		z4_2 = z4_1 - z4_2;
		z4_1 -= z4_2;
		System.out.println("Задание 4: " + z4_1+", "+z4_2);
		
		int z5_1 = 3;
		int z5_2 = 4;
		System.out.println("Задание 5: " + Math.sqrt(z5_1*z5_1 + z5_2*z5_2));
		
		int z6 = 123456;
		System.out.println("Задание 6: " + z6 % 10);
		
		int z7 = 1234576;
		System.out.println("Задание 7: " + (z7 % 100 - z7 % 10)/10);
		
		int z8 = 89;
		System.out.println("Задание 8: " + z8/10);
		
		System.out.println("Задание 9: " + Z9(30));
		
		System.out.println("Задание 10: " + Z10(14, 6));
		
		System.out.println("Задание 11: " + Z11(121, 1));
		
		System.out.println("Задание 12: " + Z12(-2, 19, -2, 7));
    }
	public static int Z9(int z9){
		return z9 - 21;
	}
	public static int Z10(int z10_1, int z10_2){
		return (z10_1 + z10_2)/2;
	}
	public static double Z11(int z11_1, int z11_2){
		return Math.sqrt(z11_1*z11_2);
	}
	public static double Z12(double z12_1, double z12_2, double z12_3, double z12_4){
		var z12_5 = z12_1 - z12_3;
		var z12_6 = z12_2 - z12_4;
		return Math.sqrt(z12_5*z12_5 + z12_6*z12_6);
	}
}
