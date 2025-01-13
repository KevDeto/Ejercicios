package ejercicio4;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class LoginService {
    private Map<String, String> usuarios = new HashMap<>();
    private int intentos = 0;
    private int intentosMaximos = 3;

    public void crearUsuario(String username, String password) {
        usuarios.put(username, password);
    }

    public boolean login(Scanner scanner) {
        while (intentos < intentosMaximos) {
            System.out.print("Ingrese su usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String password = scanner.nextLine();

            if (usuarios.containsKey(username) && usuarios.get(username).equals(password)) {
                System.out.println("Inicio de sesion exitoso.");
                return true;
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intentos restantes: " + (intentosMaximos - intentos));
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoginService that = (LoginService) o;
        return intentos == that.intentos && intentosMaximos == that.intentosMaximos && Objects.equals(usuarios, that.usuarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarios, intentos, intentosMaximos);
    }
}
