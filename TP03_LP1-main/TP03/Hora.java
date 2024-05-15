import java.util.Scanner;

class Hora {

	private int h;
	private int m;
	private int s;
	private int hora;
	private int min;
	private int seg;

	public Hora (){

		Scanner teclado = new Scanner(System.in);
		int x=0;
		
		do{

		System.out.println("Informe a hora: ");
		h = teclado.nextInt();
	
		if(h < 0 || h > 23){
			System.out.println("Inválido! Digite novamente: ");
			h = teclado.nextInt();}
		}while(h < 0 || h > 23);


		do{

		System.out.println("Informe os minutos: ");
		m = teclado.nextInt();
	
		if(m < 0 || m > 59){
			System.out.println("Inválido! Digite novamente: ");
			m = teclado.nextInt();}

		}while(m < 0 || m > 59);
		

		
		do{

		System.out.println("Informe os segundos: ");
		s = teclado.nextInt();
	
		if(s < 0 || s > 59){
			System.out.println("Inválido! Digite novamente: ");
			s = teclado.nextInt();}

		}while(s < 0 || s > 59);}

	
	public Hora(int h, int m, int s){
		hora = h;
 		min = m;
 		seg = s;

		public void setHor(int h){
	  		 hora = h;}

		public void setMin(int m){
	    		min = m;}

		public void setSeg(int s){
		 	seg = s;}
		
	}
}