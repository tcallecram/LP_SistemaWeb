//Marcella Costa Tavares CB302136X
//Victoria Andraus Canoilas Castro CB30211351
class Teste {
	public static void main(String[] args) {
		Student teste1 = new Student("Marcella Costa Tavares", "Rua CB302136X", "XYZ", 20, 3.0);
		Staff teste2 = new Staff("Victoria Andraus Canoilas Castro", "Rua CB30211351", "Escola GHI", 2100);

		System.out.println(teste1.toString());
		System.out.println(teste2.toString());
	}
}