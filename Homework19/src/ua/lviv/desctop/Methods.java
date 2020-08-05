package ua.lviv.desctop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Methods {

	public static void main(String[] args) throws Exception {
		File file = new File("employeeObjects.txt");
		Employee e = new Employee("Bob", 01, 2500);
		serialize(file, e);
		System.out.println(deserialize(file));

		File file1 = new File("employeeList.txt");
		ArrayList<Employee> a = new ArrayList<Employee>();
		a.add(e);
		a.add(new Employee("Sergio", 02, 4259));
		a.add(new Employee("Romario", 03, 3259));
		serialize(file1, a);
		System.out.println(deserialize(file1));

	}

	public static void serialize(File file, Serializable object) throws Exception {
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		oos.close();
	}

	public static Serializable deserialize(File file) throws Exception {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		Serializable object = (Serializable) ois.readObject();
		ois.close();
		is.close();
		return object;

	}
}
