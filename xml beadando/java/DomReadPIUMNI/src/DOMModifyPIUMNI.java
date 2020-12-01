

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.Scanner;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class DOMModifyPIUMNI {

	public static String ReadId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nid:");
		String id = sc.nextLine();
		return id;
	}
	
	public static void CreateXML(Document doc) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("XMLPIUMNI.updated.xml"));
        transformer.transform(source, result);
	}
	
	public static void UpdateCar(Document doc) throws TransformerException {

		System.out.println("\nMelyik jarmuvet szeretn mdostani?\n");

		DomReadPIUMNI.ReadCar(doc);

		String id = ReadId();

		Scanner sc = new Scanner(System.in);
		System.out.print("Jármû fogyasztasa: ");
		String fogyasztas = sc.nextLine();
		System.out.print("Jármû tipusa: ");
		String type = sc.nextLine();
		System.out.print("Jármû szine: ");
		String color = sc.nextLine();
		System.out.print("Jarmu futott km: ");
		String futottkm = sc.nextLine();
		System.out.print("Gyartasi eve : ");
		String year = sc.nextLine();
		
		UpdateCarById(doc, id, fogyasztas, type, color, futottkm, year);
	}

	public static void UpdateCarById(Document doc, String id, String fogyasztas, String type, String color, String futottkm, String gyartasiev) throws TransformerException {

		NodeList nList = doc.getElementsByTagName("jarmu");
		
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nNode;

				String rsz = element.getAttribute("rsz");

				if (rsz.equals(id)) {

					String tulajid = element.getAttribute("tulajid");
					String gyartoid = element.getAttribute("gyartoid");
					
					Node node1 = element.getElementsByTagName("fogyasztas").item(0);
					node1.setTextContent(fogyasztas);

					Node node2 = element.getElementsByTagName("tipus").item(0);
					node2.setTextContent(type);
					
					Node node3 = element.getElementsByTagName("szine").item(0);
					node3.setTextContent(color);
					
					Node node4 = element.getElementsByTagName("futottkm").item(0);
					node4.setTextContent(futottkm);
					
					Node node5 = element.getElementsByTagName("gyartasiev").item(0);
					node5.setTextContent(gyartasiev);
					
					System.out.println(" Rendszam :" + rsz + "\tTulajID id:" + tulajid + "\tGyarto id:"
							+ gyartoid +  "\tFogyasztas: " + node1.getTextContent() + "\tTipus: " + node2.getTextContent()
							+ "\tSzine: " + node3.getTextContent() + "\tfutottkm:" + node4.getTextContent() + "\tgyartasi ev: " + node5.getTextContent());

					System.out.println("A modosítás sikeresen megtörtént \n");
					
				}
			}
		}
		
		CreateXML(doc);
	}
	
	public static void UpdateGyar(Document doc) throws TransformerException {
	
		System.out.println("\nMelyik gyartót szeretné módosítani?\n");

		DomReadPIUMNI.ReadGyar(doc);

		String id = ReadId();

		Scanner sc = new Scanner(System.in);
		System.out.print("Nev: ");
		String name = sc.nextLine();
		System.out.print("Ev: ");
		String year = sc.nextLine();
		System.out.print("Telephely: ");
		String telephely = sc.nextLine();

		UpdategyarById(doc, id, name, year, telephely);		
	}

	public static void UpdategyarById(Document doc, String id, String name, String year, String telephely) throws TransformerException {

		NodeList nList = doc.getElementsByTagName("gyarto");
		
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nNode;

				String gyartoid = element.getAttribute("id");

				if (gyartoid.equals(id)) {

					Node node1 = element.getElementsByTagName("nev").item(0);
					node1.setTextContent(name);

					Node node2 = element.getElementsByTagName("ev").item(0);
					node2.setTextContent(year);
					
					Node node3 = element.getElementsByTagName("telephely").item(0);
					node3.setTextContent(telephely);
					
					System.out.println("Szponzor id:" + gyartoid + "\tNev: " + node1.getTextContent() + "\tev: " + node2.getTextContent()
							+ "\ttelephely: " + node3.getTextContent());
					
					System.out.println("\nModositas sikeresen megtortent\n");
					
				}
			}
		}
		
		CreateXML(doc);
	}
	
	public static void UpdateTulajdonos(Document doc) throws TransformerException {

		System.out.println("\nMelyik tulajdonost szeretne modositani ?\n");

		DomReadPIUMNI.Readtulajdonos(doc);
		
		String id = ReadId();

		Scanner sc = new Scanner(System.in);
		System.out.print("Age : ");
		String age = sc.nextLine();
		System.out.print("jarmuvek szama : ");
		String vehiclenumber = sc.nextLine();
		System.out.print("Telefonszam : ");
		String phonenumber = sc.nextLine();
		System.out.print("Firstname: ");
		String firstname = sc.nextLine();
		System.out.print("Lastname: ");
		String lastname = sc.nextLine();
	
		UpdateTulajdonosById(doc, id, age, vehiclenumber, phonenumber, firstname, lastname);
		
	}

	public static void UpdateTulajdonosById(Document doc, String id, String age, String vehiclenumber, String phonenumber, String firstname, String lastname) throws TransformerException {

		NodeList nList = doc.getElementsByTagName("tulajdonos");
		
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			NodeList cList = nList.item(i).getChildNodes();
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nNode;

				String tulajid = element.getAttribute("id");

				if (tulajid.equals(id)) {

					Node node1 = element.getElementsByTagName("eletkora").item(0);
					node1.setTextContent(age);

					Node node2 = element.getElementsByTagName("jarmuvekszama").item(0);
					node2.setTextContent(vehiclenumber);
					
					Node node3 = element.getElementsByTagName("telefonszama").item(0);
					node3.setTextContent(phonenumber);
			
										
					for (int j = 0; j < cList.getLength(); j++) {

						Node cnode1 = element.getElementsByTagName("vezeteknev").item(0);
						cnode1.setTextContent(firstname);

						Node cnode2 = element.getElementsByTagName("keresztnev").item(0);
						cnode2.setTextContent(lastname);

					}

					System.out.println("Tulajdonos id:" + id + "\tEletkor: " + node1.getTextContent() + "\tJarmuvek szama: " + node2.getTextContent()
							+ "\ttelefonszam: " + node3.getTextContent() +  "\t firstname: " + firstname + " lastname = " + lastname);
										
					System.out.println("\nModositas sikeresen megtortent \n");
					
				}
			}
		}
		
		CreateXML(doc);
	}
	
	
	public static void Updatevezeto(Document doc) throws TransformerException {

		System.out.println("\nMelyik vezetot szeretne modositani ?\n");

		DomReadPIUMNI.Readtulajdonos(doc);
		
		String id = ReadId();

		Scanner sc = new Scanner(System.in);
		System.out.print("Nev : ");
		String nev = sc.nextLine();
		System.out.print("Tapasztalat: ");
		String tapasztalat = sc.nextLine();
		System.out.print("Fizetes : ");
		String salary = sc.nextLine();
	
		UpdateTulajdonosById(doc, id, nev, tapasztalat, salary);
		
	}

	public static void UpdateTulajdonosById(Document doc, String id, String age, String vehiclenumber, String phonenumber) throws TransformerException {

		NodeList nList = doc.getElementsByTagName("cegvezeto");
		
		for (int i = 0; i < nList.getLength(); i++) {

			Node nNode = nList.item(i);

			NodeList cList = nList.item(i).getChildNodes();
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nNode;

				String tulajid = element.getAttribute("id");

				if (tulajid.equals(id)) {

					Node node1 = element.getElementsByTagName("nev").item(0);
					node1.setTextContent(age);

					Node node2 = element.getElementsByTagName("tapasztalat").item(0);
					node2.setTextContent(vehiclenumber);
					
					Node node3 = element.getElementsByTagName("fizetes").item(0);
					node3.setTextContent(phonenumber);
			

					System.out.println("Tulajdonos id:" + id + "\tNev: " + node1.getTextContent() + "\ttapasztalat: " + node2.getTextContent()
							+ "\tfizetes: " + node3.getTextContent());
										
					System.out.println("\nModositas sikeresen megtortent \n");
					
				}
			}
		}
		
		CreateXML(doc);
	}
	
}
