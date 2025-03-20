package a.busqueda_y_estructura_de_datos;

public class InvertirLista {

	static class Node {
		public int elemento;
		public Node siguiente;

		public Node(int elemento) {
			this.elemento = elemento;
			this.siguiente = null;
		}
	}

	static class ListNode {
		Node primera;

		public ListNode() {
			this.primera = null;
		}

		public void agregarAlInicio(int elemento) {
			Node nodo = new Node(elemento);
			nodo.siguiente = this.primera;
			this.primera = nodo;
		}

		public void imprimirLista() {
			Node actual = this.primera;
			while (actual != null) {
				System.out.print(actual.elemento + " -> ");
				actual = actual.siguiente;
			}
			System.out.println("null");
		}

		public void InvertirLista() {
			Node nuevaPrimera = null;
			Node actual = this.primera;
			while (actual != null) {
				Node siguiente = actual.siguiente;
				
				actual.siguiente = nuevaPrimera;
				nuevaPrimera = actual;
				actual = siguiente;
			}
			this.primera = nuevaPrimera;
		}
		public static void main(String[] args) {
			ListNode lista = new ListNode();

			// Agregar elementos a la lista
			lista.agregarAlInicio(3);
			lista.agregarAlInicio(2);
			lista.agregarAlInicio(1);

			System.out.println("Lista original:");
			lista.imprimirLista();

			// Invertir la lista
			lista.InvertirLista();

			System.out.println("Lista invertida:");
			lista.imprimirLista();
		}
	}
}
