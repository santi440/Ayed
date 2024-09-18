package ayed.tp1.ejercicio1;
public class contadores {
	public static void por (int a,int b) {
		for (int i = a;i<=b ; i++) {
			System.out.println(i);
		}
	}
		
	public static void mientras(int a,int b) {
		int contar= a;
		while(contar <= b) {
			System.out.println(contar);
                        contar++;
		}
	}
        
        public static void recursivo (int a,int b){
            if(a<=b){
                System.out.println(a);
                recursivo(a+1,b);
            }
        }
}

