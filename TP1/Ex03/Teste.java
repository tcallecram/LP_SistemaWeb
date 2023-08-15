//Marcella Costa Tavares CB302136X
//Victoria Andraus Canoilas Castro CB30211351

class Teste {
	public static void main(String[] args) {
		Author autor = new Author("Marcella e Victoria", "alunas@gmail.com", 'f');
		System.out.println(autor.getName());
		System.out.println(autor.getEmail());
		System.out.println(autor.getGender());
		System.out.println("");
		System.out.println(autor.toString());

		
	}
}